package gg.troll.report.api.assessment.service;

import gg.troll.report.api.assessment.enums.AssessmentType;
import gg.troll.report.api.assessment.model.dto.AssessmentDto;
import gg.troll.report.api.assessment.model.dto.AssessmentListDto;
import gg.troll.report.api.assessment.model.entity.Assessment;
import gg.troll.report.api.assessment.repository.AssessmentRepository;
import gg.troll.report.base.exception.BaseException;
import gg.troll.report.base.exception.ErrorCode;
import gg.troll.report.base.helper.CryptoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssessmentService {

    @Autowired
    AssessmentRepository assessmentRepository;

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public Assessment createAssessment(long gameId, String accountId, AssessmentType assessmentType, String comment, String password) throws NoSuchAlgorithmException {
        Assessment savedAssessment = assessmentRepository.save(Assessment.builder()
                .gameId(gameId)
                .accountId(accountId)
                .assessmentType(assessmentType)
                .comment(comment)
                .hashedPassword(CryptoHelper.getSha256HashedString(password))
                .deleted(false)
                .build());

        return savedAssessment;
    }

    public Assessment getAssessmentById(long assessmentId) {
        return assessmentRepository.findById(assessmentId).get();
    }

    public AssessmentDto getAssessmentDtoById(long assessmentId) {
        Assessment assessment = getAssessmentById(assessmentId);
        return AssessmentDto.of(assessment);
    }

    public AssessmentListDto getAssessmentListDtoByAccountId(String accountId, long fromAssessmentId, int size) {
        fromAssessmentId = fromAssessmentId == 0 ? Long.MAX_VALUE : fromAssessmentId;
        List<Assessment> assessments = assessmentRepository.findByAccountId(accountId, fromAssessmentId, size);
        List<AssessmentDto> assessmentDtos = assessments.stream()
                .map(AssessmentDto::of)
                .collect(Collectors.toList());

        long lastAssessmentId = 0L;
        boolean allowMore = false;

        if (assessments.size() > 0) {
            lastAssessmentId = assessments.get(assessments.size() - 1).getAssessmentId();
            allowMore = (assessments.size() == size);
        }

        return AssessmentListDto.builder()
                .assessments(assessmentDtos)
                .lastAssessmentId(lastAssessmentId)
                .allowMore(allowMore)
                .build();
    }

    public AssessmentListDto getAssessmentListDtoByGameAndAccountId(long gameId, String accountId, long fromAssessmentId, int size) {
        fromAssessmentId = fromAssessmentId == 0 ? Long.MAX_VALUE : fromAssessmentId;
        List<Assessment> assessments = assessmentRepository.findByGameIdAndAccountId(gameId, accountId, fromAssessmentId, size);
        List<AssessmentDto> assessmentDtos = assessments.stream()
                .map(AssessmentDto::of)
                .collect(Collectors.toList());

        long lastAssessmentId = 0L;
        boolean allowMore = false;

        if (assessments.size() > 0) {
            lastAssessmentId = assessments.get(assessments.size() - 1).getAssessmentId();
            allowMore = (assessments.size() == size);
        }

        return AssessmentListDto.builder()
                .assessments(assessmentDtos)
                .lastAssessmentId(lastAssessmentId)
                .allowMore(allowMore)
                .build();
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void updateAssessmentComment(long assessmentId, String comment, String password) throws NoSuchAlgorithmException {
        Assessment assessment = getAssessmentById(assessmentId);
        String hashedPassword = CryptoHelper.getSha256HashedString(password);
        if (!assessment.getHashedPassword().equals(hashedPassword)) {
            throw new BaseException(ErrorCode.ASSESSMENT_PASSWORD_MISMATCH, "password mismatch");
        }

        assessment.modifyComment(comment);
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void deleteAssessment(long assessmentId, String password) throws NoSuchAlgorithmException {
        Assessment assessment = getAssessmentById(assessmentId);
        String hashedPassword = CryptoHelper.getSha256HashedString(password);
        if (!assessment.getHashedPassword().equals(hashedPassword)) {
            throw new BaseException(ErrorCode.ASSESSMENT_PASSWORD_MISMATCH, "password mismatch");
        }

        assessment.deleteAssessment();
    }

    public long countNotDeletedAssessmentByAccountId(String accountId, AssessmentType assessmentType) {
        return assessmentRepository.countNotDeletedAssessments(accountId, assessmentType);
    }
}

package gg.troll.report.api.assessment.service;

import gg.troll.report.api.assessment.enums.AssessmentType;
import gg.troll.report.api.assessment.model.dto.AssessmentDto;
import gg.troll.report.api.assessment.model.entity.Assessment;
import gg.troll.report.api.assessment.repository.AssessmentRepository;
import gg.troll.report.base.helper.CryptoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class AssessmentService {

    @Autowired
    AssessmentRepository assessmentRepository;

    public long createAssessment(long gameId, String accountId, AssessmentType assessmentType, String comment, String password) throws NoSuchAlgorithmException {
        Assessment savedAssessment = assessmentRepository.save(Assessment.builder()
                .gameId(gameId)
                .accountId(accountId)
                .assessmentType(assessmentType)
                .comment(comment)
                .hashedPassword(CryptoHelper.getSha256HashedString(password))
                .build());

        return savedAssessment.getAssessmentId();
    }

    public Assessment getAssessmentById(long assessmentId) {
        return assessmentRepository.findById(assessmentId).get();
    }

    public AssessmentDto getAssessmentDtoById(long assessmentId) {
        Assessment assessment = getAssessmentById(assessmentId);
        return AssessmentDto.of(assessment);
    }
}

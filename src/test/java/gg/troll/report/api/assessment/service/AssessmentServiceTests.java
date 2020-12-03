package gg.troll.report.api.assessment.service;

import gg.troll.report.api.assessment.enums.AssessmentType;
import gg.troll.report.api.assessment.model.dto.AssessmentDto;
import gg.troll.report.api.assessment.model.dto.AssessmentListDto;
import gg.troll.report.api.assessment.model.entity.Assessment;
import gg.troll.report.api.assessment.repository.AssessmentRepository;
import gg.troll.report.base.helper.CryptoHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-test.properties")
@SpringBootTest
public class AssessmentServiceTests {

    @Autowired
    AssessmentRepository assessmentRepository;
    @Autowired
    AssessmentService assessmentService;

    @Test
    public void Assessment를_생성한다() throws NoSuchAlgorithmException {
        long testGameId = 1L;
        String testAccountId = "test account id";
        AssessmentType testAssessmentType = AssessmentType.REPORT;
        String testComment = "test comment";
        String testPassword = "test hashed password";

        Assessment savedAssessment = assessmentService.createAssessment(testGameId, testAccountId, testAssessmentType, testComment, testPassword);

        Assessment testAssessment = assessmentRepository.findById(savedAssessment.getAssessmentId()).get();

        assertThat(testAssessment.getGameId()).isEqualTo(testGameId);
        assertThat(testAssessment.getAccountId()).isEqualTo(testAccountId);
        assertThat(testAssessment.getAssessmentType()).isEqualTo(testAssessmentType);
        assertThat(testAssessment.getComment()).isEqualTo(testComment);
        assertThat(testAssessment.getHashedPassword()).isEqualTo(CryptoHelper.getSha256HashedString(testPassword));
    }

    @Test
    public void Id로_AssessmentDto를_조회한다() {
        long testGameId = 1L;
        String testAccountId = "test account id";
        AssessmentType testAssessmentType = AssessmentType.REPORT;
        String testComment = "test comment";
        String testHashedPassword = "test hashed password";

        Assessment savedAssessment = assessmentRepository.save(Assessment.builder()
                .gameId(testGameId)
                .accountId(testAccountId)
                .assessmentType(testAssessmentType)
                .comment(testComment)
                .hashedPassword(testHashedPassword)
                .build());

        AssessmentDto testAssessmentDto = assessmentService.getAssessmentDtoById(savedAssessment.getAssessmentId());

        assertThat(testAssessmentDto.getGameId()).isEqualTo(testGameId);
        assertThat(testAssessmentDto.getAccountId()).isEqualTo(testAccountId);
        assertThat(testAssessmentDto.getAssessmentType()).isEqualTo(testAssessmentType);
        assertThat(testAssessmentDto.getComment()).isEqualTo(testComment);
    }

    @Test
    public void gameId와_accountId로_평가를_최신순으로_조회한다() {
        final int NUM_OF_ASSESSMENTS = 5;
        long testGameId = 1L;
        String testAccountId = "test account id";
        AssessmentType testAssessmentType = AssessmentType.REPORT;
        String testHashedPassword = "test hashed password";
        List<String> testComments = new ArrayList<>();
        List<Assessment> assessments = new ArrayList<>();

        for (int i = 0; i < NUM_OF_ASSESSMENTS; i++) {
            String testComment = "test comment " + i;
            testComments.add(testComment);
            assessments.add(assessmentRepository.save(Assessment.builder()
                    .gameId(testGameId)
                    .accountId(testAccountId)
                    .assessmentType(testAssessmentType)
                    .comment(testComment)
                    .hashedPassword(testHashedPassword)
                    .build()));
        }

        long fromAssessmentId = 0L;
        int size = 3;
        AssessmentListDto assessmentListDto = assessmentService.getAssessmentListDto(testGameId, testAccountId, fromAssessmentId, size);
        assertThat(assessmentListDto.getAssessments().get(0).getComment()).isEqualTo(testComments.get(NUM_OF_ASSESSMENTS-1));
        assertThat(assessmentListDto.getLastAssessmentId()).isEqualTo(assessments.get(NUM_OF_ASSESSMENTS-size).getAssessmentId());
        assertThat(assessmentListDto.isAllowMore()).isTrue();
    }
}

package gg.troll.report.api.assessment.repository;

import gg.troll.report.api.assessment.enums.AssessmentType;
import gg.troll.report.api.assessment.model.entity.Assessment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application-test.properties")
@DataJpaTest
public class AssessmentRepositoryTests {

    @Autowired
    AssessmentRepository assessmentRepository;

    @Test
    public void 평가를_생성하고_조회한다() {
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

        Assessment testBoard = assessmentRepository.findById(savedAssessment.getAssessmentId()).get();

        assertThat(testBoard.getGameId()).isEqualTo(testGameId);
        assertThat(testBoard.getAccountId()).isEqualTo(testAccountId);
        assertThat(testBoard.getAssessmentType()).isEqualTo(testAssessmentType);
        assertThat(testBoard.getComment()).isEqualTo(testComment);
        assertThat(testBoard.getHashedPassword()).isEqualTo(testHashedPassword);
    }
}

package gg.troll.report.api.assessment.service;

import gg.troll.report.api.assessment.enums.AssessmentType;
import gg.troll.report.api.assessment.model.dto.AssessmentDto;
import gg.troll.report.api.assessment.model.entity.Assessment;
import gg.troll.report.api.assessment.repository.AssessmentRepository;
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
public class AssessmentServiceTests {

    @Autowired
    AssessmentRepository assessmentRepository;
    @Autowired
    AssessmentService assessmentService;

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
}

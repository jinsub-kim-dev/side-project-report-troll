package gg.troll.report.api.assessment.service;

import gg.troll.report.api.assessment.model.dto.AssessmentDto;
import gg.troll.report.api.assessment.model.entity.Assessment;
import gg.troll.report.api.assessment.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessmentService {

    @Autowired
    AssessmentRepository assessmentRepository;

    public Assessment getAssessmentById(long assessmentId) {
        return assessmentRepository.findById(assessmentId).get();
    }

    public AssessmentDto getAssessmentDtoById(long assessmentId) {
        Assessment assessment = getAssessmentById(assessmentId);
        return AssessmentDto.of(assessment);
    }
}

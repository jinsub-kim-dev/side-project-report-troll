package gg.troll.report.api.controller;

import gg.troll.report.api.assessment.model.dto.AssessmentDto;
import gg.troll.report.api.assessment.service.AssessmentService;
import gg.troll.report.base.model.CodeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1/assessment")
public class AssessmentController {

    @Autowired
    AssessmentService assessmentService;

    @GetMapping("/id")
    @ResponseBody
    public CodeResponse getAssessmentById(@RequestParam long assessmentId) {
        AssessmentDto assessmentDto = assessmentService.getAssessmentDtoById(assessmentId);
        return CodeResponse.successResult(assessmentDto);
    }
}

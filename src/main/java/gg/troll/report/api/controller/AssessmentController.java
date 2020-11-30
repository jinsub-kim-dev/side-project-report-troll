package gg.troll.report.api.controller;

import gg.troll.report.api.assessment.model.dto.AssessmentDto;
import gg.troll.report.api.assessment.model.dto.AssessmentListDto;
import gg.troll.report.api.assessment.model.request.AssessmentCommentRequest;
import gg.troll.report.api.assessment.model.request.AssessmentDeleteRequest;
import gg.troll.report.api.assessment.service.AssessmentService;
import gg.troll.report.base.model.CodeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

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

    @GetMapping("/list/account/game")
    @ResponseBody
    public CodeResponse getAssessmentListByGameAndAccountId(
            @RequestParam long gameId,
            @RequestParam String accountId,
            @RequestParam(defaultValue = "0") long fromAssessmentId,
            @RequestParam(defaultValue = "10") int size) {
        AssessmentListDto assessmentListDto = assessmentService.getAssessmentListDto(gameId, accountId, fromAssessmentId, size);
        return CodeResponse.successResult(assessmentListDto);
    }

    @PutMapping("/comment")
    @ResponseBody
    public CodeResponse updateAssessmentComment(@RequestBody AssessmentCommentRequest request) throws NoSuchAlgorithmException {
        assessmentService.updateAssessmentComment(request.getAssessmentId(), request.getComment(), request.getPassword());
        return CodeResponse.success();
    }

    @DeleteMapping("/id")
    @ResponseBody
    public CodeResponse deleteAssessment(@RequestBody AssessmentDeleteRequest request) throws NoSuchAlgorithmException {
        assessmentService.deleteAssessment(request.getAssessmentId(), request.getPassword());
        return CodeResponse.success();
    }
}

package gg.troll.report.api.controller;

import gg.troll.report.base.model.CodeResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1/cors")
public class CorsController {

    @GetMapping("/test")
    @ResponseBody
    @ApiOperation(value = "CrossOrigin 허용하지 않은 API, 호출 성공 시 성공 메시지를 반환.", response = CodeResponse.class)
    public CodeResponse corsTest() {
        String successMessage = "CORS Test Success!";
        return CodeResponse.successResult(successMessage);
    }
}

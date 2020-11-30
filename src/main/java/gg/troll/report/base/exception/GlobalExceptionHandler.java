package gg.troll.report.base.exception;

import gg.troll.report.base.model.CodeResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    public CodeResponse handleException(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Exception exception) {

        ErrorCode errorCode;

        if (exception instanceof BaseException) {
            errorCode = ((BaseException) exception).getErrorCode();
        } else {
            errorCode = ErrorCode.UNKNOWN;
        }

        return CodeResponse.failCodeMessage(errorCode.getErrorCode(), errorCode.getMessage());
    }
}

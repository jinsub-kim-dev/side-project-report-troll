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
        String message;

        if (exception instanceof RiotRestApiTemplateException) {
            errorCode = ((RiotRestApiTemplateException) exception).getErrorCode();
            message = ((RiotRestApiTemplateException) exception).getMessage();
        } else if (exception instanceof BaseException) {
            errorCode = ((BaseException) exception).getErrorCode();
            message = ((BaseException) exception).getMessage();
        } else {
            errorCode = ErrorCode.UNKNOWN;
            message = errorCode.getDefaultMessage();
        }

        return CodeResponse.failCodeMessage(errorCode.getErrorCode(), message);
    }
}

package gg.troll.report.base.exception;

import org.apache.http.HttpResponse;

public class RiotRestApiTemplateException extends BaseException {
    private static final long serialVersionUID = -7914670157247506334L;

    public RiotRestApiTemplateException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public RiotRestApiTemplateException(ErrorCode errorCode, Throwable throwable) {
        super(errorCode, throwable);
    }

    public RiotRestApiTemplateException(ErrorCode errorCode, String message, Throwable throwable) {
        super(errorCode, message, throwable);
    }

    public static RiotRestApiTemplateException of(HttpResponse response) {
        String message = response.getStatusLine().getReasonPhrase();
        ErrorCode errorCode = ErrorCode.of(ErrorCode.RIOT_REST_API_TEMPLATE_FAIL.getErrorCode() + response.getStatusLine().getStatusCode());
        return new RiotRestApiTemplateException(errorCode, message);
    }
}

package gg.troll.report.base.exception;

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
}

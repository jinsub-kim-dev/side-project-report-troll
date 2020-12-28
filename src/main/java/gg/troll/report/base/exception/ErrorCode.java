package gg.troll.report.base.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    ASSESSMENT_PASSWORD_MISMATCH(501, "assessment.password.mismatch"),
    UNKNOWN(999, "unexpected.exception"),

    RIOT_REST_API_TEMPLATE_FAIL(1000, "riot.rest.api.template.fail"),
    RIOT_REST_API_BAD_REQUEST(1400, "riot.rest.api.bad.request"),
    RIOT_REST_API_UNAUTHORIZED(1401, "riot.rest.api.unauthorized"),
    RIOT_REST_API_FORBIDDEN(1403, "riot.rest.api.forbidden"),
    RIOT_REST_API_DATA_NOT_FOUND(1404, "riot.rest.api.data.not.found"),
    RIOT_REST_API_METHOD_NOT_ALLOWED(1405, "riot.rest.api.method.not.allowed"),
    RIOT_REST_API_UNSUPPORTED_MEDIA_TYPE(1415, "riot.rest.api.unsupported.media.type"),
    RIOT_REST_API_RATE_LIMIT_EXCEEDED(1429, "riot.rest.api.rate.limit.exceeded"),
    RIOT_REST_API_INTERNAL_SERVER_ERROR(1500, "riot.rest.api.internal.server.error"),
    RIOT_REST_API_BAD_GATEWAY(1502, "riot.rest.api.bad.gateway"),
    RIOT_REST_API_SERVICE_UNAVAILABLE(1503, "riot.rest.api.service.unavailable"),
    RIOT_REST_API_GATEWAY_TIMEOUT(1504, "riot.rest.api.gateway.timeout");

    int errorCode;
    String defaultMessage;

    ErrorCode(int errorCode, String defaultMessage) {
        this.errorCode = errorCode;
        this.defaultMessage = defaultMessage;
    }

    public static ErrorCode of(int errorCode) {
        for (ErrorCode code : values()) {
            if (code.getErrorCode() == errorCode) {
                return code;
            }
        }
        return ErrorCode.UNKNOWN;
    }
}

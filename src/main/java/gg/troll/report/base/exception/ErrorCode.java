package gg.troll.report.base.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    RIOT_REST_API_TEMPLATE_FAIL(500, "riot.rest.api.template.fail"),
    ASSESSMENT_PASSWORD_MISMATCH(501, "assessment.password.mismatch"),
    UNKNOWN(999, "unexpected.exception");

    int errorCode;
    String defaultMessage;

    ErrorCode(int errorCode, String defaultMessage) {
        this.errorCode = errorCode;
        this.defaultMessage = defaultMessage;
    }
}

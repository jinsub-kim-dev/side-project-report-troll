package gg.troll.report.base.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    ASSESSMENT_PASSWORD_MISMATCH(501, "assessment.password.mismatch"),
    UNKNOWN(999, "unexpected.exception");

    int errorCode;
    String message;

    ErrorCode(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}

package com.efub.lakkulakku.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

	/* Common */
	// Basic - C0***
	RUNTIME_EXCEPTION(BAD_REQUEST, "C0001", "RUNTIME_EXCEPTION"),

	// Diary - C1***
	DUPLICATE_DIARY_DATE(CONFLICT, "C1001", "DUPLICATE_DIARY_EXISTS"),
	DIARY_NOT_FOUND(NOT_FOUND, "C1002", "DIARY_NOT_FOUND"),
	BAD_DATE_REQUEST(BAD_REQUEST, "C1003", "BAD_DATE_REQUEST"),

	// User - C2***
	DUPLICATE_NICKNAME(CONFLICT, "C2001", "DUPLICATE_NICKNAME_EXISTS"),
	DUPLICATE_EMAIL(CONFLICT, "C2002", "DUPLICATE_EMAIL_EXISTS"),
	USER_NOT_FOUND(NOT_FOUND, "C2003", "USER_NOT_FOUND"),

	// Friend - C3***
	DUPLICATE_FRIEND(CONFLICT, "C3001", "DUPLICATE_FRIEND_EXISTS"),


    // Exception
    S3_UPLOAD_FAILURE(INTERNAL_SERVER_ERROR, "E0001", "NETWORK_FAILURE"),
    FILE_UPLOAD_FAILURE(BAD_REQUEST, "E0002", "WRONG_FILE_TYPE"),
    TOKEN_VALIDATE_FAILURE(BAD_REQUEST, "E1001", "INVALID_TOKEN"),
    TOKEN_EXPIRED(BAD_REQUEST, "E1002", "TOKEN_EXPIRED"),

    //SUCCESS
    LOGOUT_SUCCESS(OK, "S0001", "LOGOUT_SUCCESS");

    private final HttpStatus status;
    private final String code;
    private final String message;
}

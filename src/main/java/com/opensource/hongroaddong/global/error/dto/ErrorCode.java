package com.opensource.hongroaddong.global.error.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

	// 400 BAD_REQUEST: 잘못된 요청
	BAD_REQUEST(HttpStatus.BAD_REQUEST, "C-0000", "Bad Request"),

	// 404 NOT_FOUND: 리소스를 찾을 수 없음
	NOT_FOUND(HttpStatus.NOT_FOUND, "C-0001", "Not Found the Contents"),

	// 405 METHOD_NOT_ALLOWED: 허용되지 않은 Request Method 호출
	METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "C-0002", "Method Not Allowed"),

	// 500 INTERNAL_SERVER_ERROR: 내부 서버 오류
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "C-0003", "Internal Server Error"),

	// MEMBER
	MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "M-0000", "Not Found Member"),

	// CAR
	CAR_NOT_FOUND(HttpStatus.NOT_FOUND, "C-0000", "Not Found Car"),

	// FILE
	FILE_EMPTY_ERROR(HttpStatus.BAD_REQUEST, "F-0000", "File Empty Error"),
	FILE_UPLOAD_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "F-0001", "File Upload Error"),
	FILE_MAX_UPLOAD_SIZE_EXCEED(HttpStatus.INTERNAL_SERVER_ERROR, "F-0002", "File Upload Size Exceeded");

	private final HttpStatus status;
	private final String code;
	private final String message;
}

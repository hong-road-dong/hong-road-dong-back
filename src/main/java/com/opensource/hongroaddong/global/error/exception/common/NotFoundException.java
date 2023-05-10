package com.opensource.hongroaddong.global.error.exception.common;

import com.opensource.hongroaddong.global.error.dto.ErrorCode;

public class NotFoundException extends BusinessException {
	public NotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}

	public NotFoundException(ErrorCode errorCode, String content) {
		super(errorCode, content + " is not found");
	}
}

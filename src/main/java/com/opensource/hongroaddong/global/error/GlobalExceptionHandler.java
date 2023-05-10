package com.opensource.hongroaddong.global.error;

import com.opensource.hongroaddong.global.error.dto.ErrorResponseDto;
import com.opensource.hongroaddong.global.error.exception.common.BusinessException;
import com.opensource.hongroaddong.global.error.exception.common.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	@ExceptionHandler(BusinessException.class)
	protected ResponseEntity<ErrorResponseDto> handleBusinessException (
			final BusinessException e,
			final HttpServletRequest request
	) {
		log.error("BusinessException: {} {}", e.getErrorCode(), request.getRequestURL());
		return ResponseEntity
				.status(e.getErrorCode().getStatus().value())
				.body(new ErrorResponseDto(e.getErrorCode()));
	}

	@ExceptionHandler(NotFoundException.class)
	protected ResponseEntity<ErrorResponseDto> handleNotFoundException (
			final NotFoundException e,
			final HttpServletRequest request) {

		log.error("NotFoundException: {} {}", e.getErrorCode(), request.getRequestURL());
		return ResponseEntity
				.status(e.getErrorCode().getStatus().value())
				.body(new ErrorResponseDto(e.getErrorCode()));
	}
}

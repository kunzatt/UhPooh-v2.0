package com.ssafy.uhpooh.global.error.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

	// Common
	INVALID_INPUT_VALUE(400, "잘못된 입력값입니다"),
	INTERNAL_SERVER_ERROR(500, "서버 오류가 발생했습니다"),
	UNAUTHORIZED(401, "인증되지 않은 접근입니다"),
	FORBIDDEN(403, "권한이 없습니다"),
	INVALID_ENUM_VALUE(400, "잘못된 상태값입니다");

	private final int status;
	private final String message;
}

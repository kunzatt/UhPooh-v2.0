package com.ssafy.uhpooh.global.error.exception;

import com.ssafy.uhpooh.global.error.code.ErrorCode;

public class PlaceException extends BusinessException {
  public PlaceException(ErrorCode errorCode) {
    super(errorCode);
  }
}

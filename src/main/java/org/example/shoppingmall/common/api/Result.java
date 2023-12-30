package org.example.shoppingmall.common.api;

import lombok.Builder;
import lombok.Getter;
import org.example.shoppingmall.common.error.ErrorCode;
import org.example.shoppingmall.common.error.ErrorCodeInterface;

@Getter
@Builder
public class Result {
  private final int resultCode;
  private final String resultMessage;
  private final String resultDescription;

  public static Result ok() {
    return new Result(ErrorCode.OK.getErrorCode(), ErrorCode.OK.getDescription(), "The request was successful.");
  }

  public static Result ERROR(ErrorCodeInterface errorCode) {
    return new Result(
        errorCode.getErrorCode(),
        errorCode.getDescription(),
        "The request was failed."
    );
  }

  public static Result ERROR(ErrorCodeInterface errorCode, Throwable throwable) {
    return new Result(
        errorCode.getErrorCode(),
        throwable.getLocalizedMessage(),
        errorCode.getDescription()
    );
  }

  public static Result ERROR(ErrorCodeInterface errorCode, String description) {
    return new Result(
        errorCode.getErrorCode(),
        description,
        errorCode.getDescription()
    );
  }
}
package org.example.shoppingmall.common.exception;

import lombok.Getter;
import org.example.shoppingmall.common.error.ErrorCodeInterface;

@Getter
public class ApiException extends RuntimeException implements ApiExceptionInterface {
  private final ErrorCodeInterface errorCodeInterface;
  private final String errorDescription;

  public ApiException(ErrorCodeInterface errorCodeInterface, String errorDescription) {
    super(errorCodeInterface.getDescription());
    this.errorCodeInterface = errorCodeInterface;
    this.errorDescription = errorDescription;
  }

  public ApiException(ErrorCodeInterface errorCodeInterface, Throwable tx) {
    super(tx);
    this.errorCodeInterface = errorCodeInterface;
    this.errorDescription = errorCodeInterface.getDescription();
  }

  public ApiException(ErrorCodeInterface errorCodeInterface, Throwable tx, String errorDescription) {
    super(tx);
    this.errorCodeInterface = errorCodeInterface;
    this.errorDescription = errorDescription;
  }
}

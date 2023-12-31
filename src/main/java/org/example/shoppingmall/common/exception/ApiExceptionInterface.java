package org.example.shoppingmall.common.exception;

import org.example.shoppingmall.common.error.ErrorCodeInterface;

public interface ApiExceptionInterface {
  ErrorCodeInterface getErrorCodeInterface();

  String getErrorDescription();
}

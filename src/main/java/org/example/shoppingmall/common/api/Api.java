package org.example.shoppingmall.common.api;

import lombok.*;
import org.example.shoppingmall.common.error.ErrorCodeInterface;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Api<T> {
  private Result result;
  private T body;

  public static <T> Api<T> OK(T data) {
    var api = new Api<T>();
    api.result = Result.ok();
    api.body = data;
    return api;
  }

  public static Api<Object> ERROR(Result result) {
    var api = new Api();
    api.result = result;
    return api;
  }

  public static Api<Object> ERROR(ErrorCodeInterface errorCodeInterface) {
    var api = new Api();
    api.result = Result.ERROR(errorCodeInterface);
    return api;
  }

  public static Api<Object> ERROR(ErrorCodeInterface errorCodeInterface, Throwable tx) {
    var api = new Api();
    api.result = Result.ERROR(errorCodeInterface, tx);
    return api;
  }

  public static Api<Object> ERROR(ErrorCodeInterface errorCodeInterface, String description) {
    var api = new Api();
    api.result = Result.ERROR(errorCodeInterface, description);
    return api;
  }
}
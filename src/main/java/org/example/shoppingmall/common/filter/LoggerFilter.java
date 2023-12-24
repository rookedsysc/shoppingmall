package org.example.shoppingmall.common.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.stream.Collectors;

@Slf4j
@Component
public class LoggerFilter implements Filter {
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    var req = new ContentCachingRequestWrapper((HttpServletRequest) request);
    var res = new ContentCachingResponseWrapper((HttpServletResponse) response);

    ///# Do Filter 기준으로 실행 전과 실행 후가 나뉜다.
    chain.doFilter(req, res);

    // request 정보
    var headerNames = req.getHeaderNames();
    var headerValues = new StringBuilder();

    /// TODO: asIterator() 란?
    headerNames.asIterator().forEachRemaining(headerKey -> {
      var headerValue = req.getHeader(headerKey);
      // authorization-token : ??? , user-agent : ???
      headerValues
        .append("[")
        .append(headerKey)
        .append(" : ")
        .append(headerValue).append("]");
    });

    var requestBody = new String(req.getContentAsByteArray());
    var uri = req.getRequestURI();
    var method = req.getMethod();
    log.info(">>>>> uri : {} , method : {} , header : {} , body : {}", uri, method, headerValues, requestBody);

    var responseHeaderValues = new StringBuilder();

    res.getHeaderNames().forEach((headerKey) -> {
      var headerValue = res.getHeader(headerKey);
      responseHeaderValues.append("[").append(headerKey).append(" : ").append(headerValue).append("]");
    });

    var responseBody = new String(res.getContentAsByteArray());
    log.info("<<<<< uri : {} , method : {} , header : {} , body : {}", uri, method, responseHeaderValues, responseBody);

    res.copyBodyToResponse();
  }
}
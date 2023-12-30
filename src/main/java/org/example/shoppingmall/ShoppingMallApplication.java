package org.example.shoppingmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ShoppingMallApplication {

  public static void main(String[] args) {
    SpringApplication.run(ShoppingMallApplication.class, args);
  }
}

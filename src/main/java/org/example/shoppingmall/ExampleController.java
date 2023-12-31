package org.example.shoppingmall;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {
  @GetMapping("/ex")
  public String showExample() {
    return "ex/ex";
  }
}

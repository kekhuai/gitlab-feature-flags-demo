package com.ascendcorp.commerce.cptms.gitlabfeatureflagsdemo.dog;

import java.util.Collections;
import java.util.List;

import io.getunleash.Unleash;
import io.getunleash.UnleashContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/dogs")
public class DogController {

  private final Unleash unleash;

  public DogController(Unleash unleash) {
    this.unleash = unleash;
  }

  @GetMapping
  List<String> getAllDogs() {
    var context = UnleashContext.builder().userId("kekhuai").build();
    if (unleash.isEnabled("flag1", context)) {
      System.out.println("enabled");
    } else {
      System.out.println("disabled");
    }
    return Collections.emptyList();
  }
}

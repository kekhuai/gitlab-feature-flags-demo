package com.ascendcorp.commerce.cptms.gitlabfeatureflagsdemo.config;

import io.getunleash.DefaultUnleash;
import io.getunleash.Unleash;
import io.getunleash.util.UnleashConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  Unleash unleash() {
    var config = UnleashConfig.builder()
            .appName("Development")
            .instanceId("23x5d7p-HVx-34isZzH2")
            .unleashAPI("https://gitlab.weomni.com/api/v4/feature_flags/unleash/760")
//            .environment("Development")
            .synchronousFetchOnInitialisation(true)
            .build();
    return new DefaultUnleash(config);
  }
}

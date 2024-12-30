package com.fsc.opentelemetrydemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OpentelemetryDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(OpentelemetryDemoApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(JaegerExample jaegerExample) {
    return args -> jaegerExample.run();
  }

}

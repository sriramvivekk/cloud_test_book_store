package com.bookmarket.catalogservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "polar")
public record PolarProperties(String greetings) {

}

package com.bookmarket.catalogservice;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookmarket.catalogservice.config.PolarProperties;

@RefreshScope
@RestController
public class HomeController {
    private final PolarProperties polarProperties;

    public HomeController(PolarProperties polarProperties) {
        this.polarProperties = polarProperties;
    }

    @GetMapping("/")
    public String getGreeting() {
        return polarProperties.greetings();
    }
}

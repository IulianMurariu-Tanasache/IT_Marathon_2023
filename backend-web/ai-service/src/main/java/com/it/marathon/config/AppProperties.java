package com.it.marathon.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("app")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppProperties {
    private String loadBalancerURI;
}

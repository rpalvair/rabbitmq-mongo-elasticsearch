package com.palvair.elascticsearch.config;

import com.palvair.elascticsearch.ViewService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by widdy on 28/11/2015.
 */
@Configuration
public class ElasticConfig {

    @Bean
    public ViewService viewService() {
        return new ViewService();
    }
}

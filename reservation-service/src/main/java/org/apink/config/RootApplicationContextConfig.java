package org.apink.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@ComponentScan(basePackages = {
        "org.apink.mapper",
        "org.apink.service"
})
@Import({DbConfig.class})
public class RootApplicationContextConfig {
	
	
}

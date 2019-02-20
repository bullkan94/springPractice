package com.example.demo;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@ComponentScan(basePackages= {"spring", "com.example.demo"},
includeFilters= {
		@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)
		})
public class RootConfig {

}

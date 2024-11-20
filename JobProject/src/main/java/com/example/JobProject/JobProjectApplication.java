package com.example.JobProject;

import org.mapstruct.MapperConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication(scanBasePackages = "com.example.JobProject")
public class JobProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(JobProjectApplication.class, args);
	}

}

@Configuration
class Config {
	@Bean
	public CommonsRequestLoggingFilter requestLoggingFilter() {
		CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
		loggingFilter.setIncludePayload(true);
		loggingFilter.setIncludeHeaders(true);
		loggingFilter.setIncludeQueryString(false);
		loggingFilter.setIncludeClientInfo(true);
		loggingFilter.setMaxPayloadLength(10000);
		return loggingFilter;
	}
}


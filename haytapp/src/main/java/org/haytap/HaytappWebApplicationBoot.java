package org.haytap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class HaytappWebApplicationBoot extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(HaytappWebApplicationBoot.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplicationBuilder(
				HaytappWebApplicationBoot.class).build();
		app.run(args);
	}
}

package com.ssafy.uhpooh.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
			.info(new Info()
				.title("Uhpooh API Documentation")
				.description("<h3>Uhpooh Reference for Developers </h3>Swagger를 이용한 Bookiki API")
				.version("v1.0")
				.contact(new Contact()
					.name("Support Team")
					.email("kunzatt2501@gmail.com")
					.url("https://github.com/kunzatt/UhPooh-v2.0"))
				.license(new License()
					.name("Uhpooh License")
					.url("https://github.com/kunzatt/UhPooh-v2.0")))
			.externalDocs(new ExternalDocumentation()
				.description("Uhpooh Documentation")
				.url("https://github.com/kunzatt/UhPooh-v2.0"))
			.servers(List.of(
				new Server().url("").description("Local server")
			));
			// .components(new Components()
			// 	.addSecuritySchemes("bearerAuth",
			// 		new SecurityScheme()
			// 			.type(SecurityScheme.Type.HTTP)
			// 			.scheme("bearer")
			// 			.bearerFormat("JWT")
			// 			.in(SecurityScheme.In.HEADER)))
			// .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
	}

	// /**
	//  * Swagger에서 @CurrentUser AuthUser authUser를 자동으로 제거하여 JSON 입력 없이 Bearer Token을 기반으로 인증 가능하게 설정
	//  */
	// @Bean
	// public OperationCustomizer customizeOperation() {
	// 	return (operation, handlerMethod) -> {
	// 		List<Parameter> parameters = operation.getParameters();
	// 		if (parameters != null) {
	// 			parameters.removeIf(param -> param.getName().equals("authUser"));
	// 		}
	// 		return operation;
	// 	};
	// }
}

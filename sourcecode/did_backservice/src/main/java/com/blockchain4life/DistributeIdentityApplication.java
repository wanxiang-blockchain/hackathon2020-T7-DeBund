package com.blockchain4life;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

@SpringBootApplication
public class DistributeIdentityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributeIdentityApplication.class, args);
	}

}
@Configuration
@EnableSwagger2
class Swagger2 {
	@Bean
	public Docket createRestApi() {
		Parameter parameter = new ParameterBuilder().name("创新北外滩-楼宇管理·接口文档")
				.description("test模式下调用者的uuid")
				.modelRef(new ModelRef("string"))
				.parameterType("header")
				.required(false).build();

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors
				.basePackage("com.blockchain4life")).paths(PathSelectors.any()).build().globalOperationParameters(Arrays.asList(parameter));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("分布式身份,平台端").description("Distribute Identity")
				.version("0.1")
				.build();
	}
}
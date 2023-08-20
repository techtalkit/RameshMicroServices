package net.techtalkit.organizationservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient
@OpenAPIDefinition(
		info=@Info(
				title="Organization Service Rest APIs",
				description = "Organization Service Rest Api Documentation",
				version="v1.0",
				contact=@Contact(
						name="Shafaat",
						email="techtalkitco@gmail.com",
						url="https://www.javaguides.com"
				),
				license = @License(
						name="Apache 2.0",
						url="www.techtalkit.co"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Organization service doc",
				url="www.techtalkit.com"
		)
)
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}

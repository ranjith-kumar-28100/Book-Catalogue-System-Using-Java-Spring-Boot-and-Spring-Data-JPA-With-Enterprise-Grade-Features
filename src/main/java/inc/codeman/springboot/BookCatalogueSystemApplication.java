package inc.codeman.springboot;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

@OpenAPIDefinition(info = @Info(title = "Book Catalogue Management System", description = "Spring Boot REST APIs for Book Catalogue Management System", version = "v1.0", contact = @Contact(name = "Ranjith Kumar G", url = "https://www.linkedin.com/in/ranjith-kumar-govindarajan-1aa707173/", email = "codemanrkg@gmail.com"), license = @License(name = "Apache 2.0", url = "https://www.linkedin.com/in/ranjith-kumar-govindarajan-1aa707173/")), externalDocs = @ExternalDocumentation(description = "Spring Boot REST Example", url = "https://spring.io/guides/gs/rest-service/"))
public class BookCatalogueSystemApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(BookCatalogueSystemApplication.class, args);
	}

}

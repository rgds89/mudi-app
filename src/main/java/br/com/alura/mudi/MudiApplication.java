package br.com.alura.mudi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class MudiApplication {
	public static void main(String[] args) {
		SpringApplication.run(MudiApplication.class, args);
	}

}

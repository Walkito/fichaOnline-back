package br.com.walkito.fichaOnline;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FichaOnlineApplication {

	public static void main(String[] args) {
		Dotenv.configure().load();
		SpringApplication.run(FichaOnlineApplication.class, args);
	}

}

package br.com.walkito.fichaOnline;

import br.com.walkito.fichaOnline.config.S3Config;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FichaOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(FichaOnlineApplication.class, args);
	}

}

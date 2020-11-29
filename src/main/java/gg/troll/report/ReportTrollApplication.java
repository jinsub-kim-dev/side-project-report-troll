package gg.troll.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ReportTrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportTrollApplication.class, args);
	}

}

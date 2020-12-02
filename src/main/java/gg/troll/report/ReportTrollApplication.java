package gg.troll.report;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication(scanBasePackages = {"gg.troll.report"})
public class ReportTrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportTrollApplication.class, args);
	}

}

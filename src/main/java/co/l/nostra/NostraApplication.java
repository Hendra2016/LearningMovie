package co.l.nostra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "co.l.nostra" })
public class NostraApplication extends SpringBootServletInitializer {
	private static Class<NostraApplication> application = NostraApplication.class;

	public static void main(String[] args) {
		SpringApplication.run(NostraApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(application);
	}
}

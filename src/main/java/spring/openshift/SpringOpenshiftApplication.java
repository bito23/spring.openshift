package spring.openshift;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@EntityScan(basePackageClasses = { SpringOpenshiftApplication.class })

public class SpringOpenshiftApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOpenshiftApplication.class, args);
	}

}

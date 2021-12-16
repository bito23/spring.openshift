package spring.openshift;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication()
@EntityScan(basePackageClasses = { SpringOpenshiftApplication.class })

public class SpringOpenshiftApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOpenshiftApplication.class, args);
	}

}

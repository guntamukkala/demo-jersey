package demo;

import javax.inject.Named;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import demo.endpoint.IlJugMemberEndPoint;

@SpringBootApplication
public class DemoApplication {
	
	@Named
    public static class JerseyConfig extends ResourceConfig {

        public JerseyConfig() {
            this.register(IlJugMemberEndPoint.class);
            this.register(JacksonFeature.class);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

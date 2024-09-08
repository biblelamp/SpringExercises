package docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * By https://medium.com/@balloon.helps/spring-boot-3-deploy-on-docker-02f9bb93b268
 *
 * Use docker command:
 *   docker build -t docker-app .
 *   docker images
 *   docker container ls
 *   docker run -d -p 8080:8080 --name myapp-container docker-app
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

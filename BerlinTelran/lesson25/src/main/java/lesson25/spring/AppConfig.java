package lesson25.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CameraRoll cameraRoll() {
        return new ColorCameraRoll();
    }

    @Bean
    public Camera camera(CameraRoll cameraRoll) {
        Camera camera = new Camera();
        camera.setCameraRoll(cameraRoll);
        return camera;
    }
}

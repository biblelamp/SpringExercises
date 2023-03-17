package spring;

import example.Camera;
import example.CameraRoll;
import example.ColorCameraRoll;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CameraRoll colorCameraRoll() {
        return new ColorCameraRoll();
    }

//    @Bean
//    public CameraRoll bwCameraRoll() {
//        return new BlackWhiteCameraRoll();
//    }

    @Bean
    public Camera camera(CameraRoll cameraRoll) {
        Camera camera = new Camera();
        camera.setCameraRoll(cameraRoll);
        return camera;
    }
}

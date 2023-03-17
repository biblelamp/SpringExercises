package spring;

import example.Camera;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Camera camera = context.getBean("camera", Camera.class);
        //ameraRoll bwCameraRoll = context.getBean("bwCameraRoll", CameraRoll.class);
        camera.takePicture();

//        camera.setCameraRoll(bwCameraRoll);
//        camera.takePicture();
    }
}

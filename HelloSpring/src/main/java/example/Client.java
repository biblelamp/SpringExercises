package example;

public class Client {
    public static void main(String[] args) {
        CameraRoll colorCameraRoll = new ColorCameraRoll();
        CameraRoll bwCameraRoll = new BlackWhiteCameraRoll();

        Camera camera = new Camera();
        camera.setCameraRoll(colorCameraRoll);
        camera.takePicture();

        camera.setCameraRoll(bwCameraRoll);
        camera.takePicture();
    }
}

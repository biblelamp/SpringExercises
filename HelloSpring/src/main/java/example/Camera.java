package example;

public class Camera {
    private CameraRoll cameraRoll;

    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    public void takePicture() {
        System.out.println("Click!");
        cameraRoll.processing();
    }
}

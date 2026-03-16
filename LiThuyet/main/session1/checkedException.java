package LiThuyet.main.session1;

public class checkedException extends Exception {
    String message;
    int code;
    public checkedException(String message, int code){
        this.message = message;
        this.code = code;
    }
}

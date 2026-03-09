package LiThuyet.session1;

import java.io.IOException;
import java.util.Scanner;

public class demo {

    public static double divide(double a, double b) {
        return a / b;
    }

    static class TrilangEx extends Exception {
        public TrilangEx(String message) {
            super(message);
        }
    }

    public static void checkAge(int age) throws TrilangEx {
        // Checked Exception
        // phương thức này có thể phát sinh ngoại lệ TrilangEx
        // nên khi gọi hàm phải:
        // - try-catch
        // hoặc
        // - khai báo throws tiếp

        if (age < 0 || age > 200) {
            throw new TrilangEx("tuoi khong hop le");
        }
    }

    static class AgeException extends RuntimeException {

        // Unchecked Exception
        // không bắt buộc xử lí
        // không cần throws
        // không bắt buộc try-catch

        public AgeException(String message) {
            super(message);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("3/5 = " + divide(3, 5));
        // nếu b = 0 -> kết quả Infinity (số thực)
        // nếu parse số sai: Integer.parseInt("String") -> NumberFormatException

        checkedException cke = new checkedException("tam giac khong hop le", 101);
        uncheckedException uce = new uncheckedException("day la unchceckedException");

        // throw và throws

        // -- throw dùng để ném ra một ngoại lệ chỉ định, thông thương có thể sử dụng
        // với exception tự định nghĩa

        // -- throws dùng để khai bóa ngoiaj lệ có thể sinh ra trên một phương thức ,
        System.out.println("tuoi cua ban");
        int age = 1800;
        try {
            checkAge(1800);
        } catch (TrilangEx e) {
            System.out.println(e.getMessage());
        }
        if (age > 300) {
            throw new AgeException("tuoi khong hợp lệ");
        }

        // được sử dụng chủ yếu với checckedException
        // public void readLife() throws IOException {

        // }

        /*
         * ===================== HỆ THỐNG NGOẠI LỆ TRONG JAVA =====================
         * 
         * Object // Lớp cha của tất cả class trong Java
         * │
         * └── Throwable // Lớp cha của mọi lỗi và ngoại lệ (có thể throw/catch)
         * │
         * ├── Error // Lỗi nghiêm trọng của JVM, thường không xử lý
         * │ │
         * │ ├── OutOfMemoryError // JVM hết bộ nhớ
         * │ ├── StackOverflowError // Tràn stack do đệ quy quá sâu
         * │ └── LinkageError // Lỗi khi liên kết class lúc runtime
         * │
         * └── Exception // Các lỗi chương trình có thể xử lý
         * │
         * ├── RuntimeException // Unchecked Exception (không bắt buộc try-catch)
         * │ │
         * │ ├── IllegalArgumentException // Truyền tham số không hợp lệ
         * │ │ │
         * │ │ ├── NumberFormatException // Chuỗi không chuyển được sang số
         * │ │ └── ArithmeticException // Lỗi toán học (vd: chia cho 0 với số nguyên)
         * │ │
         * │ └── IndexOutOfBoundsException // Truy cập index vượt giới hạn
         * │ └── ArrayIndexOutOfBoundsException // Sai index trong mảng
         * │
         * └── IOException // Checked Exception (phải try-catch hoặc throws)
         * │
         * ├── FileNotFoundException // Không tìm thấy file
         * └── SocketException // Lỗi khi làm việc với mạng
         * 
         * =========================================================================
         * 
         */
        // try
        // │
        // │ lỗi xảy ra
        // ▼
        // catch bắt được ?
        // │
        // ├─ Có → xử lý → chương trình chạy tiếp
        // │
        // └─ Không → chương trình dừng
    }
}
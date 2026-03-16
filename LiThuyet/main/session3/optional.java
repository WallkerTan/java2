package LiThuyet.main.session3;

import java.util.Optional;

public class optional {
    
    // 1. Demo tạo Optional
    public static void demoCreate() {

        Optional<String> op1 = Optional.empty(); // Optional rỗng

        Optional<String> op2 = Optional.of("Java"); // bắt buộc không null

        Optional<String> op3 = Optional.ofNullable(null); // có thể null

        System.out.println(op1);
        System.out.println(op2);
        System.out.println(op3);
    }

    // 2. kiểm tra có giá trị hay không
    public static void demoIsPresent() {

        Optional<String> op = Optional.of("Hello");

        if (op.isPresent()) {
            System.out.println("Co gia tri");
        } else {
            System.out.println("Rong");
        }
    }

    // 3. lấy giá trị
    public static void demoGet() {

        Optional<String> op = Optional.of("Java");

        String value = op.get(); // lấy giá trị bên trong Optional

        System.out.println(value);
    }

    // 4. orElse - giá trị mặc định nếu null
    public static void demoOrElse() {

        Optional<String> op = Optional.ofNullable(null);

        String result = op.orElse("Default value");

        System.out.println(result);
    }

    // 5. ifPresent - chạy code nếu có giá trị
    public static void demoIfPresent() {

        Optional<String> op = Optional.of("Stream API");

        op.ifPresent(value -> {
            System.out.println("Gia tri: " + value);
        });
    }

    // 6. map - biến đổi giá trị bên trong Optional
    public static void demoMap() {

        Optional<String> op = Optional.of("java");

        Optional<String> upper = op.map(s -> s.toUpperCase());

        System.out.println(upper);
    }

    // 7. filter - lọc giá trị
    public static void demoFilter() {

        Optional<Integer> op = Optional.of(10);

        Optional<Integer> result = op.filter(n -> n > 5);

        System.out.println(result);
    }
}

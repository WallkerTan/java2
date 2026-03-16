package LiThuyet.main.session3;

public class Java17Demo {

    public static void main(String[] args) {

        demoRecord();
        demoSwitchExpression();
        demoTextBlock();
        demoPatternMatching();
        demoSealedClass();

    }

    // 1. Demo Record
    public static void demoRecord() {

        Person p = new Person("Tan", 20);

        System.out.println("Name: " + p.name());
        System.out.println("Age: " + p.age());

    }

    // 2. Demo Switch Expression
    public static void demoSwitchExpression() {

        int day = 3;

        String result = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Other";
        };

        System.out.println(result);
    }

    // 3. Demo Text Block (chuỗi nhiều dòng)
    public static void demoTextBlock() {

        String html = """
                <html>
                    <body>
                        <h1>Hello Java 17</h1>
                    </body>
                </html>
                """;

        System.out.println(html);

    }

    // 4. Demo Pattern Matching instanceof
    public static void demoPatternMatching() {

        Object obj = "Java17";

        if (obj instanceof String s) {
            System.out.println(s.toUpperCase());
        }

    }

    // 5. Demo Sealed Class
    public static void demoSealedClass() {

        Animal a = new Dog();

        System.out.println(a.getClass().getSimpleName());

    }

}


// record
record Person(String name, int age) {}


// sealed class
sealed class Animal permits Dog, Cat {}

final class Dog extends Animal {}

final class Cat extends Animal {}
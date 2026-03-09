import java.time.LocalDate;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

/*
    ================================
    INTERFACE CÓ DEFAULT + STATIC
    ================================
*/
interface Vehicle {

    // abstract method (functional interface style)
    void run();

    // default method (Java 8)
    // class implement không bắt buộc override
    default void stop(){
        System.out.println("Vehicle is stopping...");
    }

    // static method
    // chỉ gọi qua tên interface
    static void info(){
        System.out.println("Vehicle interface static method");
    }
}

/*
    ================================
    CLASS IMPLEMENT INTERFACE
    ================================
*/
class Car implements Vehicle{

    // bắt buộc implement abstract method
    @Override
    public void run(){
        System.out.println("Car is running...");
    }

    // override default method nếu muốn
    @Override
    public void stop(){
        System.out.println("Car stopped!");
    }
}

/*
    ================================
    CUSTOM FUNCTIONAL INTERFACE
    ================================
*/
@FunctionalInterface
interface Calculator{

    // chỉ có 1 abstract method
    int calculate(int a, int b);

    // có thể có default method
    default void info(){
        System.out.println("Calculator Functional Interface");
    }
}

/*
    ================================
    CLASS MODEL
    ================================
*/
class Student{

    String name;
    int age;
    double score;

    public Student(String name, int age, double score){
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public double getScore(){
        return score;
    }

    @Override
    public String toString(){
        return name + " - age:" + age + " - score:" + score;
    }
}

/*
    ================================
    MAIN PROGRAM
    ================================
*/
public class demojava8 {

    public static void main(String[] args) {

        /*
        ===================================================
        1. DEFAULT METHOD + STATIC METHOD
        ===================================================
        */

        Car car = new Car();

        car.run();     // abstract method
        car.stop();    // default method (override)

        Vehicle.info(); // static method của interface



        /*
        ===================================================
        2. LAMBDA EXPRESSION + FUNCTIONAL INTERFACE
        ===================================================
        */

        // Lambda implement functional interface

        Calculator add = (a, b) -> a + b;

        Calculator multiply = (a, b) -> a * b;

        System.out.println("Add: " + add.calculate(5,3));
        System.out.println("Multiply: " + multiply.calculate(5,3));



        /*
        ===================================================
        3. BUILT-IN FUNCTIONAL INTERFACE
        ===================================================
        */

        // Predicate<T>
        // nhận 1 giá trị -> trả boolean

        Predicate<Integer> isEven = x -> x % 2 == 0;

        System.out.println("10 is even? " + isEven.test(10));


        // Function<T,R>
        // nhận T -> trả R

        Function<String,Integer> getLength = s -> s.length();

        System.out.println("Length: " + getLength.apply("Java8"));


        // Consumer<T>
        // nhận T -> không trả gì

        Consumer<String> printer = s -> System.out.println("Print: " + s);

        printer.accept("Hello Java");


        // Supplier<T>
        // không nhận -> trả T

        Supplier<Double> randomNumber = () -> Math.random();

        System.out.println("Random: " + randomNumber.get());



        /*
        ===================================================
        4. METHOD REFERENCE
        ===================================================
        */

        // lambda
        Function<String,Integer> parse1 = s -> Integer.parseInt(s);

        // method reference
        Function<String,Integer> parse2 = Integer::parseInt;

        System.out.println(parse2.apply("123"));


        // object::method

        Consumer<String> print1 = s -> System.out.println(s);

        Consumer<String> print2 = System.out::println;

        print2.accept("Hello Method Reference");



        /*
        ===================================================
        5. LIST + COMPARATOR + LAMBDA
        ===================================================
        */

        List<Student> students = new ArrayList<>();

        students.add(new Student("An",20,8.5));
        students.add(new Student("Binh",19,7.2));
        students.add(new Student("Cuong",21,9.1));
        students.add(new Student("Dung",18,6.8));


        // sort theo score dùng lambda

        students.sort((s1,s2) -> Double.compare(s2.score, s1.score));

        System.out.println("\nSort by score:");

        students.forEach(System.out::println);



        /*
        ===================================================
        6. STREAM API
        ===================================================
        */

        System.out.println("\nStudents score > 7:");

        List<Student> goodStudents =
                students.stream()
                        .filter(s -> s.score > 7)   // lọc
                        .collect(Collectors.toList());

        goodStudents.forEach(System.out::println);


        /*
        map() -> biến đổi dữ liệu
        */

        System.out.println("\nStudent names:");

        List<String> names =
                students.stream()
                        .map(Student::getName)
                        .collect(Collectors.toList());

        names.forEach(System.out::println);



        /*
        reduce() -> tính tổng
        */

        double totalScore =
                students.stream()
                        .map(Student::getScore)
                        .reduce(0.0, Double::sum);

        System.out.println("\nTotal score: " + totalScore);



        /*
        ===================================================
        7. OPTIONAL (tránh NullPointerException)
        ===================================================
        */

        Optional<Student> result =
                students.stream()
                        .filter(s -> s.name.equals("An"))
                        .findFirst();

        result.ifPresent(System.out::println);



        /*
        ===================================================
        8. DATE TIME API (java.time)
        ===================================================
        */

        LocalDate today = LocalDate.now();

        LocalDate birthday = LocalDate.of(2005,5,20);

        System.out.println("\nToday: " + today);

        System.out.println("Birthday: " + birthday);

        System.out.println("After 10 days: " + today.plusDays(10));



        /*
        ===================================================
        9. PARALLEL STREAM
        ===================================================
        */

        long count =
                students.parallelStream()
                        .filter(s -> s.score > 7)
                        .count();

        System.out.println("\nStudents score >7 : " + count);

    }
}
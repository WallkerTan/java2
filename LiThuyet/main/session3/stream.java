package LiThuyet.main.session3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class stream {
    

    public static List<String> createDumyData() {
        int max = 1000000;
        List<String> m = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            m.add(uuid.toString());
        }
        return m;
    }

    public static void demoClassicStream() {

        List<String> values = createDumyData();

        long starttime = System.nanoTime();

        long count = values.stream().sorted().count();

        System.out.println(count);

        long endtime = System.nanoTime();

        long milis = TimeUnit.NANOSECONDS.toMillis(endtime - starttime);

        System.out.println(String.format("tg chay: %d", milis));
    }

    public static void demoStreamFilter() {

        List<Integer> B = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> A = new ArrayList<>();

        for (Integer n : B) {
            if (n % 2 == 0) {
                A.add(n);
            }
        }

        List<Integer> C = B.stream().filter(n -> n % 2 == 0).toList();

        System.out.println(A);
        System.out.println(C);
    }

    public static void demoStreamMap() {

        List<String> names = Arrays.asList("java", "python", "c++");

        List<String> upper = names.stream()
                .map(s -> s.toUpperCase())
                .toList();

        System.out.println(upper);
    }

    public static void demoStreamSorted() {

        List<Integer> list = Arrays.asList(5, 3, 1, 4, 2);

        List<Integer> sorted = list.stream()
                .sorted()
                .toList();

        System.out.println(sorted);
    }

    public static void demoStreamDistinct() {

        List<Integer> list = Arrays.asList(1, 2, 2, 3, 3, 4, 5);

        List<Integer> result = list.stream()
                .distinct()
                .toList();

        System.out.println(result);
    }

    public static void demoStreamLimit() {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        List<Integer> result = list.stream()
                .limit(3)
                .toList();

        System.out.println(result);
    }

    public static void demoStreamReduce() {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        int sum = list.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println(sum);
    }

    public static void demoStreamMatch() {

        List<Integer> list = Arrays.asList(2, 4, 6, 8);

        boolean allEven = list.stream()
                .allMatch(n -> n % 2 == 0);

        System.out.println(allEven);
    }

    public static void demoStreamFind() {

        List<Integer> list = Arrays.asList(5, 7, 9, 10, 11);

        int firstEven = list.stream()
                .filter(n -> n % 2 == 0)
                .findFirst()
                .orElse(-1);

        System.out.println(firstEven);
    }

    public static void demoParallelStream() {

        List<String> values = createDumyData();

        long start = System.nanoTime();

        long count = values.parallelStream().sorted().count();

        long end = System.nanoTime();

        long ms = TimeUnit.NANOSECONDS.toMillis(end - start);

        System.out.println("parallel count: " + count);
        System.out.println("tg chay: " + ms);
    }
}

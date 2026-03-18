package LiThuyet.main.session6;

public class thread {
    public static void main(String[] args) {
        Innerthread t1 = new Innerthread(10);
        Innerthread2 task = new Innerthread2(10);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Lambda thread");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("bug");
                }
            }
        });

        Data data = new Data();

        Producer p = new Producer(data);
        Consumer c = new Consumer(data);

        p.start();
        c.start();

        // t3.start();
        // t1.start();
        // t2.start();
    }

    public static class Innerthread2 implements Runnable {

        private int count;

        public Innerthread2(int count) {
            this.count = count;
        }

        @Override
        public void run() {
            for (int i = 0; i < count; i++) {
                System.out.println("Runnable thread");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("bug");
                }
            }
        }
    }

    public static class Innerthread extends Thread {

        private int count;

        public Innerthread(int count) {
            this.count = count;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("haha");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println("bug");
                }
            }
            System.out.println("tan dz");
        }

    }

    static class Data {
        private int value;
        private boolean available = false;

        public synchronized void produce(int v) {

            // Nếu đã có dữ liệu chưa được consume
            // producer phải chờ consumer lấy dữ liệu trước
            while (available) {
                try {
                    wait();
                    // wait():
                    // - thread hiện tại (producer) tạm dừng
                    // - nhả lock của object Data
                    // - chuyển sang trạng thái WAITING
                    // - chờ thread khác gọi notify()/notifyAll()
                } catch (Exception e) {
                }
            }

            value = v;
            System.out.println("Produced: " + value);

            available = true;

            notify();
            // notify():
            // - đánh thức 1 thread đang wait() trên object này
            // - thường là consumer đang chờ dữ liệu
            // - thread được đánh thức sẽ tiếp tục chạy khi lấy lại được lock
        }

        public synchronized void consume() {

            // Nếu chưa có dữ liệu
            // consumer phải chờ producer tạo dữ liệu
            while (!available) {
                try {
                    wait();
                    // wait():
                    // - consumer tạm dừng
                    // - nhả lock của object Data
                    // - chờ producer gọi notify()
                } catch (Exception e) {
                }
            }

            System.out.println("Consumed: " + value);

            available = false;

            notify();
            // notify():
            // - đánh thức producer đang wait()
            // - cho phép producer tạo dữ liệu mới
        }
    }

    static class Producer extends Thread {
        private Data data;

        public Producer(Data data) {
            this.data = data;
        }

        public void run() {
            for (int i = 1; i <= 5; i++) {
                data.produce(i);
            }
        }
    }

    static class Consumer extends Thread {
        private Data data;

        public Consumer(Data data) {
            this.data = data;
        }

        public void run() {
            for (int i = 1; i <= 5; i++) {
                data.consume();
            }
        }
    }
}

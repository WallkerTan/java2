package src.main.session6;

import java.util.LinkedList;
import java.util.Queue;


//kho vé
class TicketPool {
    private static Queue<Ticket> tickets = new LinkedList<>();
    private int nextID = 0;

    public TicketPool() {
        addticket(10);
    }

    // bán vé
    public synchronized Ticket sellTicket() {
        while (tickets.isEmpty()) {
            try {
                // in thread đang chạy , tức là hết vé , bị kẹt
                // tức là thread nào hết vé trước thì thông báo
                System.out.println(Thread.currentThread().getName() + "waiting...");

                // hết vé thì tạm dừng
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Ticket t = tickets.poll();
        t.setActive(true);
        return t;

    }

    // thêm vé
    public synchronized void addticket(int num) {
        for (int i = 0; i < num; i++) {
            tickets.add(new Ticket());
        }
        System.out.println("da them " + num + " ve vao kho.");

        // có vé rồi tất cả bán tiếp
        notifyAll();

    }

    public synchronized int getCountTicket() {
        return tickets.size();
    }
}

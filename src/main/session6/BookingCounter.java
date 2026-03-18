package src.main.session6;


//quầy bán vé
class BookingCounter implements Runnable {
    private String name;
    private TicketPool pool;
    private int soldCount = 0;

    public BookingCounter(String name, TicketPool pool) {
        this.name = name;
        this.pool = pool;
    }

    @Override
    public void run() {
        while (true) {
            Ticket t = pool.sellTicket();

            if (t != null) {
                this.soldCount++;
                System.out.println(name + " sold: " + t.getCode());
            }

            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}
package src.main.session6;

class TicketSupplier implements Runnable {
    private TicketPool pool;
    private int count;
    private int delay;

    public TicketSupplier(TicketPool pool, int count, int delay) {
        this.pool = pool;
        this.count = count;
        this.delay = delay;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(delay);
            } catch (Exception e) {
            }

            pool.addticket(count);
        }
    }
}
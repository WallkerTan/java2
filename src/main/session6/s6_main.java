package src.main.session6;

public class s6_main {
    public static void main(String[] args) {
        //tạo kho
        TicketPool pool = new TicketPool();
        //tạo 2 quầy
        Thread counter1 = new Thread(new BookingCounter("Counter 1", pool));
        Thread counter2 = new Thread(new BookingCounter("Counter 2", pool));


        //tạo ng cung cấp
        Thread supplier = new Thread(new TicketSupplier(pool, 5, 3000));

        counter1.start();
        counter2.start();
        supplier.start();
        
    }
}

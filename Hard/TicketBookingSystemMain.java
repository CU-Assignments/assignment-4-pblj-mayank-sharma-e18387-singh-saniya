class TicketBookingSystem {
    private static int availableSeats = 10;

    public synchronized void bookTicket(String customerType) {
        if (availableSeats > 0) {
            System.out.println(customerType + " is booking a ticket...");
            try {
                // Simulate booking process
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            availableSeats--;
            System.out.println(customerType + " has successfully booked a ticket.");
            System.out.println("Remaining seats: " + availableSeats);
        } else {
            System.out.println("No seats available for " + customerType);
        }
    }
}

class BookingThread extends Thread {
    private TicketBookingSystem ticketBookingSystem;
    private String customerType;

    public BookingThread(TicketBookingSystem ticketBookingSystem, String customerType) {
        this.ticketBookingSystem = ticketBookingSystem;
        this.customerType = customerType;
    }

    @Override
    public void run() {
        ticketBookingSystem.bookTicket(customerType);
    }
}

public class TicketBookingSystemMain {
    public static void main(String[] args) {
        TicketBookingSystem ticketBookingSystem = new TicketBookingSystem();
        
        // Creating VIP booking thread with higher priority
        BookingThread vipBooking = new BookingThread(ticketBookingSystem, "VIP");
        vipBooking.setPriority(Thread.MAX_PRIORITY);
        
        // Creating regular booking threads with normal priority
        BookingThread regularBooking1 = new BookingThread(ticketBookingSystem, "Regular");
        BookingThread regularBooking2 = new BookingThread(ticketBookingSystem, "Regular");

        // Starting threads
        vipBooking.start();
        regularBooking1.start();
        regularBooking2.start();
    }
}

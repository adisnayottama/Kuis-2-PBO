package id.ac.polinema.quiz2;

import java.util.ArrayList;
import java.util.List;

/**
 * Tempat bebas untuk mencoba programmu. Kelas ini TIDAK dinilai.
 *
 * Ide percobaan (tulis sendiri setelah tiap tahap selesai):
 *  1. Buat satu Customer, lalu coba ubah namanya.
 *  2. Buat satu RegularLaundry dan satu ExpressLaundry, lalu tampilkan harga-nya.
 *  3. Masukkan keduanya ke OrderCalculator.totalPrice(...) lewat sebuah List.
 *  4. Buat LaundryDesk dengan new ConsoleReceiptPrinter(), tambahkan pesanan laundry, lalu panggil checkout(...).
 *
 * Jalankan lewat NetBeans (Run Project), VS Code (Run di atas main),
 * atau terminal: mvn -q compile exec:java
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(" UJI COBA LAUNDRY ");

        // 1. Buat Customer 
        Customer customer = new Customer("C001", "Budi");
        customer.setName("Cak Budi");
        System.out.println("Customer: " + customer.getName() + " (" + customer.getCustomerId() + ")");

        // 2. RegularLaundry dan ExpressLaundry (berat 5 kg)
        LaundryOrder regular = new RegularLaundry("L1", customer, 5.0);
        LaundryOrder express = new ExpressLaundry("L2", customer, 5.0);

        System.out.println("Regular Laundry Price (5 kg): " + regular.calculatePrice());
        System.out.println("Express Laundry Price (5 kg): " + express.calculatePrice());
        
        if (express instanceof Deliverable) {
            System.out.println("Express Delivery Fee: " + ((Deliverable) express).deliveryFee());
        }

        // 3. Masukkan ke OrderCalculator
        List<LaundryOrder> orders = new ArrayList<>();
        orders.add(regular);
        orders.add(express);

        System.out.println("Total Price of all orders: " + OrderCalculator.totalPrice(orders));
        System.out.println("Total Delivery Fee: " + OrderCalculator.totalDelivery(orders));

        // 4. LaundryDesk dengan ConsoleReceiptPrinter
        ReceiptPrinter printer = new ConsoleReceiptPrinter();
        LaundryDesk desk = new LaundryDesk(printer);

        desk.add(regular);
        desk.add(express);

        System.out.println("Total orders in desk: " + desk.count());

        // 5. Checkout pesanan L1
        System.out.println("Checkout untuk L1:");
        desk.checkout("L1");
    }
}

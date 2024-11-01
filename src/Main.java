import java.util.Scanner;

class Ticket {
    private String name;
    private String date;
    private double price;
    private int quantity;

    public Ticket(String name, String date, double price, int quantity) {
        this.name = name;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean buyTicket(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
            return true;
        } else {
            return false;
        }
    }
}

class PenjualanTiket {
    public static void main(String[] args) {
        Ticket concert1 = new Ticket("Concert A", "20 October 2024", 150.0, 100);
        Ticket concert2 = new Ticket("Concert B", "25 October 2024", 200.0, 50);

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=== Penjualan Tiket Konser ===");
            System.out.println("1. Lihat detail tiket");
            System.out.println("2. Beli tiket");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nTiket Tersedia:");
                    printTicketDetails(concert1);
                    printTicketDetails(concert2);
                    break;
                case 2:
                    System.out.print("\nPilih konser (1 atau 2): ");
                    int concertChoice = scanner.nextInt();

                    Ticket selectedTicket = (concertChoice == 1) ? concert1 : concert2;

                    System.out.print("Jumlah tiket yang ingin dibeli: ");
                    int quantity = scanner.nextInt();

                    if (selectedTicket.buyTicket(quantity)) {
                        double totalPrice = getTotalPrice(selectedTicket, quantity);
                        System.out.println("Pembelian berhasil! Total harga: $" + totalPrice);
                    } else {
                        System.out.println("Maaf, tiket tidak cukup tersedia.");
                    }
                    break;
                case 3:
                    isRunning = false;
                    System.out.println("Terima kasih telah menggunakan layanan kami!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }

        scanner.close();
    }

    private static double getTotalPrice(Ticket selectedTicket, int quantity) {
        return selectedTicket.getPrice() * quantity;
    }

    public static void printTicketDetails(Ticket ticket) {
        System.out.println("Nama: " + ticket.getName());
        System.out.println("Tanggal: " + ticket.getDate());
        System.out.println("Harga: $" + ticket.getPrice());
        System.out.println("Stok: " + ticket.getQuantity());
        System.out.println();
    }
}

package src;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Cinema cinema = new Cinema("Nama Lengkap Anda", 10);
        Scanner scanner = new Scanner(System.in);
        User currentUser = null;

        while (true) {
            System.out.println("1. Daftar");
            System.out.println("2. Masuk");
            System.out.println("3. Lihat Daftar Studio");
            System.out.println("4. Lihat Detail Studio");
            System.out.println("5. Topup Saldo");
            System.out.println("6. Pesan Tiket");
            System.out.println("7. Lihat Tiket Saya");
            System.out.println("8. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (choice) {
                case 1:
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Nama Lengkap: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Saldo Awal: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine(); // Konsumsi newline

                    User newUser = new User(email, password, fullName, balance);
                    if (cinema.registerUser(newUser)) {
                        System.out.println("Pendaftaran berhasil.");
                    } else {
                        System.out.println("Pendaftaran gagal.");
                    }
                    break;

                case 2:
                    System.out.print("Email: ");
                    email = scanner.nextLine();
                    System.out.print("Password: ");
                    password = scanner.nextLine();

                    currentUser = cinema.authenticateUser(email, password);
                    if (currentUser != null) {
                        System.out.println("Masuk berhasil. Selamat datang, " + currentUser.getFullName());
                    } else {
                        System.out.println("Masuk gagal. Email atau password salah.");
                    }
                    break;

                case 3:
                    cinema.displayListStudios();
                    break;

                case 4:
                    System.out.print("Nomor Studio: ");
                    int studioNumber = scanner.nextInt();
                    scanner.nextLine(); // Konsumsi newline

                    cinema.displayStudioDetail(studioNumber);
                    break;

                case 5:
                    if (currentUser != null) {
                        System.out.print("Jumlah Topup: ");
                        double amount = scanner.nextDouble();
                        scanner.nextLine(); // Konsumsi newline

                        currentUser.topUp(amount);
                        System.out.println("Topup berhasil. Saldo baru: " + currentUser.getBalance());
                    } else {
                        System.out.println("Anda harus masuk terlebih dahulu.");
                    }
                    break;

                case 6:
                    if (currentUser != null) {
                        System.out.print("Nomor Studio: ");
                        studioNumber = scanner.nextInt();
                        System.out.print("Baris: ");
                        int row = scanner.nextInt();
                        System.out.print("Kolom: ");
                        int col = scanner.nextInt();
                        scanner.nextLine(); // Konsumsi newline

                        if (cinema.bookTicket(currentUser, studioNumber, row, col)) {
                            System.out.println("Pemesanan tiket berhasil.");
                        } else {
                            System.out.println("Pemesanan tiket gagal.");
                        }
                    } else {
                        System.out.println("Anda harus masuk terlebih dahulu.");
                    }
                    break;

                case 7:
                    if (currentUser != null) {
                        currentUser.displayAllTickets();
                    } else {
                        System.out.println("Anda harus masuk terlebih dahulu.");
                    }
                    break;

                case 8:
                    System.out.println("Terima kasih telah menggunakan Anjayy Cinema. Selamat tinggal!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opsi tidak valid. Silakan coba lagi.");
            }
        }
    }
}


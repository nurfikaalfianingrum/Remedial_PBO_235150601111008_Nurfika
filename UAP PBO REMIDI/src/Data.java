import java.util.ArrayList;
import java.util.Scanner;

public class Data {
    private static ArrayList<Tanaman> tanamans = new ArrayList<>();
    private static ArrayList<Integer> lokasi = new ArrayList<>();

    public static void mulai() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan masa tanam (bulan): ");
        int bulan = scanner.nextInt();
        int hari = bulan * 30;

        menanam();
        menanam();
        menanam();

        for (int i = 1; i <= hari; i++) {
            for (int j = 0; j < tanamans.size(); j++) {
                Tanaman tanaman = tanamans.get(j);
                if (tanaman.status().equals("Hidup")) {
                    tanaman.berkembang();
                } else if (!lokasi.contains(j)) {
                    lokasi.add(j);
                }

                if (lokasi.contains(j)) {
                    continue;
                }

                if (i % 90 == 0 && tanaman.status().equals("Hidup")) {
                    ((Perawatan) tanaman).treatment();
                }
            }

            for (int loc : lokasi) {
                tanamans.remove(loc);
                menanam();
            }
            lokasi.clear();
        }
    }

    public static void menanam() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mau menanam apa?: 1. Tomat 2. Stroberi 3. Persik");
        int pilihan = scanner.nextInt();
        Tanaman tanaman = null;

        switch (pilihan) {
            case 1:
                tanaman = new Tomat();
                break;
            case 2:
                tanaman = new Stroberi();
                break;
            case 3:
                tanaman = new Persik();
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }

        tanamans.add(tanaman);
        System.out.println("Berhasil menanam " + tanaman.getClass().getSimpleName());
    }

    public static void info() {
        System.out.println("Laporan Hasil Masa Tanam:");
        for (int i = 0; i < tanamans.size(); i++) {
            Tanaman tanaman = tanamans.get(i);
            System.out.println("Tanaman ke-" + (i + 1) + ":");
            System.out.println(tanaman.toString());
            System.out.println("------------------------------------");
        }
    }
}

package src;
public class Utils {
    public static double getTicketPrice(String studioType) {
        switch (studioType) {
            case "Imax":
                return 100_000;
            case "Premiere":
                return 120_000;
            case "Reguler":
                return 50_000;
            default:
                throw new IllegalArgumentException("Tipe studio tidak valid");
        }
    }
}

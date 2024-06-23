package src;

public class Studio {
    private Movie movie;
    private String type;
    private boolean[][] seats;

    public Studio(Movie movie, String type) {
        this.movie = movie;
        this.type = type;
        setSeats();
    }

    private void setSeats() {
        switch (type) {
            case "Imax":
                seats = new boolean[8][9];
                break;
            case "Premiere":
                seats = new boolean[6][4];
                break;
            case "Reguler":
                seats = new boolean[5][5];
                break;
            default:
                throw new IllegalArgumentException("Tipe studio tidak valid");
        }
    }

    public int isBooked(int row, int col) {
        if (row >= seats.length || col >= seats[0].length) {
            return -1;
        }
        return seats[row][col] ? 1 : 0;
    }

    public String getStudioInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Film: ").append(movie.getTitle()).append("\n")
            .append("Tipe: ").append(type).append("\n")
            .append("Harga Tiket: ").append(Utils.getTicketPrice(type)).append("\n")
            .append("Tempat Duduk:\n");

        for (boolean[] row : seats) {
            for (boolean seat : row) {
                info.append(seat ? "X " : "O ");
            }
            info.append("\n");
        }

        return info.toString();
    }

    public boolean reserve(int row, int col) {
        if (row >= seats.length || col >= seats[0].length) {
            return false;
        }
        if (!seats[row][col]) {
            seats[row][col] = true;
            return true;
        }
        return false;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getType() {
        return type;
    }
}


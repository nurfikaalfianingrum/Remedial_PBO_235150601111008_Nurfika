package src;
import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private String name;
    private List<User> listUsers;
    private List<Studio> listStudios;
    private int studioCapacity;

    public Cinema(String name, int studioCapacity) {
        this.name = name;
        this.studioCapacity = studioCapacity;
        this.listUsers = new ArrayList<>();
        this.listStudios = new ArrayList<>(studioCapacity);
        init();
    }

    public boolean registerUser(User user) {
        return listUsers.add(user);
    }

    public User authenticateUser(String email, String password) {
        for (User user : listUsers) {
            if (user.isMatch(email, password)) {
                return user;
            }
        }
        return null;
    }

    public void displayListStudios() {
        for (int i = 0; i < listStudios.size(); i++) {
            Studio studio = listStudios.get(i);
            System.out.println("Studio " + (i + 1) + ": " + studio.getType() + ", Film: " + studio.getMovie().getTitle());
        }
    }

    public void displayStudioDetail(int studioNumber) {
        if (studioNumber > 0 && studioNumber <= listStudios.size()) {
            Studio studio = listStudios.get(studioNumber - 1);
            System.out.println(studio.getStudioInfo());
        } else {
            System.out.println("Nomor studio tidak valid.");
        }
    }

    public boolean addStudioWithMovies(String type, String title, double rating, String[] genres) {
        if (listStudios.size() < studioCapacity) {
            Movie movie = new Movie(title, rating, String.join(", ", genres));
            Studio studio = new Studio(movie, type);
            listStudios.add(studio);
            return true;
        }
        return false;
    }

    public boolean bookTicket(User user, int studioNumber, int row, int col) {
        if (studioNumber > 0 && studioNumber <= listStudios.size()) {
            Studio studio = listStudios.get(studioNumber - 1);
            if (studio.reserve(row, col)) {
                double ticketPrice = Utils.getTicketPrice(studio.getType());
                if (user.deductBalance(ticketPrice)) {
                    user.addTicket(new Ticket(studio.getMovie(), studioNumber, studio.getType()));
                    return true;
                } else {
                    System.out.println("Saldo tidak mencukupi.");
                }
            } else {
                System.out.println("Tempat duduk sudah dipesan.");
            }
        } else {
            System.out.println("Nomor studio tidak valid.");
        }
        return false;
    }

    public void init() {
        addStudioWithMovies("Imax", "Inception", 9.5, new String[]{"Action", "Thriller", "Science Fiction"});
        addStudioWithMovies("Premiere", "Titanic", 9.0, new String[]{"Romance", "Drama"});
        addStudioWithMovies("Reguler", "Avengers: Endgame", 8.4, new String[]{"Action", "Adventure", "Science Fiction"});
        addStudioWithMovies("Imax", "Interstellar", 9.3, new String[]{"Adventure", "Drama", "Science Fiction"});
        addStudioWithMovies("Premiere", "The Dark Knight", 9.0, new String[]{"Action", "Crime", "Drama"});
        addStudioWithMovies("Reguler", "Frozen II", 7.0, new String[]{"Animation", "Adventure", "Comedy"});
        addStudioWithMovies("Imax", "Avatar", 8.7, new String[]{"Action", "Adventure", "Fantasy"});
        addStudioWithMovies("Premiere", "The Lion King", 8.5, new String[]{"Animation", "Adventure", "Drama"});
        addStudioWithMovies("Reguler", "Toy Story 4", 8.3, new String[]{"Animation", "Adventure", "Comedy"});
        addStudioWithMovies("Imax", "Jurassic Park", 8.1, new String[]{"Adventure", "Sci-Fi"});
    }
}


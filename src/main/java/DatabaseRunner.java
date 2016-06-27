import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by brandonstark on 22/06/16.
 */
public class DatabaseRunner {
    public static void main(String[] args) {

        List<Actor> actors = findAllActorsByMovieTitle("ANACONDA CONFESSIONS");
        for (Actor actor : actors) {
            System.out.println(actor.toString());
        }
    }

    private static List<Actor> findAllActorsByMovieTitle(String movieTitle) {

        String q = "SELECT a.first_name, a.last_name FROM actor a " + "join film_actor fa on fa.actor_id = a.actor_id" + " join film f on f.film_id = fa.film_id" + " where f.title = ?";

        try {
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false&serverTimezone=UTC", "root", "root");
            PreparedStatement s = c.prepareStatement(q);
            s.setString(1, movieTitle);
            ResultSet r = s.executeQuery();

            ArrayList<Actor> actors = new ArrayList<>();
            while (r.next()) {
                String firstName = r.getString("first_name");
                String lastName = r.getString("last_name");
                Actor actor = new Actor(firstName, lastName);
                System.out.println(actor.toString());
            }
            return actors;
        } catch (SQLException e) {
            System.out.println("FOUT");
            e.printStackTrace();
            return null;
        }
    }
}




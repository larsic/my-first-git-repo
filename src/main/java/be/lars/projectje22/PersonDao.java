package be.lars.projectje22;

import com.realdolmen.Person;

import java.sql.*;
import java.util.*;
import java.util.Date;

public interface PersonDao {
    Person findById(int id);
}

class StubPersonDao implements PersonDao {
    public Person findById(int id) {
        return new Person("Jimi", "Hendrix", new Date(), null);
    }
}

class JdbcPersonDao implements PersonDao {
    public Person findById(int id) {
        try(Connection c = DriverManager.getConnection("mysql:jdbc://localhost:3306/people", "root", "pass")) {
            PreparedStatement ps = c.prepareStatement("select * from person where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(!rs.next()) {
                return null;
            } else {
                String fn = rs.getString("first_name");
                String ln = rs.getString("last_name");
                return new Person(fn, ln, new java.util.Date(), null);
            }
        } catch (SQLException e) {
            return null;
        }
    }
}

class Runner {
    public static void main(String[] args) {
        PersonDao dao = new StubPersonDao();
        loadPersonAndDoSomethingWithIt(dao);
    }

    private static void loadPersonAndDoSomethingWithIt(PersonDao dao) {
        // ... do your thing here
        Person p = dao.findById(1507);
        System.out.println(p.getFirstName());
        System.out.println(p.getLastName());
    }
}


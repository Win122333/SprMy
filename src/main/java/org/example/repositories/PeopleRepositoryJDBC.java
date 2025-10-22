package org.example.repositories;

import org.example.models.People;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeopleRepositoryJDBC implements IRepository<People> {
    private final Connection connection;
    private final String url = "jdbc:postgresql://localhost:5432/zoo";
    private final String user = "postgres";
    private final String pswrd = "qewr";
    @Override
    public void save(People entity) {
        String sql = "INSERT INTO people (firstname, lastname, citizenship, age) VALUES (?, ?, ?, ?);";
        try (var st = connection.prepareStatement(sql)) {
            st.setString(1, entity.getFirstName());
            st.setString(2, entity.getLastName());
            st.setString(3, entity.getCitizenship());
            st.setInt(4, entity.getAge());
            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public People findById(int id) {
        String sql = "SELECT * FROM people WHERE ID=?;";
        try (var st = connection.prepareStatement(sql)) {
            List<People> lst = new ArrayList<>();
            st.setInt(1, id);
            var res = st.executeQuery();
            if (res.next()) {
                People p = new People(
                        res.getString("firstname"),
                        res.getString("lastname"),
                        res.getInt("age"),
                        res.getString("citizenship")

                );
                p.setID(res.getInt("id"));
                return p;
            }
            throw new RuntimeException("нет такого id");

        }
        catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<People> findAll() {
        String sql = "SELECT * FROM people;";
        try (var st = connection.prepareStatement(sql)) {
            List<People> lst = new ArrayList<>();
            var res = st.executeQuery();
            while (res.next()) {
                People p = new People(
                        res.getString("firstname"),
                        res.getString("lastname"),
                        res.getInt("age"),
                        res.getString("citizenship")

                );
                p.setID(res.getInt("id"));
                lst.add(p);
            }
            return lst;
        }
        catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM people WHERE id=?;";
        try (var st = connection.prepareStatement(sql)) {
            st.setInt(1, id);
            return st.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Override
    public void update(People entity, int id) {
        String sql = "UPDATE people " +
                "SET firstname = ?, lastname = ?, citizenship = ?, age = ? " +
                "WHERE id = ?";
        try (var st = connection.prepareStatement(sql)) {
            st.setString(1, entity.getFirstName());
            st.setString(2, entity.getLastName());
            st.setString(3, entity.getCitizenship());
            st.setInt(4, entity.getAge());
            st.setInt(5, id);
            st.executeUpdate();
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public PeopleRepositoryJDBC() {
        try {
            connection = DriverManager.getConnection(url, user, pswrd);
        }
        catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

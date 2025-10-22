package org.example.repositories;

import org.example.models.Animal;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class AnimalRepositoryJDBC implements IRepository<Animal> {
    private final Connection connection;
    private final String url = "jdbc:postgresql://localhost:5432/zoo";
    private final String user = "postgres";
    private final String pswrd = "qewr";
    @Override
    public void save(Animal entity) {
        String sql = "INSERT INTO animals (sciencename, population, avglife, id_owner) VALUES (?, ?, ?, ?);";
        try (var st = connection.prepareStatement(sql)) {
            st.setString(1, entity.getScienceName());
            st.setLong(2, entity.getPopulation());
            st.setInt(3, entity.getAvgLife());
            st.setInt(4, entity.getID_owner());
            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Animal findById(int id) {
        String sql = "SELECT * FROM animals WHERE ID=?;";
        try (var st = connection.prepareStatement(sql)) {
            List<Animal> lst = new ArrayList<>();
            st.setInt(1, id);
            var res = st.executeQuery();
            if (res.next()) {
                Animal a = new Animal(
                        res.getString("sciencename"),
                        res.getLong("population"),
                        res.getInt("avglife"),
                        res.getInt("id_owner")
                );
                a.setID(res.getInt("id"));
                return a;
            }
            throw new RuntimeException("нет такого id");

        }
        catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @Override
    public List<Animal> findAll() {
        String sql = "SELECT * FROM animals;";
        try (var st = connection.prepareStatement(sql)) {
            List<Animal> lst = new ArrayList<>();
            var res = st.executeQuery();
            while (res.next()) {
                Animal a = new Animal(
                        res.getString("sciencename"),
                        res.getLong("population"),
                        res.getInt("avglife"),
                        res.getInt("id_owner")
                );
                a.setID(res.getInt("id"));
                lst.add(a);
            }
            return lst;
        }
        catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM animals WHERE id=?;";
        try (var st = connection.prepareStatement(sql)) {
            st.setInt(1, id);
            return st.execute();
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Animal entity, int id) {
        String sql = "UPDATE animals " +
                "SET sciencename = ?, population = ?, avglife = ?, id_owner = ? " +
                "WHERE id = ?";
        try (var st = connection.prepareStatement(sql)) {
            st.setString(1, entity.getScienceName());
            st.setLong(2, entity.getPopulation());
            st.setInt(3, entity.getAvgLife());
            st.setInt(4, entity.getID_owner());
            st.setInt(5, id);
            st.execute();
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public AnimalRepositoryJDBC() {
        try {
            connection = DriverManager.getConnection(url, user, pswrd);
        }
        catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

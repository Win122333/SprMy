package org.example.repositories;

import org.example.models.Animal;
import org.example.models.Music;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MusicRepositoryJDBC  implements IRepository<Music> {
    private final Connection connection;
    private final String url = "jdbc:postgresql://localhost:5432/zoo";
    private final String user = "postgres";
    private final String pswrd = "qewr";

    @Override
    public void save(Music entity) {
        String sql = "INSERT INTO music (title, author, duration, id_owner) VALUES (?, ?, ?, ?);";
        try (var st = connection.prepareStatement(sql)) {
            st.setString(1, entity.getTitle());
            st.setString(2, entity.getAutor());
            st.setInt(3, entity.getDuration());
            st.setInt(4, entity.getID_owner());
            st.executeUpdate();
        }
        catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Music findById(int id) {
        String sql = "SELECT * FROM music WHERE ID=?;";
        try (var st = connection.prepareStatement(sql)) {
            List<Animal> lst = new ArrayList<>();
            st.setInt(1, id);
            var res = st.executeQuery();
            if (res.next()) {
                Music m = new Music(
                        res.getString("title"),
                        res.getString("author"),
                        res.getInt("duration"),
                        res.getInt("id_owner")
                );
                m.setID(res.getInt("id"));
                return m;
            }
            throw new RuntimeException("нет такого id");

        }
        catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Music> findAll() {
        String sql = "SELECT * FROM music;";
        try (var st = connection.prepareStatement(sql)) {
            List<Music> lst = new ArrayList<>();
            var res = st.executeQuery();
            while (res.next()) {
                Music m = new Music(
                        res.getString("title"),
                        res.getString("author"),
                        res.getInt("duration"),
                        res.getInt("id_owner")
                );
                m.setID(res.getInt("id"));
                lst.add(m);
            }
            return lst;
        }
        catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM music WHERE id=?;";
        try (var st = connection.prepareStatement(sql)) {
            st.setInt(1, id);
            return st.execute();
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Music entity, int id) {
        String sql = "UPDATE music " +
                "SET title = ?, author = ?, duration = ?, id_owner = ? " +
                "WHERE id = ?";
        try (var st = connection.prepareStatement(sql)) {
            st.setString(1, entity.getTitle());
            st.setString(2, entity.getAutor());
            st.setInt(3, entity.getDuration());
            st.setInt(4, entity.getID_owner());
            st.setInt(5, id);
            st.execute();
        }
        catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public MusicRepositoryJDBC() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, pswrd);
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

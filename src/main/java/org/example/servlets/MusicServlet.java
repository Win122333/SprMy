package org.example.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.JsonParser;
import org.example.models.Music;
import org.example.services.MusicService;
import org.example.services.ServiceFactory;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "musicServlet", value = "/music/*")
public class MusicServlet extends HttpServlet {
    private MusicService musicService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        musicService = ServiceFactory.getMusicService();
    }

    @Override
    protected void doGet(
            HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo().substring(1);
        if (path.isEmpty()) {
            getAll(resp);
        }
        else {
            getById(resp, Integer.parseInt(path));
        }
    }

    @Override
    protected void doPost(
            HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Music music = JsonParser.parseMusicFromRequest(req);
        musicService.create(music);
    }

    @Override
    protected void doPut(
            HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Music music = JsonParser.parseMusicFromRequest(req);
        String path = req.getPathInfo().substring(1);
        musicService.update(music, Integer.parseInt(path));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo().substring(1);
        musicService.delete(Integer.parseInt(path));
    }

    private void getAll(HttpServletResponse resp) {
        List<Music> music = musicService.getAll();
        try {
            resp.getWriter().write(JsonParser.musicToJson(music));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getById(HttpServletResponse resp, int id) {
        Music music = musicService.getItemById(id);
        try {
            resp.getWriter().write(JsonParser.musicToJson(music));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package org.example.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.JsonParser;
import org.example.models.Animal;
import org.example.services.AnimalService;
import org.example.services.ServiceFactory;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "animalServlet", value = "/animal/*")
public class AnimalServlet extends HttpServlet {
    private AnimalService animalService;

    @Override
    public void init() throws ServletException {
        this.animalService = ServiceFactory.getAnimalService();
    }

    @Override
    protected void doGet(
            HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=UTF-8");
        String path = req.getPathInfo().substring(1);

        if (path.isEmpty()) {
            getAll(resp);
        }
        else {
            getById(Integer.parseInt(path), resp);
        }
    }

    @Override
    protected void doPost(
            HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Animal animal = JsonParser.parseAnimalFromRequest(req);
        animalService.create(animal);
    }

    @Override
    protected void doPut(
            HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Animal animal = JsonParser.parseAnimalFromRequest(req);
        String path = req.getPathInfo().substring(1);
        animalService.update(animal, Integer.parseInt(path));
    }

    @Override
    protected void doDelete(
            HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo().substring(1);
        animalService.delete(Integer.parseInt(path));
    }

    private void getById(Integer id, HttpServletResponse resp) throws IOException {
        Animal animal = animalService.getItemById(id);
        resp.getWriter().write(JsonParser.animalToJson(animal));
    }

    private void getAll(HttpServletResponse resp) throws IOException {
        List<Animal> animalList = animalService.getAll();
        resp.getWriter().write(JsonParser.animalsToJson(animalList));
    }
}

package org.example.servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.JsonParser;
import org.example.models.People;
import org.example.services.PeopleService;
import org.example.services.ServiceFactory;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "peopleServlet", value = "/people/*")
public class PeopleServlet extends HttpServlet {
    private PeopleService peopleService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.peopleService = ServiceFactory.getPeopleService();
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
        People people = JsonParser.parsePeopleFromRequest(req);
        peopleService.create(people);
    }

    @Override
    protected void doPut(
            HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo().substring(1);
        People people = JsonParser.parsePeopleFromRequest(req);
        peopleService.update(people, Integer.parseInt(path));
    }

    @Override
    protected void doDelete(
            HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo().substring(1);
        peopleService.delete(Integer.parseInt(path));
    }
    private void getAll(HttpServletResponse resp) throws IOException {
        List<People> people = peopleService.getAll();
        resp.getWriter().write(JsonParser.peopleToJson(people));
    }
    private void getById(HttpServletResponse resp, int id) throws IOException {
        People people = peopleService.getItemById(id);
        resp.getWriter().write(JsonParser.peopleToJson(people));
    }
}

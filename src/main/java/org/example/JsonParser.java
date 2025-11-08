package org.example;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonArrayBuilder;
import jakarta.servlet.http.HttpServletRequest;
import org.example.models.Animal;
import org.example.models.Music;
import org.example.models.People;

import java.io.IOException;
import java.util.List;

public class JsonParser {
    public static Animal parseAnimalFromRequest(HttpServletRequest req) throws IOException {
        try (JsonReader reader = Json.createReader(req.getReader())) {
            JsonObject jsonObject = reader.readObject();
            return parseAnimalFromJson(jsonObject);
        }
    }

    public static Animal parseAnimalFromJson(JsonObject json) {
        return new Animal(
                json.getString("scienceName"),
                json.getJsonNumber("population").longValue(),
                json.getInt("avgLife"),
                json.getInt("id_owner")
        );
    }

    public static String animalToJson(Animal animal) {
        return Json.createObjectBuilder()
                .add("id", animal.getID())
                .add("scienceName", animal.getScienceName())
                .add("population", animal.getPopulation())
                .add("avgLife", animal.getAvgLife())
                .add("id_owner", animal.getID_owner())
                .build()
                .toString();
    }

    public static String animalsToJson(List<Animal> animals) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (Animal animal : animals) {
            arrayBuilder.add(Json.createObjectBuilder()
                    .add("id", animal.getID())
                    .add("scienceName", animal.getScienceName())
                    .add("population", animal.getPopulation())
                    .add("avgLife", animal.getAvgLife())
                    .add("id_owner", animal.getID_owner()));
        }
        return arrayBuilder.build().toString();
    }

    public static Music parseMusicFromRequest(HttpServletRequest req) throws IOException {
        try (JsonReader reader = Json.createReader(req.getReader())) {
            JsonObject jsonObject = reader.readObject();
            return parseMusicFromJson(jsonObject);
        }
    }

    public static Music parseMusicFromJson(JsonObject jsonObject) {
        return new Music(
                jsonObject.getString("title"),
                jsonObject.getString("autor"),
                jsonObject.getInt("duration"),
                jsonObject.getInt("id_owner")
        );
    }

    public static String musicToJson(Music music) {
        return Json.createObjectBuilder()
                .add("id", music.getID())
                .add("title", music.getTitle())
                .add("author", music.getAutor())
                .add("duration", music.getDuration())
                .add("id_owner", music.getID_owner())
                .build()
                .toString();
    }

    public static String musicToJson(List<Music> music) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (Music m : music) {
            arrayBuilder.add(Json.createObjectBuilder()
                    .add("id", m.getID())
                    .add("title", m.getTitle())
                    .add("author", m.getAutor())
                    .add("duration", m.getDuration())
                    .add("id_owner", m.getID_owner()));
        }
        return arrayBuilder.build().toString();
    }

    public static People parsePeopleFromRequest(HttpServletRequest req) throws IOException {
        try (JsonReader reader = Json.createReader(req.getReader())) {
            JsonObject jsonObject = reader.readObject();
            return parsePeopleFromJson(jsonObject);
        }
    }

    public static People parsePeopleFromJson(JsonObject json) {
        return new People(
                json.getString("firstName"),
                json.getString("lastName"),
                json.getInt("age"),
                json.getString("citizenship")
        );
    }

    public static String peopleToJson(People people) {
        return Json.createObjectBuilder()
                .add("id", people.getID())
                .add("firstName", people.getFirstName())
                .add("lastName", people.getLastName())
                .add("age", people.getAge())
                .add("citizenship", people.getCitizenship())
                .build()
                .toString();
    }

    public static String peopleToJson(List<People> people) {
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        for (People p : people) {
            arrayBuilder.add(Json.createObjectBuilder()
                    .add("id", p.getID())
                    .add("firstName", p.getFirstName())
                    .add("lastName", p.getLastName())
                    .add("age", p.getAge())
                    .add("citizenship", p.getCitizenship()));
        }
        return arrayBuilder.build().toString();
    }
}
package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        final Car car = new Car(true, 0, new Identifier("A777AA777"),
                new String[]{"New", "Cabrio"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(car));


        final String carJson =
                "{"
                        + "\"allWellDrive\":false,"
                        + "\"age\" :5,"
                        + "\"identifier\" :"
                        + "{"
                        + "\"number\":\"А123ВС456\" },"
                        + "\"statuses\" :"
                        + "[\"Old\",\"Sedan\"]"
                        + "}";
        final Car carMod = gson.fromJson(carJson, Car.class);
        System.out.println(carMod);


        JSONObject jsonConcat = new JSONObject(gson.toJson(car.getIdentifier()));
        JSONArray jsonStatuses = new JSONArray(car.getStatuses());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("allWellDrive", car.isAllWellDrive());
        jsonObject.put("age", car.getAge());
        jsonObject.put("identifier", jsonConcat);
        jsonObject.put("statuses", jsonStatuses);

        System.out.println(jsonObject);

        System.out.println(new JSONObject(car));
    }
}
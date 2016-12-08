package Autopark;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 07.12.2016.
 */
public class CarReaderClass implements CarReader {
    List<String> cars = new ArrayList<>();
    List<JsonElement> cars1 = new ArrayList<>();
    final static String JSON_FILE = "json";
    final static String TXT_FILE = "2.txt";
    double carID;
    int price;
    String model;
    int year;

    @Override
    public Vehicle readVehicleData(String pathName) throws IOException {
        File file = new File(pathName);
        FileReader fr = new FileReader(file);
        BufferedReader in = new BufferedReader(fr);
        if (pathName.equals(TXT_FILE)) {
            String line;
            while ((line = in.readLine()) != null) {
                cars.add(line);
            }
            in.close();
            System.out.print(cars);
        } else {
            JsonParser parse = new JsonParser();
            JsonObject obj = (JsonObject) parse.parse(in);
            ///JsonArray arr = obj.getAsJsonArray("cars");
            cars1.add(obj.get("Lada"));
            cars1.add(obj.get("Gaz"));
            cars1.add(obj.get("Mazda"));
            cars1.add(obj.get("Volga"));
            cars1.add(obj.get("Mersedes"));
            System.out.print(cars1);
            in.close();


        }
        return null;
    }

}

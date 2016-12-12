package Autopark;

import com.google.gson.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Dmitry on 07.12.2016.
 */
public class CarReaderClass implements CarReader {
    final static String JSON_FILE = "2.json";
    final static String TXT_FILE = "txt";
    final static String TAKSOPARK_FILE_NAME_JSON = "2.json";
    double carID;
    int price;
    String model;
    int year;

    @Override
    public Vehicle readVehicleData(String pathName) {
        if (pathName.contains(TXT_FILE)) {
            File file = new File(pathName);
            FileReader fr = null;
            try {
                fr = new FileReader(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedReader in = new BufferedReader(fr);

            String line;
            try {
                while ((line = in.readLine()) != null) {
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
            if (pathName.contains(JSON_FILE)) {
                File file = new File(pathName);
                FileReader fr = null;
                try {
                    fr = new FileReader(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                BufferedReader in = new BufferedReader(fr);

                String line;
                String json = "";
                try {
                    while ((line = in.readLine()) != null) {
                        json += line;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Gson gson = new Gson();
                JsonObject obj;
                obj = gson.fromJson(json, JsonObject.class);
                carID = obj.get("carID").getAsDouble();
                price = obj.get("price").getAsInt();
                model = obj.get("model").getAsString();
                year = obj.get("year").getAsInt();
                Vehicle car = new Vehicle(carID, price, model, year);
                return car;
            }
        return null;
    }
    public List<Vehicle> read(String pathName){
        if (pathName.equals(TAKSOPARK_FILE_NAME_JSON)) {
            Gson gson = new Gson();
            File myFile = new File(pathName);
            FileReader fileReader = null;
            try {
                fileReader = new FileReader(myFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            Map<Double, Vehicle> cars = new TreeMap();
            String j = null;
            Vehicle veh = null;
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    j = line;
                    veh = gson.fromJson(j, Vehicle.class);
                    cars.put(veh.getCarID(), gson.fromJson(j, Vehicle.class));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        List<Vehicle> vehicles = new ArrayList<>(cars.values());
        return vehicles;
        }
        return null;
    }
}




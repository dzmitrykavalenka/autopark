package Autopark;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dzmitry_Kavalenka on 12/6/2016.
 */
public class CarWriterClass implements CarWriter {
    @Override
    public boolean writeVehicleData(Vehicle vehicle, String writeType) {
        try {
            FileWriter fw = new FileWriter(writeType, true);
            BufferedWriter out = new BufferedWriter(fw);
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            if (writeType.equals("1")) {
                out.write(vehicle.getInfo());
                out.newLine();
                out.close();
            } else {
                out.write(json.toJson(vehicle));
                out.newLine();
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}


package Autopark;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

/**
 * Created by Dzmitry_Kavalenka on 12/6/2016.
 */
public class CarWriterClass implements CarWriter {
    final static String JSON_FILE = "json";
    final static String TXT_FILE = "txt";
    @Override

    public boolean writeVehicleData(Vehicle vehicle, String writeType) {
        try {
            File file = new File(writeType);
            Writer fw = new FileWriter(file, true);
            BufferedWriter out = new BufferedWriter(fw);
            Gson json = new GsonBuilder().setPrettyPrinting().create();
            if (file.equals(TXT_FILE)) {
                out.write(vehicle.getInfo());
                out.newLine();
                out.close();
            }else{
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


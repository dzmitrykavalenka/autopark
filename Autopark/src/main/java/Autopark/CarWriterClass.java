package Autopark;

import java.io.*;

/**
 * Created by Dzmitry_Kavalenka on 12/6/2016.
 */
public class CarWriterClass implements Serializable, CarWriter  {

    @Override
    public boolean writeVehicleData(Vehicle v, String writeType) throws IOException {
        FileOutputStream fos = new FileOutputStream(writeType);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(v);
        return false;
    }
}

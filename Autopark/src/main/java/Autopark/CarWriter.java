package Autopark;

import java.io.IOException;

/**
 * Created by Dzmitry_Kavalenka on 12/6/2016.
 */
public interface CarWriter {
    boolean writeVehicleData(Vehicle vehicle, String writeType) throws IOException /*throws VehicleWriteException*/;

}

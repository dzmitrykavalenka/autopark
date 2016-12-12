package Autopark;

import java.io.IOException;
import java.util.List;

/**
 * Created by Dmitry on 07.12.2016.
 */
public interface CarReader {
    Vehicle readVehicleData(String pathName);
    List<Vehicle> read (String pathName);
}

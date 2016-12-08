package Autopark;

import java.io.IOException;

/**
 * Created by Dmitry on 07.12.2016.
 */
public interface CarReader {
    Vehicle readVehicleData(String pathName) throws IOException;
}

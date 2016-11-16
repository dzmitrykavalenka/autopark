package Model;

/**
 * Created by Dmitry on 09.11.2016.
 */
public class Runner {
    public static void main(String args[]){
        Vehicle v1 = new Vehicle(4, 115, "hedge back");
        v1.setName("Lada Priora");
        System.out.print("The name of the first car model is " + v1.getName() + ". \n");
        v1.getInfo();
    }
}

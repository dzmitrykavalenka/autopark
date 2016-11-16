package Model;

/**
 * Created by Dmitry on 09.11.2016.
 */
public class Vehicle extends Transport {
    int passangers;
    int hp;
    String type;

    public Vehicle(int passangers, int hp, String type) {
        this.passangers = passangers;
        this.hp = hp;
        this.type = type;
    }
    public void getInfo(){
    System.out.println("It is a " + type + " with " + hp + " horses under the hood and it can carry up to "
            + passangers + " passangers! Isn't this something?");
    }
}

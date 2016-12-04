package Autopark;

/**
 * Created by Dmitry on 03.12.2016.
 */
public class IncorrectValueException extends Exception {
    int a;
    int b;
    double c;
    IncorrectValueException(int j, int i){
        a=j;
        b=i;
    }
    IncorrectValueException(double j){
        c=j;
    }
    public String toString(){
        return "Value out of permitted range";
    }

}

package inheritence;

import oops.vehicles;

public class bike extends vehicles{

    bike(){
        super();
    }

    bike(int speed){
        super(speed);
    }

    public static void main(String[] args) {
        bike b = new bike();
        bike b1 = new bike(5);
        b.speed = 10;

        System.out.println(b.speed);
        System.out.println(b.getSpeed());
        System.out.println(b1.getSpeed());
    }
}


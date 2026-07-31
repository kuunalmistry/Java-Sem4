package oops;

import inheritence.bike;

public class car extends vehicles{

    public static void main(String[] args) {
        car c = new car();
        vehicles v = new vehicles();
        bike b = new bike();

        v.speed = 10;
        c.speed = 20;
        b.speed = 30;

        System.out.println(c.getSpeed());
        System.out.println(v.getSpeed());
        System.out.println(b.getSpeed());
    }
}


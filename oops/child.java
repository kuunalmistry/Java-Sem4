package oops;

public class child implements parent1, parent2 {

    @Override
    public void run() {
        System.out.println("Running");
    }

    @Override
    public void display() {
        parent1.super.display();   
        System.out.println("Executed");
        parent2.super.logging();   
    }

    @Override
    public void logging() {
        System.out.println("Process Started");
    }

    public static void main(String[] args) {

        child c = new child();

        c.run();
        c.display();
        c.logging();
    }
}
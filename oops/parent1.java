package oops;

public interface parent1 {

    void run();

    default void display() {
        System.out.println("Helllo");

    }

    static void logging() {
        System.out.println("Process Started");
    }
}
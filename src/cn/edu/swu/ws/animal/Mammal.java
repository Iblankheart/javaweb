package cn.edu.swu.ws.animal;

public abstract class Mammal extends Animal {

    private String var;

    public void run() {
        System.out.println("running ...");
    };

    public abstract void scream();

    public abstract String getName();
}

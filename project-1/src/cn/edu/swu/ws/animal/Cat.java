package cn.edu.swu.ws.animal;

public class Cat extends Mammal {

    @Override
    public String getType() {
        return "CAT";
    }

    @Override
    public void scream() {
        System.out.println("meow meow ...");
    }

    @Override
    public String getName() {
        return "jerry";
    }

}

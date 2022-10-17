package cn.edu.swu.ws.animal;

public class Dog extends Mammal implements MagicFire, MagicWater {

    @Override
    public String getType() {
        return "DOG";
    }

    @Override
    public void scream() {
        System.out.println("wang wang ...");
    }

    @Override
    public String getName() {
        return "tom";
    }

    @Override
    public void fire() {
        System.out.println("fire ....");
    }

    @Override
    public void freeze() {
        System.out.println("freeze ....");
    }

    @Override
    public void swimming() {
        System.out.println("swimming ....");
    }
}

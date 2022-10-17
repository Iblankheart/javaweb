package cn.edu.swu.ws.animal;

public class Zoo {
    public static void main(String[] args) {
        Mammal[] mammals = new Mammal[]{
                new Cat(),
                new Dog()
        };

        for (int i=0; i<mammals.length; i++) {
            Mammal mammal = mammals[i];
            System.out.println(mammal.getType());
            mammal.scream();
            mammal.run();
        }

        Dog d1 = new Dog();
        d1.freeze();
        d1.fire();

        Cat c1 = new Cat();
    }
}

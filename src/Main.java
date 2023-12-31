import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //System.out.printf("Hello and welcome!");
        int a = 1;
        /**
         * 'Animal' is abstract; cannot be instantiated
         * */
//        Animal animal1 = new Animal(10, "Animal1");
//        Animal animal2 = new Animal(5, "Animal2");
//        Animal animal1 = new Animal();
//        animal1.age = 2;
//        animal1.name = "Animal2";
//        System.out.println("age: " + animal1.getAge());
//        System.out.println("name: " + animal1.getName());
//        animal1.makeSounds();
//        animal2.makeSounds();

        System.out.println("===========================");
        Dog dog1 = new Dog(3, "Richi");
        System.out.println(dog1.getName());
        dog1.makeSounds();
        System.out.println("===========================");
        Cat cat1 = new Cat(20, "Seba");
        Cat cat2 = new Cat(5, "Boba");
        System.out.println(cat1.getName());
        System.out.println(cat2.getName());
        cat1.makeSounds();
        cat2.makeSounds();
        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println("===========================");
        Cat cat3 = new Cat(-20, "Tom");
        //cat3.age = 10;
        cat3.setAge(10);
        System.out.println(cat3);
        System.out.println(cat3.getAge());
        cat1.breath();
        cat2.breath();
        cat3.breath();
        System.out.println("===========================");
        System.out.println("Total objects: " + Animal.number);
        Animal.showNumber();
        System.out.println("===========================");
        /**
         * POLYMORPHISM
         */
        Animal dog2 = new Dog(2, "Jack");
        Animal cat4 = new Cat(5, "Archi");
        List<Animal> animals = new ArrayList<>();
        animals.add(dog2);
        animals.add(cat4);
        animals.add(cat1);
        animals.add(dog1);
        for (Animal animal : animals) {
            animal.makeSounds();
        }
        System.out.println("===========================");
        Seagull seagull = new Seagull();
        seagull.breath();
        seagull.makeSounds();
        seagull.fly();
        System.out.println("===========================");
        SwimingBird penguin = new Penguin();
        penguin.breath();
        penguin.makeSounds();
        penguin.swim();
    }
}

abstract class Animal {
    static int number = 0;
//    public Animal() {
//    }

    public Animal() {

        number++;
    }

    abstract void breath();

    abstract void makeSounds();

    static void showNumber() {
        System.out.println(number);
    }
} // Animal

abstract class DomasticAnimal extends Animal {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be less then 0");
            this.age = 0;
        }
    }

    public DomasticAnimal(int age, String name) {
        setAge(age);
        setName(name);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty() && name.length() > 2) {
            this.name = name;
        } else {
            System.out.println("Name cannot be blank");
            this.name = "UNKNOWN";
        }
    }
}

class Dog extends DomasticAnimal {

    public Dog(int age, String name) {
        super(age, name);
    }


    @Override
    void breath() {
        System.out.println(getName() + "Dog is breathing");
    }

    void makeSounds() {
        System.out.println("dog " + this.getName() + " make sounds");
    }
}

class Cat extends DomasticAnimal {

    public Cat(int age, String name) {
        super(age, name);
    }

    @Override
    void breath() {
        System.out.println(getName() + "Cat is breathing");
    }

    @Override
    void makeSounds() {
        System.out.println("cat " + this.getName() + " make sounds");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + this.getAge() +
                ", name='" + this.getName() + '\'' +
                '}';
    }
}

interface Flying {
    void fly();

}

interface Swiming {
    void swim();
}

interface FlyingAndSwimming extends Flying, Swiming {

}
abstract class Bird extends Animal {

}
abstract class FlyingBird extends Bird implements Flying{

}
abstract class SwimingBird extends Bird implements Swiming{

}

class Seagull extends Bird implements FlyingAndSwimming {

    @Override
    void breath() {
        System.out.println("Bird " + this.getClass().getName() + " breath");
    }

    @Override
    void makeSounds() {
        System.out.println("seagull makes sounds");
    }

    @Override
    public void fly() {
        System.out.println(this.getClass().getName() + " is flying");
    }

    @Override
    public void swim() {
        System.out.println("seagull is swimming");
    }
}

class Penguin extends SwimingBird {


    @Override
    void breath() {
        System.out.println("Bird " + this.getClass().getName() + " breath");
    }

    @Override
    void makeSounds() {
        System.out.println("penguin makes sounds");
    }

    @Override
    public void swim() {
        System.out.println("penguin is swimming");

    }
}
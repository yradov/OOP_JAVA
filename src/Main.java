public class Main {
    public static void main(String[] args) {
        //System.out.printf("Hello and welcome!");
        int a = 1;
        Animal animal1 = new Animal(10, "Animal1");
        Animal animal2 = new Animal(5, "Animal2");
//        Animal animal1 = new Animal();
//        animal1.age = 2;
//        animal1.name = "Animal2";
        System.out.println("age: " + animal1.age);
        System.out.println("name: " + animal1.name);
        animal1.makeSounds();
        animal2.makeSounds();
    }
}

class Animal {
    int age;
    String name;
    public Animal() {
    }

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    void makeSounds() {
        System.out.println("animal " + this.name + " make sounds");
    }
}


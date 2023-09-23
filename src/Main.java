public class Main {
    public static void main(String[] args) {
        //System.out.printf("Hello and welcome!");
        int a = 1;
        Animal animal1 = new Animal(10, "Animal1");
        Animal animal2 = new Animal(5, "Animal2");
//        Animal animal1 = new Animal();
//        animal1.age = 2;
//        animal1.name = "Animal2";
        System.out.println("age: " + animal1.getAge());
        System.out.println("name: " + animal1.getName());
        animal1.makeSounds();
        animal2.makeSounds();
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
    }
}

class Animal {
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


//    public Animal() {
//    }

    public Animal(int age, String name) {
        setAge(age);
        setName(name);
    }

    void makeSounds() {
        System.out.println("animal " + this.name + " make sounds");
    }
}

class Dog extends Animal {

    public Dog(int age, String name) {
        super(age, name);
    }

    @Override
    void makeSounds() {
        System.out.println("dog " + this.getName() + " make sounds");
    }
}

class Cat extends Animal {

    public Cat(int age, String name) {
        super(age, name);
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
import java.util.ArrayList;
import java.util.List;


public class WildcardsExtendsSuperDemo {

    static class Animal {
        final String name;
        Animal(String name) { this.name = name; }
        @Override public String toString() { return name; }
    }

    static class Dog extends Animal {
        Dog(String name) { super(name); }
    }

    // 3) Use Upper Bounded Wildcards (? extends T) for Read-Only Access
    public static <T> int countItems(List<? extends T> items) {
        return items.size();
    }

    // 4) Use Lower Bounded Wildcards (? super T) for Write Operations
    public static <T> void addItem(List<? super T> target, T item) {
        target.add(item);
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Rex"));
        dogs.add(new Dog("Buddy"));

        // Read-only using ? extends T
        System.out.println("Dog count: " + countItems(dogs));

        // Write using ? super T
        List<Animal> animals = new ArrayList<>();
        addItem(animals, new Dog("Max"));

        System.out.println("Animals: " + animals);

        // These are intentionally not allowed (compile-time safety):
        // List<Animal> animals2 = new ArrayList<>();
        // List<? extends Animal> readOnly = animals2;
        // readOnly.add(new Animal("x")); // compile error
    }
}


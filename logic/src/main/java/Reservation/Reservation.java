package Reservation;

import Animals.Animal;
import Animals.Cat;
import Animals.Dog;
import Animals.Gender;

import java.util.ArrayList;
import java.util.List;

public class Reservation {
    List<Animal> animals = new ArrayList<Animal>();

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> _animals) {
        animals = _animals;
    }

    public void newCat(String name, Gender gender, String badHabits){
        animals.add(new Cat(gender, name, badHabits));
    }

    public void newDog(String name, Gender gender){
        animals.add(new Dog(gender, name));
    }
}

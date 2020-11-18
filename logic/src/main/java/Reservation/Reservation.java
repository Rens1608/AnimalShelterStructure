package Reservation;

import Animals.*;

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
        animals.add(new Cat(gender, name, badHabits, createPrice(false, badHabits), Species.Cat));
    }

    public void newDog(String name, Gender gender){
        animals.add(new Dog(gender, name, createPrice(true, null), Species.Dog));
    }

    public double createPrice(boolean isDog, String badhabits){
        if(isDog){
            long lessWorth = 50 * animals.stream().filter(animal -> animal.getSpecies() == Species.Dog).count();
            if(lessWorth > 499){
                return 50;
            }
            return 500 - lessWorth;
        }
        else {
            if(badhabits.chars().count() > 9){
                return 35;
            }
            return 350 - (35 * badhabits.chars().count());
        }
    }
}

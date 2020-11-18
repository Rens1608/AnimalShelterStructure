package Serialize;

import Animals.*;

import java.io.*;

public class AnimalSerialize {
    private final File shelterFile = new File("shelter.txt");

    public void serializeAnimal(String name, Gender gender, String badHabits, double price){
        Animal animal;
        try {
            if (badHabits != null){
                animal = new Cat(gender, name, badHabits, price, Species.Cat);
            }
            else{
                animal = new Dog(gender, name, price, Species.Dog);
            }
            FileOutputStream fileOut =
                    new FileOutputStream(shelterFile);

            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(animal);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in shelter.txt");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}

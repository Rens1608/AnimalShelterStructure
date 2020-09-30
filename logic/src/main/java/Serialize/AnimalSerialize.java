package Serialize;

import Animals.Animal;
import Animals.Cat;
import Animals.Dog;
import Animals.Gender;
import java.io.*;

public class AnimalSerialize {
    private final File shelterFile = new File("shelter.txt");

    public void serializeAnimal(String name, Gender gender, String badHabits){
        Animal animal;
        try {
            if (badHabits != null){
                animal = new Cat(gender, name, badHabits);
            }
            else{
                animal = new Dog(gender, name);
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

package sample;

import Animals.Animal;
import Animals.Cat;
import Animals.Gender;
import Reservation.Reservation;
import Serialize.AnimalSerialize;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class Controller {

    public ListView animalList;
    public CheckBox genderMale;
    public CheckBox genderFemale;
    public TextField name;
    public TextField badHabits;
    public ChoiceBox<String> species;
    public TextField reserverName;

    Reservation reservations = new Reservation();
    AnimalSerialize serialize = new AnimalSerialize();

    public void addAnimal() {
        Gender gender = genderMale.isSelected() ? Gender.Male : Gender.Female;
        if(species.getSelectionModel().getSelectedIndex() == 0) {
            reservations.newCat(name.getText(), gender, badHabits.getText());
            serialize.serializeAnimal(name.getText(), gender, badHabits.getText());
        }
        else if (species.getSelectionModel().getSelectedIndex() == 1){
            reservations.newDog(name.getText(), gender);
            serialize.serializeAnimal(name.getText(), gender, null);
        }
        refreshControls();

    }

    private void refreshControls() {
        animalList.getItems().removeAll();
        ObservableList<Animal> animals = FXCollections.observableList(reservations.getAnimals());
        animalList.setItems(animals);
    }

    public void reserveAnimal() {
        Animal animal = (Animal) animalList.getSelectionModel().getSelectedItem();
        if(animal != null){
            animal.Reserve(reserverName.getText());
            refreshControls();
        }
    }
}

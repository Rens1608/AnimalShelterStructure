package sample;

import Animals.Animal;
import Animals.Cat;
import Animals.Gender;
import Reservation.Reservation;
import Sell.ISellable;
import Sell.Item;
import Sell.WebShop;
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
    public ListView itemList;
    public TextField itemName;
    public TextField price;


    Reservation reservations = new Reservation();
    AnimalSerialize serialize = new AnimalSerialize();
    WebShop webShop = new WebShop();

    public void addAnimal() {
        Gender gender = genderMale.isSelected() ? Gender.Male : Gender.Female;
        if(species.getSelectionModel().getSelectedIndex() == 0) {
            reservations.newCat(name.getText(), gender, badHabits.getText());
            serialize.serializeAnimal(name.getText(), gender, badHabits.getText(),0);
        }
        else if (species.getSelectionModel().getSelectedIndex() == 1){
            reservations.newDog(name.getText(), gender);
            serialize.serializeAnimal(name.getText(), gender, null, 0);
        }
        refreshControls();

    }

    private void refreshControls() {
        animalList.getItems().removeAll();
        ObservableList<Animal> animals = FXCollections.observableList(reservations.getAnimals());
        animalList.setItems(animals);
        itemList.getItems().removeAll();
        ObservableList<ISellable> items = FXCollections.observableList(webShop.getShopItems());
        itemList.setItems(items);

    }

    public void reserveAnimal() {
        Animal animal = (Animal) animalList.getSelectionModel().getSelectedItem();
        if(animal != null){
            animal.Reserve(reserverName.getText());
            refreshControls();
        }
    }

    public void setAnimalForSale(){
        Animal animal = (Animal) animalList.getSelectionModel().getSelectedItem();
        if(animal != null){
            reservations.getAnimals().remove(animal);
            webShop.addAnimal(animal);
            refreshControls();
        }
    }

    public void setItemForSale(){
        Item item = new Item(itemName.getText(),Integer.parseInt(price.getText()));
        webShop.addItem(item);
        refreshControls();
    }

    public void buy(){
        ISellable item = (ISellable) itemList.getSelectionModel().getSelectedItem();
        webShop.buy(item);
        refreshControls();
    }
}

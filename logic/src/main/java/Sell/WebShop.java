package Sell;

import Animals.Animal;

import java.util.ArrayList;
import java.util.List;

public class WebShop {

    List<ISellable> shopItems = new ArrayList<>();

    public List<ISellable> getShopItems() {
        return shopItems;
    }

    public void setShopItems(List<ISellable> shopItems) {
        this.shopItems = shopItems;
    }

    public void buy(ISellable item){
        shopItems.remove(item);
    }

    public void addItem(Item item){
        shopItems.add(item);
    }

    public void addAnimal(Animal animal) {
        shopItems.add(animal);
    }
}

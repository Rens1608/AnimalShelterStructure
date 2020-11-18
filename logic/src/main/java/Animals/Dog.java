package Animals;

import java.time.LocalDateTime;

public class Dog extends Animal {
    public int LastWalk;
    public boolean NeedsWalk(){
        return (LocalDateTime.now().getDayOfMonth() - this.LastWalk) > 0;
    }

    public Dog(Animals.Gender gender, String name, double price, Species species) {
        super(gender, name, price, species);
        LastWalk = LocalDateTime.now().getDayOfMonth();
    }

    @Override
    public String toString() {
        return super.toString() + " Price = " + getPrice();
    }

}

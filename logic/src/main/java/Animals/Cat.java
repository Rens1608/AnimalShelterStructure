package Animals;

public class Cat extends Animal {

    public String BadHabits;

    public Cat(Animals.Gender gender, String name, String badHabits, double price, Species species) {
        super(gender, name, price, species);
        BadHabits = badHabits;
    }

    public String getBadHabits() {
        return BadHabits;
    }

    public void setBadHabits(String badHabits) {
        BadHabits = badHabits;
    }

    @Override
    public String toString() {
        return super.toString() + " BadHabits='" + BadHabits + "Price = " + getPrice();
    }
}

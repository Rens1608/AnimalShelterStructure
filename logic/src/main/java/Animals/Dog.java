package Animals;

import java.time.LocalDateTime;

public class Dog extends Animal {
    public int LastWalk;
    public boolean NeedsWalk(){
        return (LocalDateTime.now().getDayOfMonth() - this.LastWalk) > 0;
    }

    public Dog(Animals.Gender gender, String name) {
        super(gender, name);
        LastWalk = LocalDateTime.now().getDayOfMonth();
    }

}

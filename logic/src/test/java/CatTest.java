import Animals.Animal;
import Animals.Cat;
import Animals.Gender;
import Animals.Species;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CatTest {

    private Cat cat;

    @BeforeEach
    public void testInitialize(){
        cat = new Cat(Gender.Female, "Ms. Meow", "Scratches couch",0, Species.Cat);
    }

    @Test
    public void testConstructor(){
        Assertions.assertEquals("Ms. Meow", cat.getName());
        Assertions.assertEquals(Gender.Female, cat.getGender());
        Assertions.assertEquals("Scratches couch", cat.BadHabits);
        Assertions.assertNull(cat.getReservedBy());
    }

    @Test
    public void TestReservation()
    {
        Assertions.assertNull(cat.getReservedBy());
        Assertions.assertTrue(this.cat.Reserve("John Doe"));
        Assertions.assertNotNull(this.cat.getReservedBy());
        Assertions.assertEquals("John Doe", this.cat.getReservedBy().Name);
        Assertions.assertFalse(this.cat.Reserve("Jane Doe"));
    }
}

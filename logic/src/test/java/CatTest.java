import Animals.Animal;
import Animals.Cat;
import Animals.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CatTest {

    private Cat cat;

    @BeforeEach
    public void testInitialize(){
        cat = new Cat(Gender.Female, "Ms. Meow", "Scratches couch");
    }

    @Test
    public void testConstructor(){
        Assertions.assertEquals("Ms. Meow", cat.Name);
        Assertions.assertEquals(Gender.Female, cat.Gender);
        Assertions.assertEquals("Scratches couch", cat.BadHabits);
        Assertions.assertNull(cat.ReservedBy);
    }

    @Test
    public void TestReservation()
    {
        Assertions.assertNull(cat.ReservedBy);
        Assertions.assertTrue(this.cat.Reserve("John Doe"));
        Assertions.assertNotNull(this.cat.ReservedBy);
        Assertions.assertEquals("John Doe", this.cat.ReservedBy.Name);
        Assertions.assertFalse(this.cat.Reserve("Jane Doe"));
    }
}

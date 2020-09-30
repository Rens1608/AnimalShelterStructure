import Animals.Reservor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class ReservorTest {

    @Test
    public void TestConstructor()
    {
        LocalDateTime reservedAt = LocalDateTime.now();
        Reservor reservor = new Reservor("John Doe",reservedAt);
        Assertions.assertEquals("John Doe", reservor.Name);
        Assertions.assertEquals(reservedAt, reservor.ReservedAt);
    }
}

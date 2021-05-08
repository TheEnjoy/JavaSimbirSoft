import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringUtilsTest {

    @Test
    public void testValidChar() {
        boolean actual = StringUtils.validChar('d');
        assertTrue(actual);

        actual = StringUtils.validChar(' ');
        assertFalse(actual);
    }
}

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringUtilsTest {
    public void testValidChar() {
        boolean actual = StringUtils.validChar('d');
        assertTrue(actual);

        actual = StringUtils.validChar(' ');
        assertTrue(actual);
    }
}

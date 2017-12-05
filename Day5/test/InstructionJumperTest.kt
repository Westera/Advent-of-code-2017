import org.junit.Test
import kotlin.test.assertEquals

class InstructionJumperTest {

    @Test
    fun testFirstGivenExample() {
        assertEquals(5, InstructionJumper().escapeOperations(mutableListOf(0, 3, 0, 1, -3)))
    }

    @Test
    fun testFirstGivenAdvExample() {
        assertEquals(10, InstructionJumper().advEscapeOperations(mutableListOf(0, 3, 0, 1, -3)))
    }
}
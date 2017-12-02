import org.junit.Test
import kotlin.test.assertEquals

class CaptchaSolverTest {

    @Test
    fun testFirstGivenExample() {
        assertEquals(3, CaptchaSolver().solve("1122"))
    }

    @Test
    fun testSecondGivenExample() {
        assertEquals(4, CaptchaSolver().solve("1111"))
    }

    @Test
    fun testThirdGivenExample() {
        assertEquals(0, CaptchaSolver().solve("1234"))
    }

    @Test
    fun testForthGivenExample() {
        assertEquals(9, CaptchaSolver().solve("91212129"))
    }
}

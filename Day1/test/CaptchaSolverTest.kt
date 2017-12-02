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

    @Test
    fun testFirstGivenAdvExample() {
        assertEquals(6, CaptchaSolver().advSolve("1212"))
    }

    @Test
    fun testSecondGivenAdvExample() {
        assertEquals(0, CaptchaSolver().advSolve("1221"))
    }

    @Test
    fun testThirdGivenAdvExample() {
        assertEquals(4, CaptchaSolver().advSolve("123425"))
    }

    @Test
    fun testForthGivenAdvExample() {
        assertEquals(12, CaptchaSolver().advSolve("123123"))
    }

    @Test
    fun testFifthGivenAdvExample() {
        assertEquals(4, CaptchaSolver().advSolve("12131415"))
    }
}

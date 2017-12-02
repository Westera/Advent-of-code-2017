import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class ChecksumCalculatorTest {

    @Test
    fun testFirstGivenExample() {
        val input = File("test/testInput")
        assertEquals(18, ChecksumCalculator().calculateSpreadsheetChecksum(input, " "))
    }

    @Test
    fun testFirstGivenAdvExample() {
        val input = File("test/testInput2")
        assertEquals(9, ChecksumCalculator().calculateAdvSpreadsheetChecksum(input, " "))
    }
}
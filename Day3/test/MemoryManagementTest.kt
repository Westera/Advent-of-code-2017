import org.junit.Test
import kotlin.test.assertEquals

class MemoryManagementTest {

    @Test
    fun testFirstGivenExample() {
        assertEquals(0, MemoryManagement().carryBack(1))
    }

    @Test
    fun testFirstNotGivenExample() {
        assertEquals(1, MemoryManagement().carryBack(2))
    }

    @Test
    fun testSecondGivenExample() {
        assertEquals(3, MemoryManagement().carryBack(12))
    }

    @Test
    fun testThirdGivenExample() {
        assertEquals(2, MemoryManagement().carryBack(23))
    }

    @Test
    fun testFourthGivenExample() {
        assertEquals(31, MemoryManagement().carryBack(1024))
    }

    @Test
    fun testFirstNotGivenAdvExample() {
        assertEquals(1, MemoryManagement().storeValues(0))
    }

    @Test
    fun testSecondNotGivenAdvExample() {
        assertEquals(2, MemoryManagement().storeValues(1))
    }

    @Test
    fun testThirdNotGivenAdvExample() {
        assertEquals(54, MemoryManagement().storeValues(53))
    }

    @Test
    fun testFourthNotGivenAdvExample() {
        assertEquals(304, MemoryManagement().storeValues(200))
    }
}
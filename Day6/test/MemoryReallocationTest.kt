import org.junit.Test
import kotlin.test.assertEquals

class MemoryReallocationTest {

    @Test
    fun testFirstGivenExample() {
        assertEquals(5, MemoryReallocation().debugReallocation(listOf(0, 2, 7, 0)))
    }

    @Test
    fun testSecondGivenExample() {
        assertEquals(4, MemoryReallocation().debugReallocationWithLoopLength(listOf(0, 2, 7, 0)))
    }
}
import org.junit.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PassphraseCheckerTest {

    @Test
    fun testFirstGivenExample() {
        assertTrue(PassphraseChecker().validatePassphrase("aa bb cc dd ee"))
    }

    @Test
    fun testSecondGivenExample() {
        assertFalse(PassphraseChecker().validatePassphrase("aa bb cc dd aa"))
    }

    @Test
    fun testThirdGivenExample() {
        assertTrue(PassphraseChecker().validatePassphrase("aa bb cc dd aaa"))
    }

    @Test
    fun testFourthGivenExample() {
        val input = File("test/testInput")
        assertEquals(2, PassphraseChecker().checkPassPhrases(input))
    }

    @Test
    fun testFirstGivenAdvExample() {
        assertTrue(PassphraseChecker().advValidatePassphrase("abcde fghij"))
    }

    @Test
    fun testSecondGivenAdvExample() {
        assertFalse(PassphraseChecker().advValidatePassphrase("abcde xyz ecdab"))
    }

    @Test
    fun testThirdGivenAdvExample() {
        assertTrue(PassphraseChecker().advValidatePassphrase("a ab abc abd abf abj"))
    }

    @Test
    fun testFourthGivenAdvExample() {
        assertTrue(PassphraseChecker().advValidatePassphrase("iiii oiii ooii oooi oooo"))
    }

    @Test
    fun testFifthGivenAdvExample() {
        assertFalse(PassphraseChecker().advValidatePassphrase("oiii ioii iioi iiio"))
    }
}
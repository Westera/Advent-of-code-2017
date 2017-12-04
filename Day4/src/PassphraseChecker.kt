import java.io.File

class PassphraseChecker {

    fun validatePassphrase(phrase: String): Boolean {
        val wordsInPhrase = mutableSetOf<String>()
        phrase.split(" ").forEach {
            if (!wordsInPhrase.add(it))
                return false
        }
        return true
    }

    fun advValidatePassphrase(phrase: String): Boolean {
        val wordsInPhrase = mutableSetOf<String>()
        phrase.split(" ").forEach {
            if (!wordsInPhrase.add(it) || wordsInPhrase.containsAnagram())
                return false
        }
        return true
    }

    fun checkPassPhrases(input: File): Int {
        return input.readLines().asSequence().filter { validatePassphrase(it) }.count()
    }

    fun advCheckPassPhrases(input: File): Int {
        return input.readLines().asSequence().filter { advValidatePassphrase(it) }.count()
    }

    private fun Set<String>.containsAnagram(): Boolean {
        return windowed(size, partialWindows = true).filter {
            (1 until it.size).any { i -> it[0].isAnagram(it[i]) }
        }.count() > 0
    }

    private fun String.isAnagram(otherString: String): Boolean {
        val charArray = toCharArray().sortedArray()
        val otherCharArray = otherString.toCharArray().sortedArray()
        return charArray.contentEquals(otherCharArray)
    }
}

fun main(args: Array<String>) {
    val file = File(args[0])
    println(PassphraseChecker().checkPassPhrases(file))
    println(PassphraseChecker().advCheckPassPhrases(file))
}
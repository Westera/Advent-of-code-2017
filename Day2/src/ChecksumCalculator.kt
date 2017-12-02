import java.io.File

class ChecksumCalculator {

    fun calculateSpreadsheetChecksum(spreadsheet: File, delimiter: String = "\t"): Int {
        var sum = 0
        spreadsheet.forEachLine {
            sum += it.split(delimiter).asSequence().map { it.toInt() }.toList().diffBetweenMaxAndMinVal()
        }
        return sum
    }

    fun calculateAdvSpreadsheetChecksum(spreadsheet: File, delimiter: String = "\t"): Int {
        var sum = 0
        spreadsheet.forEachLine {
            sum += it.split(delimiter).asSequence().map { it.toInt() }.toList().findEvenlyDivisiblePair()
        }
        return sum
    }

    private fun List<Int>.diffBetweenMaxAndMinVal(): Int {
        return (max() ?: 0) - (min() ?: 0)
    }

    private fun List<Int>.findEvenlyDivisiblePair(): Int {
        for (i in 0..(lastIndex - 1)) {
            for (j in i + 1..(lastIndex)) {
                if (get(i) % get(j) == 0) return get(i) / get(j)
                if (get(j) % get(i) == 0) return get(j) / get(i)
            }
        }

        throw RuntimeException("No evenly divisible pair found")
    }
}

fun main(args: Array<String>) {
    val file = File(args[0])
    println(ChecksumCalculator().calculateSpreadsheetChecksum(file))
    println(ChecksumCalculator().calculateAdvSpreadsheetChecksum(file))
}
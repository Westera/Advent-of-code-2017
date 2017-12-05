import java.io.File

class InstructionJumper {
    fun escapeOperations(instructions: MutableList<Int>): Int {
        var index = 0
        var counter = 0
        while (index < instructions.size) {
            index = instructions.moveAndInc(index)
            counter++
        }
        return counter
    }

    fun MutableList<Int>.moveAndInc(currentIndex : Int) : Int {
        val newIndex = currentIndex + get(currentIndex)

        set(currentIndex, get(currentIndex)+1)
        return newIndex
    }

    fun convertFileToList(input : File) : MutableList<Int> {
        val returnList = mutableListOf<Int>()
        input.forEachLine {
            returnList.add(it.toInt())
        }
        return returnList
    }
}

fun main(args: Array<String>) {
    val file = File(args[0])
    val ij = InstructionJumper()
    println(ij.escapeOperations(ij.convertFileToList(file)))
}
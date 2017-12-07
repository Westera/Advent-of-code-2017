class MemoryReallocation {

    fun debugReallocation(input: List<Int>): Int {
        val mutableInput = input.toMutableList()
        val previousStates = mutableSetOf(input.toList())
        var newState = true

        while(newState){
            val blocks = mutableInput.max()
            val startIndex = mutableInput.indexOf(blocks)
            mutableInput[startIndex] = 0
            for(i in 1..(blocks ?: 0)){
                mutableInput[(startIndex+i)%mutableInput.size] = mutableInput[(startIndex+i)%mutableInput.size] + 1
            }
            newState = previousStates.add(mutableInput.toList())
        }

        return previousStates.size
    }

    fun debugReallocationWithLoopLength(input: List<Int>): Int {
        val mutableInput = input.toMutableList()
        val previousStates = mutableSetOf(input.toList())
        var newState = true

        while(newState){
            val blocks = mutableInput.max()
            val startIndex = mutableInput.indexOf(blocks)
            mutableInput[startIndex] = 0
            for(i in 1..(blocks ?: 0)){
                mutableInput[(startIndex+i)%mutableInput.size] = mutableInput[(startIndex+i)%mutableInput.size] + 1
            }
            newState = previousStates.add(mutableInput.toList())
        }

        (previousStates.size - 1 downTo 0)
                .asSequence()
                .filter { mutableInput == previousStates.elementAt(it) }
                .forEach { return previousStates.size - it }

        return - 1
    }

}

fun main(args: Array<String>) {
    val blocks = args.map { it.toInt() }.toMutableList()
    println(MemoryReallocation().debugReallocation(blocks))
    println(MemoryReallocation().debugReallocationWithLoopLength(blocks))
}
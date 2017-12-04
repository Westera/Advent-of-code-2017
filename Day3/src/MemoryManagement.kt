import kotlin.math.absoluteValue

class MemoryManagement {

    fun carryBack(from: Int): Int {
        var x = 0
        var y = 0
        var currentDirection = DIRECTION.RIGHT
        var currentStep = 1

        var i = 1
        while (i < from && currentStep != 0) {
            if (i + currentStep > from)
                currentStep = from - i

            x += currentDirection.x * currentStep
            y += currentDirection.y * currentStep

            i += currentStep

            if (currentDirection.y != 0) currentStep++

            currentDirection = currentDirection.changeDirection()
        }

        return x.absoluteValue + y.absoluteValue
    }

    fun storeValues(until: Int): Int {
        val visitedPoints = mutableListOf(Point(0, 0, 1))
        var x = 0
        var y = 0
        var currentDirection = DIRECTION.RIGHT
        var currentStep = 1

        var i = 1
        while (true) {
            for (j in 1..currentStep) {
                x += 1 * currentDirection.x
                y += 1 * currentDirection.y
                visitedPoints.add(Point(x, y, visitedPoints.getSumOfNeighbours(x, y)))
                if (visitedPoints.last().value > until) {
                    return visitedPoints.last().value
                }
            }

            i += currentStep

            if (currentDirection.y != 0) currentStep++

            currentDirection = currentDirection.changeDirection()
        }
    }

    private fun List<Point>.getSumOfNeighbours(x: Int, y: Int): Int = listOfNotNull(
            getPoint(x, y + 1),
            getPoint(x, y - 1),
            getPoint(x + 1, y + 1),
            getPoint(x + 1, y),
            getPoint(x + 1, y - 1),
            getPoint(x - 1, y + 1),
            getPoint(x - 1, y),
            getPoint(x - 1, y - 1)
    ).map { it.value }.sum()

    private fun List<Point>.getPoint(x: Int, y: Int) = firstOrNull { it.x == x && it.y == y }
}

data class Point(val x: Int, val y: Int, val value: Int = 0)

enum class DIRECTION(val x: Int, val y: Int) {
    RIGHT(1, 0),
    UP(0, 1),
    LEFT(-1, 0),
    DOWN(0, -1);

    fun changeDirection(): DIRECTION {
        return when (this) {
            RIGHT -> UP
            UP -> LEFT
            LEFT -> DOWN
            DOWN -> RIGHT
        }
    }
}

fun main(args: Array<String>) {
    println(MemoryManagement().carryBack(args[0].toInt()))
    println(MemoryManagement().storeValues(args[0].toInt()))
}
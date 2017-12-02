class CaptchaSolver {

    fun solve(captcha: String):Int {
        return calculateSum(captcha.makeCircular())
    }

    fun advSolve(captcha: String):Int {
        val half = captcha.length/2
        return calculateSum(captcha.makeCircular(half), half)
    }

    private fun calculateSum(circleCaptcha: String, distance: Int = 1): Int {
        return circleCaptcha.windowed(distance + 1).map {
            if (it.first() == it.last())
                it.first().toInt() - 48
            else
                0
        }.sum()
    }

    private fun String.makeCircular(extra: Int = 1) : String {
        return plus(substring(0, extra))
    }
}

fun main(args: Array<String>) {
    println(CaptchaSolver().solve(args[0]))
    println(CaptchaSolver().advSolve(args[0]))
}
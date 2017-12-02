class CaptchaSolver {

    fun solve(captcha: String):Int {
        val circleCaptcha = captcha + captcha[0]
        return circleCaptcha.windowed(2).map{
            if(it[0] == it[1])
                it[0].toInt()-48
            else
                0
        }.sum()
    }
}

fun main(args: Array<String>) {
    println(CaptchaSolver().solve(args[0]))
}
package solutions.SUM

object SumSolution {
    fun sum(x: Int, y: Int): Int {
        require(x >= 0 && x<= 100 && y >= 0 && y <= 100) { "Sum inputs must be between 0 and 100" }

        return x+y
    }
}



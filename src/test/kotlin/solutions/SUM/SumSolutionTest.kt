package solutions.SUM

import org.junit.jupiter.api.*

class SumSolutionTest {

    @Test
    fun sum() {
        Assertions.assertEquals(2, SumSolution.sum(1, 1))
    }

    @Test
    fun negativeInputs(){
        val exception = assertThrows<IllegalArgumentException>{
            SumSolution.sum(-1,-1)
        }
        Assertions.assertEquals("Sum inputs must be between 0 and 100", exception.message)
    }

    @Test
    fun singleNegative(){
        val exception = assertThrows<IllegalArgumentException>{
            SumSolution.sum(10,-1)
        }
        Assertions.assertEquals("Sum inputs must be between 0 and 100", exception.message)
    }

    @Test
    fun lessThan100(){
        val exception = assertThrows<IllegalArgumentException>{
            SumSolution.sum(110,10)
        }
        Assertions.assertEquals("Sum inputs must be between 0 and 100", exception.message)
    }
}
package solutions.SUM

import org.junit.jupiter.api.*

class SumSolutionTest {

    @Test
    fun sum() {
        assertEquals(2, SumSolution.sum(1, 1))
    }

    @Test
    fun 'negative inputs'(){
        val exception = assertThrows<IllegalArgumentException>{
            SumSolution.sum(-1,-1)
        }

        assertEquals("Sum inputs must be between 0 and 100", exception.message)
    }
}
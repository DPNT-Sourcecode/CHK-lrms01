package solutions.HLO

import org.junit.jupiter.api.*

class HelloSolutionTest {

    @Test
    fun stringIsReturned(){
        Assertions.assertEquals("Hello World", HelloSolution.hello(""))
    }

}
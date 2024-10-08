package solutions.HLO

import org.junit.jupiter.api.*

class HelloSolutionTest {

    @Test
    fun stringIsReturned(){
        Assertions.assertEquals("Hello, John!", HelloSolution.hello("John"))
        Assertions.assertEquals("Hello, Darragh!", HelloSolution.hello("Darragh"))
    }
}
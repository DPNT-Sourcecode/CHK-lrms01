package solutions.CHK

import org.junit.jupiter.api.*

class CheckoutSolutionTest {


    @Test
    fun blankSKU(){
        val exception = assertThrows<IllegalArgumentException> {
            CheckoutSolution.checkout(" ")
        }
        Assertions.assertEquals("SKUs must contain items", exception.message)
    }

}
package solutions.CHK

import org.junit.jupiter.api.*

class CheckoutSolutionTest {


    @Test
    fun blankSKU(){
        Assertions.assertEquals(0, CheckoutSolution.checkout(""))
    }

    @Test
    fun invalidItems(){
        Assertions.assertEquals(-1, CheckoutSolution.checkout("HJ"))
    }

    @Test
    fun regularCheckoutReturnsCorrectly(){
        Assertions.assertEquals(35, CheckoutSolution.checkout("CD"))
    }

    @Test
    fun lowercaseSKUReturnsCorrectly(){
        Assertions.assertEquals(35, CheckoutSolution.checkout("cD"))
    }

    @Test
    fun specialOfferFunctions(){
        Assertions.assertEquals(130, CheckoutSolution.checkout("AAA"))
    }
}
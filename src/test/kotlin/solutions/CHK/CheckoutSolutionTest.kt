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

    // @Test
    // fun lowercaseSKUReturnsCorrectly(){
    //     Assertions.assertEquals(35, CheckoutSolution.checkout("cD"))
    // }

    @Test
    fun specialOfferFunctions(){
        Assertions.assertEquals(130, CheckoutSolution.checkout("AAA"))
    }

    // @Test
    // fun removeWhitespace() {
    //     Assertions.assertEquals(45, CheckoutSolution.checkout(" B B "))
    // }

    @Test
    fun multipleOffers(){
        Assertions.assertEquals(175, CheckoutSolution.checkout("AAABB"))
    }

    @Test
    fun eOfferFunctionsCorrectly(){
        Assertions.assertEquals(80, CheckoutSolution.checkout("EEB"))
    }

    @Test
    fun eOfferFunctionsCorrectlySpareB(){
        Assertions.assertEquals(230, CheckoutSolution.checkout("EEEEEBBB"))
    }

    @Test
    fun fOfferFunctionsCorrectly(){
        Assertions.assertEquals(30, CheckoutSolution.checkout("FFFF"))
    }

    @Test
    fun noFOfferforTwoF(){
        Assertions.assertEquals(20, CheckoutSolution.checkout("FF"))
    }

    @Test
    fun fiveFOffer() {
        Assertions.assertEquals(40, CheckoutSolution.checkout("FFFFF"))
    }
}

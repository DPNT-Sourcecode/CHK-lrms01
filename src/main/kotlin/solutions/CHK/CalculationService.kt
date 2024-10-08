package solutions.CHK

object CalculationService {

    // Create functions to calculate the total of "A" items
    fun calcA(count: Int): Int {
        var runningTotal = 0
        var remainingCount = count

        // Test each of the available offers
        val aOffers = CheckoutSolution.offers['A'] as? List<Offer> ?: return remainingCount * CheckoutSolution.prices['A']!!

        for(offer in aOffers){

            // Test how many times we can apply the offer
            val offerQuantity = remainingCount / offer.quantity

            // Apply the offer 'x' times and add the cost to the total
            runningTotal += offerQuantity * offer.cost

            // Adjust the remaining count as to be available for the next offer
            remainingCount %= offer.quantity
        }

        // Add whatever the cost of the remaining items is
        runningTotal += remainingCount * CheckoutSolution.prices['A']!!
        return runningTotal
    }

    fun calcB(count: Int): Int {
        val offer = CheckoutSolution.offers['B'] as? Offer ?: return count * CheckoutSolution.prices['B']!!
        val offersAdded = count / offer.quantity
        val remainingItems = count % offer.quantity

        return ( offersAdded.toInt() * offer.cost ) + ( remainingItems * CheckoutSolution.prices['B']!! )

    }

    fun calcOthers(item: Char, count: Int): Int{
        return count * CheckoutSolution.prices[item]!!
    }
}

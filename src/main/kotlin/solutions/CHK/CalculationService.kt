package solutions.CHK

object CalculationService {

    fun calcFreeItesm(offerItem: Char, offerCount: Int, freeItem: Char, charFreq: MutableMap<Char, Int>): MutableMap<Char, Int>{
        val numberFree = charFreq[offerItem]?.div(offerCount) ?: 0
        charFreq[freeItem] = maxOf(charFreq.getOrDefault(freeItem, 0) - numberFree, 0)

        return charFreq
    }

    // Create functions to calculate the total of "A" items
    fun calcMultiOffer(count: Int, item: Char): Int {
        var runningTotal = 0
        var remainingCount = count

        // Test each of the available offers
        val aOffers = CheckoutSolution.offers[item] as? List<Offer> ?: return remainingCount * CheckoutSolution.prices[item]!!

        for(offer in aOffers){

            // Test how many times we can apply the offer
            val offerQuantity = remainingCount / offer.quantity

            // Apply the offer 'x' times and add the cost to the total
            runningTotal += offerQuantity * offer.cost

            // Adjust the remaining count as to be available for the next offer
            remainingCount %= offer.quantity
        }

        // Add whatever the cost of the remaining items is
        runningTotal += remainingCount * CheckoutSolution.prices[item]!!
        return runningTotal
    }

    fun calcSingleOffer(count: Int, item: Char): Int {
        val offer = CheckoutSolution.offers[item] as? Offer ?: return count * CheckoutSolution.prices[item]!!
        val offersAdded = count / offer.quantity
        val remainingItems = count % offer.quantity

        return ( offersAdded.toInt() * offer.cost ) + ( remainingItems * CheckoutSolution.prices[item]!! )

    }

    fun calcOthers(item: Char, count: Int): Int{
        return count * CheckoutSolution.prices[item]!!
    }
}


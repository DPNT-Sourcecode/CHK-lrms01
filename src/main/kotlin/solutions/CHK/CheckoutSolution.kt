package solutions.CHK

import kotlin.math.floor

object CheckoutSolution {
    // Create our Price and offers tables
    val prices = mapOf(
        'A' to 50,
        'B' to 30,
        'C' to 20,
        'D' to 15,
        'E' to 40
    )

    val offers = mapOf(
        'A' to listOf(Offer(5,200), Offer(3, 130)),
        'B' to Offer(2, 45)
    )

    // Create functions to calculate the total of "A" items
    fun calcA(count: Int): Int {
        var runningTotal = 0
        var remainingCount = count

        // Test each of the available offers
        val aOffers = offers['A'] as? List<Offer> ?: return remainingCount * prices['A']!!

        for(offer in aOffers){

            // Test how many times we can apply the offer
            val offerQuantity = remainingCount / offer.quantity

            // Apply the offer 'x' times and add the cost to the total
            runningTotal += offerQuantity * offer.cost

            // Adjust the remaining count as to be available for the next offer
            remainingCount %= offer.quantity
        }

        // Add whatever the cost of the remaining items is
        runningTotal += remainingCount * prices['A']!!
        return runningTotal
    }

    fun calcB(count: Int): Int {
        val offer = offers['B'] as? Offer ?: return count * prices['B']!!
        val offersAdded = count / offer.quantity
        val remainingItems = count % offer.quantity

        return ( offersAdded.toInt() * offer.cost ) + ( remainingItems * prices['B']!! )

    }

    fun calcOthers(item: Char, count: Int): Int{
        return count * prices[item]!!
    }

    fun checkout(skus: String): Int {    
        // Ensure all Items in the SKU are capitalised and stripped of
        // whitespace to match the map

        //val adjustedSKUs = skus.uppercase().replace(" ", "").trim()

        // Start by Checking All Items in the SKU are valid
        if(skus.any{ it !in prices.keys }) {
            return -1
        }
        
        // Get a count of each individual char in the SKU
        var charFreq = skus.groupingBy { it }.eachCount().toMutableMap()


        // Calculate the number of free Bs and remove them from the item count
        val freeBs = charFreq['E']?.div(2) ?: 0
        charFreq['B'] = maxOf(charFreq.getOrDefault('B', 0) - freeBs, 0)

        //Start calculating the total running cost
        var totalCost = 0

        // Cycle through all the items and send them to their
        // respective handlers, then add the total to the running cost
        charFreq.forEach { item, count ->
           totalCost += when (item) {
            'A' -> calcA(count)
            'B' -> calcB(count)
            else -> calcOthers(item, count)
           }
        }
        
        return totalCost
    }
}

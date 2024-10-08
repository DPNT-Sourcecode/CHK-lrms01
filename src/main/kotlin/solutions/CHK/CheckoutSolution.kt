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
        'A' to ListOf(Pair(5,200), Pair(3, 130)),
        'B' to Pair(2, 45)
    )

    // Create functions to calculate the total of "A" items
    fun calcA(count: Int): Int {
        var runningTotal = 0

        offers[A]?.forEach { (offerCount, offerPrice) ->
            val offerQuantity = count / offerCount
            runningTotal += offerQuantity * offerPrice
            count %= offerCount
        }
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
        charFreq['B'] = charFreq.getOrDefault('B', 0) - freeBs

        //Start calculating the total running cost
        var totalCost = 0

        // Cycle through all the item counts in the map
        charFreq.forEach { item, count ->
            // Test whether offers exist for the current item
            if(item in offers) {

                // Get the number of items needed for the offer
                // and the price of the offer
                val (offerCount, offerPrice) = offers[item]!!
                
                // Find out how many times the count fits the offer
                val offersAdded = count / offerCount
                val remainingItems = count % offerCount

                // Add costs to the running total
                totalCost += ( offersAdded.toInt() * offerPrice ) + ( remainingItems * prices[item]!! )
            }
            else {
                totalCost += count * prices[item]!!
            }
        }
        
        return totalCost
    }
}

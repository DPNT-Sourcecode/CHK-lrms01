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
            'A' -> CalculationService.calcA(count)
            'B' -> CalculationService.calcB(count)
            else -> CalculationService.calcOthers(item, count)
           }
        }
        
        return totalCost
    }
}


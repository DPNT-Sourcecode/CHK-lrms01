package solutions.CHK

import kotlin.math.floor

object CheckoutSolution {
    // Create our Price and offers tables
    val prices = mapOf(
        'A' to 50,
        'B' to 30,
        'C' to 20,
        'D' to 15,
        'E' to 40,
        'F' to 10,
        'G' to 20,
        'H' to 10,
        'I' to 35,
        'J' to 60,
        'K' to 80,
        'L' to 90,
        'M' to 15,
        'N' to 40,
        'O' to 10,
        'P' to 50,
        'Q' to 30,
        'R' to 50,
        'S' to 30,
        'T' to 20,
        'U' to 40,
        'V' to 50,
        'W' to 20,
        'X' to 90,
        'Y' to 10,
        'Z' to 50
    )

    val offers = mapOf(
        'A' to listOf(Offer(5,200), Offer(3, 130)),
        'B' to Offer(2, 45),
        'F' to Offer(3, 20),
        'H' to listOf(Offer(10, 80), Offer(5,45)),
        'K' to Offer(2,150),
        'P' to Offer(5, 200),
        'Q' to Offer(3,80),
        'U' to Offer(4,120),
        'V' to listOf(Offer(3,130), Offer(2,90))   
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
            'A' -> CalculationService.calcMultiOffer(count, item)
            'B' -> CalculationService.calcSingleOffer(count, item)
            'F' -> CalculationService.calcSingleOffer(count, item)
            else -> CalculationService.calcOthers(item, count)
           }
        }
        
        return totalCost
    }
}

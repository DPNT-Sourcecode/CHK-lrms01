package solutions.CHK

import kotlin.math.floor


fun MutableMap<Char,Int>.calcFreeItems(offerItem: Char, offerCount: Int, freeItem: Char): MutableMap<Char, Int>{
    val numberFree = this[offerItem]?.div(offerCount) ?: 0
    this[freeItem] = maxOf(this.getOrDefault(freeItem, 0) - numberFree, 0)

    return this
}
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
        // Start by Checking All Items in the SKU are valid
        if(skus.any{ it !in prices.keys }) {
            return -1
        }
        
        // Get a count of each individual char in the SKU
        var charFreq = skus.groupingBy { it }.eachCount().toMutableMap()

        // Calculate the number of free Bs and remove them from the item count
        charFreq.calcFreeItems('E', 2, 'B')
        charFreq.calcFreeItems('N', 3, 'M')
        charFreq.calcFreeItems('R', 3, 'Q')

        val groupItemsCount = charFreq.getOrDefault('S', 0) +
                          charFreq.getOrDefault('T', 0) +
                          charFreq.getOrDefault('X', 0) +
                          charFreq.getOrDefault('Y', 0) +
                          charFreq.getOrDefault('Z', 0)

        val totalGroupDiscount = groupItemsCount.div(3) * 45
        var remaining = groupItemsCount
        while(remaining != (groupItemsCount % 3)){
            // Remove from groups in order of most to least expensive
            
        }

        //Start calculating the total running cost
        var totalCost = 0

        // Cycle through all the items and send them to their
        // respective handlers, then add the total to the running cost
        charFreq.forEach { item, count ->
           totalCost += when (item) {
            'A', 'H', 'V' -> CalculationService.calcMultiOffer(count, item)
            'B', 'F', 'K', 'P', 'Q', 'U' -> CalculationService.calcSingleOffer(count, item)
            else -> CalculationService.calcOthers(item, count)
           }
        }
        
        return totalCost
    }
}


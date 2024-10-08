package solutions.CHK

object CheckoutSolution {
    // Create our Price and offers tables
    val prices = mapOf(
        'A' to 50,
        'B' to 30,
        'C' to 20,
        'D' to 15
    )

    val offers = mapOf(
        'A' to Pair(3, 130),
        'B' to Pair(2, 45)
    )

    fun checkout(skus: String): Int {    
        // Ensure all Items in the SKU are capitalised and stripped of
        // whitespace to match the map
        val adjustedSKUs = skus.uppercase().replace(" ", "").trim()

        // Start by Checking All Items in the SKU are valid
        if(adjustedSKUs.any{ it !in prices.keys }){
            return -1
        }
        
        // Get a count of each individual char in the SKU
        val charFreq = adjustedSKUs.groupingBy { it }.eachCount()


        //Start calculating the total running cost
        var totalCost = 0
        println(offers['A'].toString())
        charFreq.forEach{ item, count ->
            
        }
        
        return -1
    }
}

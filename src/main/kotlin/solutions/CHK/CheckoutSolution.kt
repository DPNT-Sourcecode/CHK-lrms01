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
        'A' to pair(3, 130),
        'B' to pair(2, 45)
    )

    fun checkout(skus: String): Int {

        // Ensure all Items in the SKU are capitalised to match the map
        val upperSKUs = skus.uppercase()

        // Start by Checking All Items in the SKU are valid

        TODO("Solution not implemented")
    }
}

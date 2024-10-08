// package solutions.CHK

// object CalculationService {

//     // Create functions to calculate the total of "A" items
//     fun calcA(count: Int): Int {
//         var runningTotal = 0

//         // Test each of the available offers
//         offers['A']?.forEach { (offerCount, offerPrice) ->

//             // Test how many times we can apply the offer
//             val offerQuantity = count / offerCount

//             // Apply the offer 'x' times and add the cost to the total
//             runningTotal += offerQuantity * offerPrice

//             // Adjust the remaining count as to be available for the next offer
//             count %= offerCount
//         }

//         // Add whatever the cost of the remaining items is
//         runningTotal += count * CheckoutSolution.prices['A']!!
//         return runningTotal
//     }
// }
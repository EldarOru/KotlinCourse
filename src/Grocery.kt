data class Grocery(val name:String, val category:String,
                    val unit: String, val unitPrice:Double,
                    val quantity: Int)

fun main() {
    val groceries = listOf(Grocery("Tomatoes","Vegetable","lb", 3.0,3),
    Grocery("Mushrooms", "Vegetable","lb",4.0,1),
    Grocery("Bagels","Bakery","Pack", 1.5, 2),
    Grocery("Olive oil", "Pantry", "Bottle", 6.0,1),
    Grocery("Ice cream", "Frozen", "Pack",3.0,2))
    val highestUnitPrice = groceries.maxBy { it.unitPrice }
    println(highestUnitPrice)
    val newPrices = groceries.filter { it.unitPrice > 3.0 }
            .map { it.unitPrice * 2 }
    println(newPrices)
    val groupByCategory = groceries.groupBy { it.category }
    println(groupByCategory.keys)
    groceries.groupBy { it.category }.forEach{
        println(it.key)
        it.value.forEach { println("   ${it.name}") }
    }
    val ints = listOf(1,2,3)
    val sumOfInts = ints.fold(0){runningSum,item -> runningSum + item}
    println(sumOfInts)
    val sumOfInts1 = ints.fold(1){runningSum,item -> runningSum + item}
    println(sumOfInts1)
    val names = groceries.fold(" "){string, item -> string + " ${item.name}"}
    println("names:  $names")
    groceries.filter { it.category == "Vegetable" }.sumByDouble { it.unitPrice * it.quantity }
    
}

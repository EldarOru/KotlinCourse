data class Recipe(val title:String,val isVegeterian:Boolean){

}

fun main() {
    val r = Recipe("Chicken",false)
    var r1 = Recipe("Meat", false)
    println(r === r1)

}
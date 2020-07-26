data class Recipe(val title:String,val isVegeterian:Boolean = true){

}

fun main() {
    val r = Recipe("Chicken",false)
    var r1 = Recipe("Meat")
    println(r === r1)
    var recipeList = mutableListOf(r,r1)
    
}
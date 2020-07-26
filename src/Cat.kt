class CatBig(val name: String, weight_param: Int, breed_param: String) {

    var activities = arrayOf("Play")
    val breed = breed_param.toUpperCase()

    var weight = weight_param
        set(value) {
            if (value > 0) field = value
        }

    val weightInGramms: Int
        get() = weight * 1000

    fun sleep() {
        println(if (weight < 3) "сопит!" else "храпит!")
    }
}

fun main() {
    var myCat = CatBig("Matilda", 4, "MIXED")
    println("Моего кота зовут ${myCat.name}, он весит ${myCat.weight}")
    myCat.weight = -1
    println("Моего кота зовут ${myCat.name}, он весит ${myCat.weight}")
    myCat.weight = 5
    println("Моего кота зовут ${myCat.name}, он весит ${myCat.weight}")


}
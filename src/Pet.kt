abstract class Pet (var name: String)
class Cat (name:String):Pet(name)
class Dog (name: String):Pet(name)
class Fish(name:String):Pet(name)
interface Retailer<out T>{
    fun sell():T
}

class CatRetailer:Retailer<Cat>{
    override fun sell(): Cat {
        println("Sell Cat")
        return Cat("")
    }
}

class DogRetailer:Retailer<Dog>{
    override fun sell(): Dog {
        println("Sell Cat")
        return Dog("")
    }
}

class Vet<T: Pet>{
    fun treat(t: T){
        println("Treat Pet ${t.name}")
    }
}

class Contest<T:Pet>(var vet: Vet<in T>){
    val scores : MutableMap<T,Int> = mutableMapOf()

    fun addScore(t: T, score: Int = 0){
        if (score >= 0) scores.put(t, score)
    }

    fun getWinners(): MutableSet<T>{
        val highScore = scores.values.max()
        val winners: MutableSet<T> = mutableSetOf()
        for ((t,score) in scores){
            if (score == highScore) winners.add(t)
        }
        return winners
    }
}

fun main() {
    /*val petRetailer: Retailer<Pet> = CatRetailer()
    При interface Retailer<T>
    код выше не скомпилируется, хотя Cat подкласс Pet
     */
    val petRetailer: Retailer<Pet> = CatRetailer()
    //код выше сработаете при interface Retailer<out T>
    val dogRetailer: Retailer<Dog> = DogRetailer()
    val catVet = Vet<Cat>()
    val petVet = Vet<Pet>()
    catVet.treat(Cat("Cutie"))
    petVet.treat(Fish("Fishy"))
    val catContest = Contest<Cat>(catVet)
    /*
    При class Vet<T: Pet>
    val catContest1 = Contest<Cat>(petVet) не будет работать
     */
    val catContest1 = Contest<Cat>(Vet<Pet>())
    //работает при class Vet<in T: Pet>
}
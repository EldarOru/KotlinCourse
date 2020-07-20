fun main() {
    while (true) {
        val options = arrayOf("Rock", "Paper", "Scissors")
        val gameChoice = getGameChoice(options)
        val userChoice = getUserChoice(options)
        printResult(userChoice, gameChoice)
    }
}
fun getGameChoice(optionsParam:Array<String>) = optionsParam[(Math.random() * optionsParam.size).toInt()]
fun updateArray(optionArray:Array<String>){
    optionArray[2] = "Fred"
}
fun getUserChoice(optionsParam: Array<String>):String{
    var isValidChoice = false
    var userChoice = ""
    while (!isValidChoice) {
        print("Please enter one of the following:")
        for (item in optionsParam) {
            print(" $item")
        }
        println(".")
        val userInput = readLine()
        if (userInput != null && userInput in optionsParam){
            isValidChoice = true
            userChoice = userInput
        }
        if (!isValidChoice) println("You must enter a valid choice")
    }
    return userChoice
}
fun printResult(userChoice:String, gameChoice:String){
    var wins = 0
    var ties = 0
    var loses = 0
    val result:String
    if (userChoice == gameChoice) {
        result = "Tie!"
        ties++
    }
    else if ((userChoice == "Rock" && gameChoice == "Scissors")||
            (userChoice == "Paper" && gameChoice == "Rock")||
            (userChoice == "Scissors" && gameChoice == "Paper")){
        wins ++
        result = "Win!"
    }
    else{
        loses++
        result = "You lose!"
    }
    println("You chose $userChoice. I chose $gameChoice. $result")
    println("Wins = $wins, loses = $loses, ties = $ties")

}


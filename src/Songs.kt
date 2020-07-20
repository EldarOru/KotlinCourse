class Song(val title: String, val artist: String){
    fun play(){
        println("Playing the song $title by $artist")
    }
    fun stop(){
        println("Stopped playing $title")
    }
    init {
        println("$title was created!")
    }
}

fun main() {
    val songOne = Song("The Mesopotamians","They might be Giants")
    val songTwo = Song("Going Underground","The Jam")
    val songThree = Song("Make Me Smile","Steve Harley")
    songTwo.play()
    songTwo.stop()
    songThree.play()
}
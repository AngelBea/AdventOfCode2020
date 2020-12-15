package angelbea.interfaces

interface IAdventCodes {
    val nameOfChallenge : String
    val input : MutableList<String>

    fun start()
    fun run(){
        println("""----------------[START]--------------------""")
        println("""------------$nameOfChallenge---------------""")

        start()

        println("""----------------[END]----------------------""")
    }
}
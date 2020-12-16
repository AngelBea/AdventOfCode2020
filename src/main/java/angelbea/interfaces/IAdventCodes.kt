package angelbea.interfaces

interface IAdventCodes {
    val nameOfChallenge : String
    var input : MutableList<String>

    fun start()
    fun run(){
        println("""----------------[START]--------------------""")
        println("""------------$nameOfChallenge---------------""")

        start()

        println("""----------------[END]----------------------""")
    }
}
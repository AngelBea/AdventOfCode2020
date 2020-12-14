package Interfaces

interface AdventCodes {
    val nameOfChallenge : String
    val input : MutableList<String>

    fun start()
}
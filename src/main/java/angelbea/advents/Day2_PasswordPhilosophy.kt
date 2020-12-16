package angelbea.advents

import angelbea.INPUT_FILE_2
import angelbea.ScannerTool
import angelbea.interfaces.IAdventCodes

class Day2_PasswordPhilosophy : IAdventCodes {
    override val nameOfChallenge: String
        get() = javaClass.simpleName
    override var input: MutableList<String> = ScannerTool().readFileFromDisk(INPUT_FILE_2)

    override fun start() {
        val minMaxFinder = "^\\d*-\\d*".toRegex()
        val letterFinder = "\\w:".toRegex()
        var valids = 0
        var newValids = 0

        input.forEach { passwordLine ->
            val digits = minMaxFinder.find(passwordLine)?.value?.split("-")?.map{ it.toInt() }
            val letterRegex = letterFinder.find(passwordLine)?.value?.replace(":", "")?.toRegex()
            val numberOfLetters = letterRegex?.findAll(passwordLine.split(letterFinder)[1])?.map { it.value }?.toList()

            if (numberOfLetters?.size in digits?.get(0)!!..digits.get(1)){
                valids++
            }

            val letter = letterRegex.toString()
            val password = passwordLine.split(letterFinder)[1].trim()
            val positionLetters = Pair(password.get(digits.get(0) - 1).toString(), password.get(digits.get(1) - 1).toString())

            if(positionLetters.first == letter || positionLetters.second == letter){
                if(positionLetters.first != positionLetters.second){
                    newValids++
                }
            }

        }


        println("Valids passwords part 1 -> $valids")
        println("Valids passwords part 2 -> $newValids")
    }
}
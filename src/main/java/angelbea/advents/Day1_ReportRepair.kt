package angelbea.advents

import angelbea.*
import angelbea.interfaces.IAdventCodes

class Day1_ReportRepair : IAdventCodes {
    override val nameOfChallenge: String
        get() = javaClass.simpleName
    override var input: MutableList<String> = ScannerTool().readFileFromDisk(INPUT_FILE_1)

    override fun start() {
        val theBadYear = 2020
        var result1 = 0
        var result2 = 0
        input.forEach {inputNumber ->
            val inputNumberInt = inputNumber.toIntOrNull() ?: 0

            val number = input.filter {
                theBadYear - inputNumberInt == it.toIntOrNull() ?: 1
            }

            if (number.isNotEmpty()) {
                result1 = inputNumberInt.times(number[0].toInt())
            }

            input.filter { inputNumberInt + (it.toIntOrNull() ?: 0) < theBadYear }
                .map { Pair(inputNumberInt, (it.toIntOrNull() ?: 0)) }
                .forEach{ pair ->
                    val thirdNumber = input.filter { pair.first + pair.second + (it.toIntOrNull() ?: 0) == 2020 }

                    if(thirdNumber.isNotEmpty()){
                        result2 = pair.first * pair.second * (thirdNumber[0].toIntOrNull() ?: 0)
                    }
                }


        }

        println("Result Part 1 --> $result1")
        println("Result Part 2 --> $result2")
    }
}
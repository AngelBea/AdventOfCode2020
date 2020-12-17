package angelbea.advents

import angelbea.*
import angelbea.interfaces.IAdventCodes
import kotlin.math.ceil
import kotlin.math.floor

class Day5_BinaryBoarding : IAdventCodes {
    override val nameOfChallenge: String
        get() = javaClass.simpleName
    override var input: MutableList<String> = ScannerTool().readFileFromDisk(INPUT_FILE_5)

    override fun start() {
        var highestSeatId = 0
        var lowestSeat = 0
        var mySeat = 0

        input.map { seat ->
            seat.replace("$UPPER_HALF_COLUMN|$UPPER_HALF_ROW".toRegex(), "1")
                .replace("$LOWER_HALF_COLUMN|$LOWER_HALF_ROW".toRegex(), "0")
        }.map { decimalString ->
            Pair("^\\d{7}".toRegex().find(decimalString)!!.value.toInt(2),
                "\\d{3}".toRegex().find(decimalString, 7)!!.value.toInt(2))
        }.map {
            it.first * 8 + it.second
        }.sortedByDescending { it }.let {
            highestSeatId = it[0]
            lowestSeat = it[it.size-1]
            return@let it
        }.zipWithNext().filter { it.second != it.first - 1 }.map { it.first - 1 }.let {
            mySeat = it[0]
        }

        println("The highest seat is: $highestSeatId")
        println("The lowest seat is: $lowestSeat")
        println("And my seat is $mySeat")
    }
}
package angelbea.advents

import angelbea.*
import angelbea.interfaces.IAdventCodes

class Day6_CustomCustoms : IAdventCodes {
    override val nameOfChallenge: String
        get() = javaClass.simpleName
    override var input: MutableList<String> = ScannerTool().readFileSplittingByDoubleReturnKey(INPUT_FILE_6)

    override fun start() {
        val sumOfPositiveAnsweredQuestionsPerGroup = input.map { groupOfPeople ->
            groupOfPeople.split(REGEX_BREAK_LINE).joinToString("").groupBy { it }.keys.count()
        }.sum()

        val sumOfPositiveAnswersEveryone = input.map {
            val differentClientsAnswers = it.split(REGEX_BREAK_LINE)
            val valuesInsideList = differentClientsAnswers.groupBy { it.chars() }.values.toMutableList()[0].toString()
            valuesInsideList.filter { possitveAnswer ->
                differentClientsAnswers.all { possitveAnswer in it }
            }.takeIf { it.isNotBlank() }
        }.filterNotNull().map { it.length }.sum()

        println("The sum of part one is --> $sumOfPositiveAnsweredQuestionsPerGroup")
        println("The sum of part two is --> $sumOfPositiveAnswersEveryone")
    }

}
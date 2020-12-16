package angelbea.advents

import angelbea.*
import angelbea.interfaces.IAdventCodes

class Day3_TobogganTrajectory : IAdventCodes {
    override val nameOfChallenge: String
        get() = javaClass.simpleName
    override var input: MutableList<String> = ScannerTool().readFileFromDisk(INPUT_FILE_3)

    override fun start() {
        val slope11 =  calculateSlopes(1,1)
        val slope13 =  calculateSlopes(1,3)
        val slope15 =  calculateSlopes(1,5)
        val slope17 =  calculateSlopes(1,7)
        val slope21 =  calculateSlopes(2,1)

        println("Number of trees | Down: 1 | Right: 1 -> $slope11")
        println("Number of trees | Down: 1 | Right: 3 -> $slope13")
        println("Number of trees | Down: 1 | Right: 5 -> $slope15")
        println("Number of trees | Down: 1 | Right: 7 -> $slope17")
        println("Number of trees | Down: 2 | Right: 1 -> $slope21")

        println("The total product of all Slope Calculation is -->  ${(slope11*slope13*slope15*slope17*slope21)}")
    }
    /*
        * @Params:
        *   downVal - The down value on which the slope will go
        *   rightVal - The right value on which slope will go
        *   printMapVal - Wether or not print the map, for debug purposes
        * @Return:
        *   numberOfTrees - The total number of trees on this slope
    */
    fun calculateSlopes(downVal : Int, rightVal : Int, printMapVal : Boolean = false) : Long{
        var numberOfTrees = 0
        var right = rightVal
        val printMap = printMapVal

        for (down in 0 until input.size step downVal){
            val line = input[down]
            if(down == 0){
                if(printMap) println(line)
                continue
            }

            if(line[right].toString() == TREE){
                //println("That's a tree in $down,$right --> ${line[right]}")
                if (printMap && downVal > 1) println(input[down - downVal + 1])
                if (printMap) println(line.replaceRange(right..right, "O"))
                numberOfTrees++
            }else{
                //println("Not a tree in $down,$right-> ${line[right]}")
                if (printMap && downVal > 1) println(input[down - downVal + 1])
                if (printMap) println(line.replaceRange(right..right, "X"))
            }

            if(right + rightVal < line.length){
                right += rightVal
            }else{
                right = right + rightVal - line.length
            }
        }

        return numberOfTrees.toLong()
    }
}
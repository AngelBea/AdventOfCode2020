package angelbea.advents

import angelbea.INPUT_FILE_3
import angelbea.ScannerTool
import angelbea.interfaces.IAdventCodes

class Day_3_TobogganTrajectory : IAdventCodes {
    override val nameOfChallenge: String
        get() = javaClass.simpleName
    override val input: MutableList<String>
        get() = ScannerTool().readFileFromDisk(INPUT_FILE_3)

    override fun start() {
        var numberOfTrees = 0

        for (down in 0 until input.size){
            for (right in input[down].indices step 3){
                if(down == 0){
                    continue
                }

            }
        }
    }
}
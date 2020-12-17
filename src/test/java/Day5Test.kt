import angelbea.FOLDER_INPUTS
import angelbea.ScannerTool
import angelbea.advents.Day3_TobogganTrajectory
import angelbea.advents.Day5_BinaryBoarding
import org.junit.Test

class Day5Test {
    @Test
    fun testWithExample(){
        val day5 = Day5_BinaryBoarding()
        day5.input = ScannerTool().readFileFromDisk("${FOLDER_INPUTS}TEST_INPUT_5_1")
        day5.run()
    }
}
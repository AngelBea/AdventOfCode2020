import angelbea.FOLDER_INPUTS
import angelbea.ScannerTool
import angelbea.advents.Day3_TobogganTrajectory
import angelbea.advents.Day5_BinaryBoarding
import angelbea.advents.Day7_HandyHaversacks
import org.junit.Test

class Day7Test {
    @Test
    fun testWithExample(){
        val day7 = Day7_HandyHaversacks()
        day7.input = ScannerTool().readFileFromDisk("${FOLDER_INPUTS}TEST_INPUT_7_1")
        day7.run()
    }
}
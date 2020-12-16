import angelbea.*
import angelbea.advents.Day_3_TobogganTrajectory
import org.junit.Test

class Day3Test {
    @Test
    fun testWithExample(){
        val day3 = Day_3_TobogganTrajectory()
        day3.input = ScannerTool().readFileFromDisk("${FOLDER_INPUTS}TEST_INPUT_3_1")
        day3.run()
    }
}
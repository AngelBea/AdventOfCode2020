import angelbea.FOLDER_INPUTS
import angelbea.ScannerTool
import angelbea.advents.Day4_PassportProcessing
import org.junit.Test

class Day4Test {
    @Test
    fun testWithExample() {
        val day4 = Day4_PassportProcessing()
        day4.input = ScannerTool().readFileSplittingByDoubleReturnKey("${FOLDER_INPUTS}TEST_INPUT_4_1")
        day4.run()
    }

    @Test
    fun testInvalids() {
        val day4 = Day4_PassportProcessing()
        day4.input = ScannerTool().readFileSplittingByDoubleReturnKey("${FOLDER_INPUTS}TEST_INPUT_4_2_Invalid")
        day4.run()
    }

    @Test
    fun testValids() {
        val day4 = Day4_PassportProcessing()
        day4.input = ScannerTool().readFileSplittingByDoubleReturnKey("${FOLDER_INPUTS}TEST_INPUT_4_3_Valids")
        day4.run()
    }
}

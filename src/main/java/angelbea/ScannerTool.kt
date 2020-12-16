package angelbea

import angelbea.ROOT
import java.io.File
import java.util.*

class ScannerTool {
    fun readFileFromDisk(nameFile : String) : MutableList<String>{
        val scn = Scanner(File(ROOT +nameFile))
        val inputListValue = mutableListOf<String>()

        while (scn.hasNextLine()){
            inputListValue.add(scn.nextLine())
        }

        return  inputListValue
    }
}
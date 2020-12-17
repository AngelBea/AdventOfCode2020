package angelbea

import angelbea.ROOT
import angelbea.advents.Day4_PassportProcessing.*
import com.sun.deploy.Environment
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

    fun readFileSplittingByDoubleReturnKey(nameFile: String) : MutableList<String> {
        val inputListValue = mutableListOf<String>()
        val listPassport = File(ROOT + nameFile).readText().split("\\r\\n\\r\\n|\\n\\n".toRegex())
        inputListValue.addAll(listPassport)
        return inputListValue
    }
}
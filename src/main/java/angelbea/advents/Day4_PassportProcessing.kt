package angelbea.advents

import angelbea.INPUT_FILE_4
import angelbea.ScannerTool
import angelbea.interfaces.IAdventCodes


class Day4_PassportProcessing : IAdventCodes{
    override val nameOfChallenge: String
        get() = javaClass.simpleName
    override var input: MutableList<String> = ScannerTool().readFileFromDisk(INPUT_FILE_4)

    override fun start() {
        var readingPassport = false
        var passportLines = mutableListOf<String>()
        val listOfPassPorts = mutableListOf<Passport>()
        var indexOfLine = -1
        var lineBuilder = StringBuilder()

        input.forEach { batchLine ->
            if (batchLine.isBlank()){
                passportLines.add(lineBuilder.toString())
                lineBuilder = StringBuilder()
                readingPassport = false
            }else if(!readingPassport){
                indexOfLine++
                readingPassport = true
            }

            if (readingPassport){
                lineBuilder.append(" $batchLine")
            }
        }

        for (passportLine in passportLines){
            val passport = Passport(
                Extractors.BIRTH_YEAR.extractor.find(passportLine)?.value?.replace("\\w*:".toRegex(), ""),
                Extractors.ISSUE_YEAR.extractor.find(passportLine)?.value?.replace("\\w*:".toRegex(), ""),
                Extractors.EXPIRATION_YEAR.extractor.find(passportLine)?.value?.replace("\\w*:".toRegex(), ""),
                Extractors.HEIGHT.extractor.find(passportLine)?.value?.replace("\\w*:".toRegex(), ""),
                Extractors.HAIR_COLOR.extractor.find(passportLine)?.value?.replace("\\w*:".toRegex(), ""),
                Extractors.EYE_COLOR.extractor.find(passportLine)?.value?.replace("\\w*:".toRegex(), ""),
                Extractors.PASSPORT_ID.extractor.find(passportLine)?.value?.replace("\\w*:".toRegex(), ""),
                Extractors.COUNTRY_ID.extractor.find(passportLine)?.value?.replace("\\w*:".toRegex(), "")
            )

            println(passportLine)
            println("${passport.isValid()} --> $passport")
            listOfPassPorts.add(passport)
        }

        println("Number of valid passports --> ${listOfPassPorts.filter { it.isValid() }.size}")

    }

    data class Passport(var birthYear : String?, var issueYear : String?, var expirationYear : String?, var height : String?,
                        var hairColor : String?, var eyeColor : String?, var passportId : String?, var countryId : String?)

    fun Passport.isValid(): Boolean{
        return listOfNotNull(birthYear, issueYear, expirationYear, height, hairColor, eyeColor, passportId).size >= 7
    }

    enum class Extractors(val extractor : Regex){
        BIRTH_YEAR("byr:\\w*".toRegex()),
        ISSUE_YEAR("iyr:\\w*".toRegex()),
        EXPIRATION_YEAR("eyr:\\w*".toRegex()),
        HEIGHT("hgt:\\w*".toRegex()),
        HAIR_COLOR("hcl:#[A-Za-z0-9]*|hcl:\\w*".toRegex()),
        EYE_COLOR("ecl:#[A-Za-z0-9]*|ecl:\\w*".toRegex()),
        PASSPORT_ID("pid:\\d*".toRegex()),
        COUNTRY_ID("cid:\\w*".toRegex())
    }
}
package angelbea.advents

import angelbea.INPUT_FILE_4
import angelbea.ScannerTool
import angelbea.interfaces.IAdventCodes


class Day4_PassportProcessing : IAdventCodes{
    override val nameOfChallenge: String
        get() = javaClass.simpleName
    override var input: MutableList<String> = ScannerTool().readFileSplittingByDoubleReturnKey(INPUT_FILE_4)

    override fun start() {
        val listOfPassPorts = mutableListOf<Passport>()

        input.forEachIndexed { index, passportLine ->
            val passport = Passport(
                index,
                Extractors.BIRTH_YEAR.extractor.find(passportLine)?.value?.replace("\\w*:".toRegex(), ""),
                Extractors.ISSUE_YEAR.extractor.find(passportLine)?.value?.replace("\\w*:".toRegex(), ""),
                Extractors.EXPIRATION_YEAR.extractor.find(passportLine)?.value?.replace("\\w*:".toRegex(), ""),
                Extractors.HEIGHT.extractor.find(passportLine)?.value?.replace("\\w*:".toRegex(), ""),
                Extractors.HAIR_COLOR.extractor.find(passportLine)?.value?.replace("\\w*:".toRegex(), ""),
                Extractors.EYE_COLOR.extractor.find(passportLine)?.value?.replace("\\w*:".toRegex(), ""),
                Extractors.PASSPORT_ID.extractor.find(passportLine)?.value?.replace("\\w*:".toRegex(), ""),
                Extractors.COUNTRY_ID.extractor.find(passportLine)?.value?.replace("\\w*:".toRegex(), "")
            )

            println("\n-----[${passport.isValid()} PASSPORT $index]-----")
            println(passportLine.lines().joinToString { it })
            println(passport)
            listOfPassPorts.add(passport)
        }

        println("Number of valid passports --> ${listOfPassPorts.filter { it.isValid() }.size}")
    }


    data class Passport(val passportIndex : Int, var birthYear : String?, var issueYear : String?, var expirationYear : String?, var height : String?,
                        var hairColor : String?, var eyeColor : String?, var passportId : String?, var countryId : String?)

    fun Passport.isValid(): Boolean{
        if (this.birthYear == null) {
            println("$passportIndex NOT VALID --> Reason: Birth Year is null")
            return false
        }
        if (this.issueYear == null) {
            println("$passportIndex NOT VALID --> Reason: Issue Year is null")
            return false
        }
        if (this.expirationYear == null) {
            println("$passportIndex NOT VALID --> Reason: Expiration Year is null")
            return false
        }
        if (this.height == null) {
            println("$passportIndex NOT VALID --> Reason: Height is null")
            return false
        }
        if (this.hairColor == null) {
            println("$passportIndex NOT VALID --> Reason: Hair Color is null")
            return false
        }
        if (this.eyeColor == null) {
            println("$passportIndex NOT VALID --> Reason: Eye Color is null")
            return false
        }
        if (this.passportId == null) {
            println("$passportIndex NOT VALID --> Reason: Passport Id is null")
            return false
        }

        return true
    }

    enum class Extractors(val extractor : Regex){
        BIRTH_YEAR("byr:(19[2-9][0-9]|200[0-2])(?![\\d\\w])".toRegex()),
        ISSUE_YEAR("iyr:(201[0-9]|2020)(?![\\d\\w])".toRegex()),
        EXPIRATION_YEAR("eyr:(202[0-9]|2030)(?![\\d\\w])".toRegex()),
        HEIGHT("hgt:(15[0-9]|16[0-9]|17[0-9]|18[0-9]|19[0-3])cm(?![\\d\\w])|hgt:(59|6[0-9]|7[0-6])in(?![\\d\\w])".toRegex()),
        HAIR_COLOR("hcl:#[a-f0-9]{6}(?![\\d\\w])".toRegex()),
        EYE_COLOR("ecl:((amb)|(blu)|(brn)|(gry)|(grn)|(hzl)|(oth))(?![\\d\\w])*".toRegex()),
        PASSPORT_ID("pid:\\d{9}(?![\\d\\w])".toRegex()),
        COUNTRY_ID("cid:\\w*".toRegex())
    }
}
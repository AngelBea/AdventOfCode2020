package angelbea

import java.io.File

val SEP = File.separator
val ROOT = File("").absolutePath+ SEP
val FOLDER_INPUTS = "inputs$SEP"
val INPUT_FILE_1 = "${FOLDER_INPUTS}INPUT_ADVENT_1"
val INPUT_FILE_2 = "${FOLDER_INPUTS}INPUT_ADVENT_2"
val INPUT_FILE_3 = "${FOLDER_INPUTS}INPUT_ADVENT_3"
val INPUT_FILE_4 = "${FOLDER_INPUTS}INPUT_ADVENT_4"
val INPUT_FILE_5 = "${FOLDER_INPUTS}INPUT_ADVENT_5"

//DAY 3 Const
const val TREE = "#"

//DAY 5 Const
const val LOWER_HALF_ROW = "F"
const val UPPER_HALF_ROW = "B"
const val MAX_INDEX_ROW = 6
const val MAX_ROWS = 127
const val MIN_ROWS = 0

const val UPPER_HALF_COLUMN = "R"
const val LOWER_HALF_COLUMN = "L"
const val MAX_INDEX_COLUMN = 2
const val MAX_COLUMNS = 7
const val MIN_COLUMNS = 0

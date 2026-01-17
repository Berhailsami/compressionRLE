fun compressImage(
    dataArray: Array<Array<String>>,
): List<Pair<String,Int>>{

    val numberOfRows= dataArray.size
    val myRows = splitMatrixRows(dataArray, numberOfRows)
    val result = mutableListOf<Pair<String,Int>>()

    myRows.forEach{ row->
        val rowToCompress = row.joinToString("")
        val compressedRow = RLE(rowToCompress)
        result += compressedRow
    }
    return result
}

fun splitMatrixRows(
    dataArray: Array<Array<String>>,
    numberOfRows: Int
) : List<Array<String>>{

    val result = mutableListOf<Array<String>>()

    for (i in 0 until numberOfRows){
        result.add(dataArray[i])
    }
    return result
}

fun RLE(text: String): List<Pair<String,Int>>{

    var number = 0
    var last: Char? = null
    val result = mutableListOf<Pair<String,Int>>()

    text.forEach { letter->
        if( last == null){
            last = letter
            number = 1
        } else if (letter == last) {
            number++
        } else {
            result += Pair(last.toString(), number)
            last = letter
            number = 1
        }

    }
    result += Pair(last.toString(), number)
    return result

}
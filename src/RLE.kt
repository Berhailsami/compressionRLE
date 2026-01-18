fun compressImage(dataArray: Array<Array<String>>): List<Pair<String, Int>> {
    val result = mutableListOf<Pair<String, Int>>()

    for (row in dataArray) {
        result += rleRow(row)
    }

    return result
}

fun rleRow(row: Array<String>): List<Pair<String, Int>> {

    val result = mutableListOf<Pair<String, Int>>()

    var last: Char? = null
    var count = 0

    for (cell in row) {

        val char = cell[0]

        if (last == null) {
            last = char
            count = 1
        } else if (char == last) {
            count++
        } else {
            result.add(last.toString() to count)
            last = char
            count = 1
        }
    }

    if (last != null) {
        result.add(last.toString() to count)
    }

    return result
}

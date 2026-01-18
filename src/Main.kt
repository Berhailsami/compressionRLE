fun main(){
    val colorGrid = arrayOf(
        arrayOf("R", "G", "G", "B"),
        arrayOf("B", "R", "R", "B"),
        arrayOf("Y", "Y", "W", "R")
    )
    val result = compressImage(colorGrid)
    result.forEach{ print(it) }

}
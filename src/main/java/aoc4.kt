import kotlin.math.min

fun findNumberOfXmasAndSamx(inputList: List<String>): Int {

    val matchXmas = "XMAS".toRegex()

    val matchSamx = "SAMX".toRegex()

    return inputList.fold(0) { sum, line -> sum + (matchSamx.findAll(line).count() + matchXmas.findAll(line).count()) }
}

fun findVerticals(input: String): Int {

    val inputList = input.split("\n").map { it.trimIndent() }.map { line -> line.map {  it }.toMutableList() }.toMutableList()

    val chars = inputList[0].size

    val invertedMatrix = mutableListOf<List<Char>>()

    for (x in 0..<chars) {
        var newList1 = inputList.map { it[x] }
        invertedMatrix.add(newList1)
    }

    val flatList = invertedMatrix.map { it.joinToString().replace(", ", "") }

    return findNumberOfXmasAndSamx(flatList)
}


fun findTotalForGrid(input: String): Int {
    val listAsChars = input.split("\n").map { it.map { it } }

    val verticals = findVerticals(input)

    val horizontals = findNumberOfXmasAndSamx(input.split("\n"))

    val rightDiagonal = findNumberOfXmasAndSamx(findDiagonals(listAsChars))

    val leftDiagonal = findNumberOfXmasAndSamx(findOtherDiagonals(listAsChars))

    return horizontals+verticals+leftDiagonal+rightDiagonal
}

fun findDiagonals(grid: List<List<Char>>): List<String> {
    val rows = grid.size
    val cols = grid[0].size
    val diags = cols + rows - 1
    val words = arrayOfNulls<String>(diags)

    var row = 0
    var col = cols -1

    for (i in 0 until diags) {
        val n = min((rows - row), (cols - col))
        val word = CharArray(n)
        for (i in 0 until n) {
            word[i] = grid[row + i][col + i]
        }
        words[i] = String(word)

        if (col > 0) {
            --col
        } else {
            ++row
        }
    }
    return words.toList() as List<String>
}

fun findOtherDiagonals(grid: List<List<Char>>): List<String> {
    val invertedGrid = grid.map { it.reversed() }
    return findDiagonals(invertedGrid)
}


fun findAs(input: List<String>): Int {
    val gridSize = input.size
    val lineSize = input[0].length
    val grid = input.map { line -> line.map { it }}
    var counter = 0
    for (i in input.indices) {
        for (j in input[i].indices) {
            if (grid[i][j] == 'A') {
                if (i == 0 || j == 0 || i == gridSize-1 || j == lineSize-1) continue
                else
                    counter+=searchAround(grid, i, j, gridSize - 1, lineSize - 1)
            }
        }
    }
    return counter
}


fun searchAround(grid: List<List<Char>> , column: Int, index: Int, n: Int, indexMax: Int) : Int {
    val samLeft =  grid[column - 1][index-1] == 'S' && grid[column + 1][index + 1] == 'M'

    val samRight = grid[column - 1][index + 1] == 'S' && grid[column + 1][index - 1] == 'M'

    val masLeft = grid[column - 1][index - 1] == 'M' && grid[column + 1][index + 1] == 'S'

    val masRight = grid[column - 1][index + 1] == 'M' && grid[column + 1][index - 1] == 'S'

    val samSam = samLeft && samRight

    val masMas = masLeft && masRight

    val masSam = masLeft && samRight

    val samMas = samLeft && masRight

    var count = 0

    if (samSam) count++
    if (samMas) count++
    if (masSam) count++
    if (masMas) count++

    return count

}
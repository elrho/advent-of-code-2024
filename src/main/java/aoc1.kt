import kotlin.math.absoluteValue

fun findPairs(leftList: MutableList<Int>, rightList: MutableList<Int>): List<Pair<Int, Int>> {

    leftList.sort()
    rightList.sort()
    var index = 0
    return leftList.map { (it to rightList[index++]) }
}

fun findDifferenceSum(input: List<MutableList<Int>>): Int {
    val leftList = input.first()
    val rightList = input.last()
    val pairs = findPairs(leftList, rightList)

    return pairs.map { (k, v) -> (v - k).absoluteValue }.sum()
}

fun createLists(input: String): List<MutableList<Int>> {

    val bigList = input.split("\n")
        .flatMap { it.split(" ") }
        .filter { it != "" }

    val rightList = mutableListOf<Int>()
    val leftList = mutableListOf<Int>()

    var counter = 0
    bigList.forEach {
        if (counter % 2 == 0) leftList.add(it.toInt()) else rightList.add(it.toInt())
        counter++}

    return listOf(leftList, rightList)
}

fun run(input: String): Int {
    val list = createLists(input)

    return findDifferenceSum(list)

}

fun findSimilarities(input: List<MutableList<Int>>): Int {
    val leftList = input.first()

    val rightList = input.last()

    val result = mutableMapOf<Int, Int>()
    leftList.forEach { leftItem ->
        val count = rightList.count { it == leftItem}
        if (count != 0 )result += leftItem to rightList.count { it == leftItem} }
    val endMap = result.map { (leftItem, count) -> (leftItem * count)}
    return endMap.sum()
}

fun runPartTwo(input: String): Int {
    val list = createLists(input)

    return findSimilarities(list)
}
import kotlin.math.absoluteValue

fun getSafetyStatusPart2(input: MutableList<Int>): String {
    var result = "safe"
    var safetyScore = 0
    var problemDampener = 1

    val positive = meantToBeIncreasing(input)

    if (input.sorted() != input || input.sortedDescending() != input) {
        if (positive) { result = orderMakesItUnsafe(input, true)

        }
        else {
            result = orderMakesItUnsafe(input, false)

        }
    } else {
        for (i in 1..<input.size) {
            if (input[i] - input[i - 1].absoluteValue !in 3 downTo 1) {
                safetyScore++
                if (safetyScore > 1 || problemDampener == 0) {
                    result = "unsafe"
                    break
                }
            } else
                if (safetyScore > 0) {
                    if (safetyScore > 1) {
                        result = "unsafe"
                        break
                    }

                    if ((input[i] - input[i - 2]).absoluteValue !in 3 downTo 1) safetyScore++
                    else {
                        if (problemDampener == 0) {
                            result = "unsafe"
                            break
                        } else {
                            safetyScore--
                            problemDampener--
                        }
                    }
                }
        }
    }


    return result
}

fun meantToBeIncreasing(input: MutableList<Int>): Boolean {
    val differences = mutableListOf<Int>()
    for (i in 1..<input.size) {
        differences+=input[i] - input[i-1]
    }
    return differences.filter { it > 0 }.size > (input.size)/2
}

fun getNumberOfSafeRecords(input: String): Int {

    val lists = input.split("\n").map { record -> record.split(" ").map { it.toInt() }.toMutableList() }

    return lists.map { getSafetyStatusPart2(it) }.
    filter { it != "unsafe" }.size

}

fun getSafetyStatusPart1(input: MutableList<Int>): String {
    var result = "safe"
    if (input.sorted() == input || input.sortedDescending() == input) {
        for (i in 1..<input.size) {
            if ((input[i] - input[i - 1]).absoluteValue !in 3 downTo 1)
                result = "unsafe"
            break
        }
    }
    if (result == "unsafe") result = getSafetyStatusPart2(input)
    return result
}

fun orderMakesItUnsafe(input: MutableList<Int>, increasing: Boolean): String {
    var result = "safe"
    val order = mutableListOf<Int>()
    for (i in 1..<input.size) {
        if (increasing) {
            order += if (input[i] > input[i - 1]) 1 else 0
            if (order.filter { it == 0 }.size > 1) result = "unsafe"
        }
        else {
            order += if (input[i] < input[i - 1]) 1 else 0
            if (order.filter { it == 0 }.size > 1) result = "unsafe"
        }

    }

    return result
}


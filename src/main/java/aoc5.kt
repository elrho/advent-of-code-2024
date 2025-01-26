fun isOrdered(pageOrders: String, update: List<Int>): Boolean {
    val orderMap = mapPageOrders(pageOrders)
    var orderFlag = true

    for (i in update.indices) {
        var number = update[i]
        var orders = orderMap.filter { it.first == number }
        for (order in orders) {
            if (order.second in update) {
                if (update.indexOf(order.second) > i) {
                    orderFlag = true
                } else {
                    orderFlag = false
                    break
                }
            }
            else continue
        }
        if (!orderFlag) break
    }
    return orderFlag
}

fun mapPageOrders(pageOrders: String): List<Pair<Int, Int>> {
    return pageOrders.split("\n").map { order -> order.substringBefore("|").toInt() to order.substringAfter("|").toInt()  }
}

fun countOrders(pageOrders: String, updates: String): Int {
    val orderedLists = createUpdateList(updates).filter { isOrdered(pageOrders, it) }

    return getMiddles(orderedLists).sum()
}

private fun getMiddles(orderedLists: List<List<Int>>): List<Int> {

    return orderedLists.map {
        val middleIndex = (it.size) / 2
        it[middleIndex]
    }

}


fun createUpdateList(updates:String): List<List<Int>> {
    return updates.split("\n").map { it.split(",").map { value -> value.toInt() } }
}

fun correctedOrdersTotal(pageOrders: String, update: String): Int {
    val notOrderedLists = createUpdateList(update).filter { !isOrdered(pageOrders, it) }

    val correctedOrders = notOrderedLists.map { orderRuleBroken(pageOrders, it) }

    return getMiddles(correctedOrders).sum()
}

fun orderRuleBroken(pageOrders: String, update: List<Int>): MutableList<Int> {
    val orderMap = mapPageOrders(pageOrders)

    val brokenRules = mutableListOf<Pair<Int, Int>>()

    for (i in update.indices) {
        var number = update[i]
        var orders = orderMap.filter { it.first == number }
        for (order in orders) {
            if (order.second in update) {
                if (update.indexOf(order.second) < i)
                    brokenRules.add(order)
            }
            else continue
        }
    }

    var newList = update.toMutableList()

    var indexFirst = 0

    var indexSecond = 0

    for (order in brokenRules) {
        indexFirst = newList.indexOf(order.first)
        indexSecond = newList.indexOf(order.second)
        newList[indexSecond] = order.first
        newList[indexFirst] = order.second
    }

    return newList

}
import java.io.File

fun multiply(input: String): Int {
    val pattern = "[\\d]{1,3}".toRegex()

    val numbers = pattern.findAll(input).map { it.value }.toList()
    val a = numbers.first().toInt()
    val b = numbers.last().toInt()
    return a * b
}

fun getValidStrings(fileName: String): Int {

    val input = readFileAsTextUsingInputStream(fileName)

    val matchBetweenDoAndDont = "(?=do[(][)])(.*?)(?<=don't[(][)])".toRegex()

    val matchDont = "don't[(][)]".toRegex()

    val firstSection = input.split(matchDont).first()

    val lastSection = input.split("do()").last()

    val validSections = matchBetweenDoAndDont.findAll(input).map { it.value }.toMutableList()

    validSections+=firstSection

    validSections+=lastSection

    val matcher = "mul\\((\\d+){1,3}[,][\\d]{1,3}[)]".toRegex()

    val matches = validSections.flatMap { matcher.findAll(it).map { it.value }.toList() }

    return matches.fold(0) {sum, element -> sum + multiply(element) }
}

fun readFileAsTextUsingInputStream(fileName: String) = File(fileName).inputStream().readBytes().toString(Charsets.UTF_8)
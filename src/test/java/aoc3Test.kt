import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class aoc3Test {

    @Test
    fun `should multiply uncorrupted input`() {

        val input = "mul(5,5)"

        val expectedResult = 25

        assertThat(expectedResult).isEqualTo(multiply(input))
    }

    @Test
    fun `should find the valid multiplications in a string`() {
        val input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))mul(41,576)mul(416,854)\$/mul(743,671)"
        val expectedResult = 877594

        assertThat(expectedResult).isEqualTo(getValidStrings(input))
    }

    @Test
    fun `test with whole input`() {
        val expected = 2

        assertThat(expected).isEqualTo(getValidStrings("C:\\Users\\elean\\IdeaProjects\\advent-of-code-2024\\src\\test\\resources\\aoc3Input"))
    }

    @Test
    fun `should account for do and dont statements`() {
        val input = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"

        val expectedResult = 48

        assertThat(expectedResult).isEqualTo(getValidStrings(input))
    }
}
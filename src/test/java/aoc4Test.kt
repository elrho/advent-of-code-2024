import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class aoc4test {

//    @Test
//    fun `should find xmas going forward and backwards`() {
//        val input = """MMMSXXMASM
//                MSAMXMSMSA
//        AMXSXMAAMM
//        MSAMASMSMX
//        XMASAMXAMM
//        XXAMMXXAMA
//        SMSMSASXSS
//        SAXAMASAAA
//        MAMMMXMMMM
//        MXMXAXMASX"""
//
//        val expectedResult = 5
//
//        assertThat(expectedResult).isEqualTo(findNumberOfXmasAndSamx(input))
//}

    @Test
    fun `find backwards xmas`() {
        val input = """
        MMMSXXMASM
        MSAMXMSMSA
        AMXSXMAAMM
        MSAMASMSMX
        XMASAMXAMM
        XXAMMXXAMA
        SMSMSASXSS
        SAXAMASAAA
        MAMMMXMMMM
        MXMXAXMASX"""

        val expectedResult = 3
    }

    @Test
    fun `find vertical xmas and samx`() {
        val input = """
        MMMSXXMASM
        MSAMXMSMSA
        AMXSXMAAMM
        MSAMASMSMX
        XMASAMXAMM
        XXAMMXXAMA
        SMSMSASXSS
        SAXAMASAAA
        MAMMMXMMMM
        MXMXAXMASX"""

        val expectedResult = 3

        assertThat(expectedResult).isEqualTo(findVerticals(input))
    }

    @Test
    fun `find all xmas`() {
        val expectedResult = 3

        assertThat(findTotalForGrid(input4)).isEqualTo(expectedResult)
    }

    @Test
    fun `make a diagonals list from grid`() {
        val input = listOf(
            listOf('a', 'b', 'c'),
            listOf('d', 'e', 'f'),
            listOf('g', 'h', 'i'),
            listOf('j', 'k', 'l'),)

        val result = listOf(
            listOf('a'),
            listOf('b', 'd'),
            listOf('c', 'e', 'g'),
            listOf('f', 'h', 'j'),
            listOf('i', 'k'),
            listOf('l'),
        )

        assertThat(findOtherDiagonals(input)).isEqualTo(result)
    }

//    @Test
//    fun `part 2 - find all mas and sam`() {
//        val input = """
//.M.S......
//..A..MSMS.
//.M.S.MAA..
//..A.ASMSM.
//.M.S.M....
//..........
//S.S.S.S.S.
//.A.A.A.A..
//M.M.M.M.M.
//.........."""
//
//        val expectedResult = 18
//
//        assertThat(findCrossedXmas(input)).isEqualTo(expectedResult)
//    }

    @Test
    fun `part 2 - should look for mas and sam around As`() {

        val result = 1822

        assertThat(findAs(input4.split("\n"))).isEqualTo(result)
    }
}

val input4 = """MASAMXMSSXXMAMXXMXMASXMASXMMSMSMMMAXMASASMMSSMSXAXMASMMSMMMSSMSASMSSSSMSMSMXXMXMAXAMXMSMSSXSAMXMSSXSXSXMASXMSASXMMXSXMSSSSSXSAMMAMXSXXMAAXSA
MASMMXMASAXASMSMMMSAMXSMSAMXAAAAAXAMXASXAMAAAAMMSMMMMMASXAAAAMMAMAMMASAAAAXMXMSSSSSSMMSAMAXAXXSMAMSAMXASAXXASAMXASAMAXXMASAAAMAMAXXMASXSXSXS
MMXAXMMMSXMAMAAXAAXAAAXXSMMSMSMSMXAXMXSMMMMSSMXAMXAAXMAMMMMSSMMAMAMMAMMMMMXSAAXAAMMAXXSAMXMSMAXMAMSMSSXMASMMMSXSXMAXMMSMMMMMMSASMSXMAMAXXSAM
SXSAMASASMSXMSMSMSSMMMMMMXAMXMMXMASMMMMAXXAAAMMMSSSSSMASXXAAXASMSXXMXSXSXSASMSMMSMSAMMMAMXAAMASXMMSXMXMMMXASAXMSAASAMXSAAMXSXMASAXMMXSMSMMAM
AAAXXXMASASXMXMAXXMMASAASMXSASASXAAAAMSSMMMSXMAAMMMMMXAXMMMMSAMXAMASAMXSAMASXXAXAAMAMXSAMXSXSMMASAMSMASAAMSMMSSXMAXASASMMSAMASAMAMSMAAXMASXM
MSMMXXMMMAMAMMMMMMXSAXXAMMMMXSAXMMXXAMXAAMMXMASXMAAASMMXAAMXAXAMMMAMAMAMAMXMASXMMXMAAXMAXMAMXMSAMASXMAXMSXMAMXXXMASAMAMAXMMMAAXXAAAMXSXMMMAS
MXAXAMXXMMMMSAMAASMMMSMMASASAMAMAXMSXMSMMXAMXAXMMSSXSASXSSSMAMSMXMXSAMSSSMAMXMXAMAXXMMSAXAXMMXMASMMMMSSMMASAMMAMSMMAMAXSMXXMSSSSSSMXAXMSSMMM
ASXMMXSAMXAASXXMXSAAAXASAMMMASMSSSMAAMMXMMSSMASAMAMMMAMMAXMAXMASXMAXMSAAASASAMXSSMXSAAXSSMXAAXXAXMAMXMAMSMMAXMAAAAMXMAMXASXAMAMXMXMMAXAAXAXS
MAASMAMMSSMMSMSSXSMMXSMMASMSXMAAASMMMMAAMAMAMXAXAASMSSMMMMXSMSXSMXSXMXMXMSXMASAMAAAMMMMMMXXXSXMASMXMXMMMSXMSAMASMSMAXMASAAMXMMSSMASXXMXMAXMA
SAMXMXSAXAMASMXAASXSMMAXXMASAMMMMMMXXXSXMASAMXMASXSAAMXXXMMXMXAXMAMAMXXAAMAXAMASMMMSMMXSMMMXMAAMXXAXSXSASASXSMAMAAXMMSMMXMAXSAAAMXSASMSSXSAS
MMXSSXMXSAMASXXMXMAXAXXMSMMMXSAMXXMSXMMASXSXSXXAXMMMMMXMAXAMXMMMMASAMXSMSSSMSMMMMMAXXMAXAAAAXXSXXSASXAMAXXMAXMAMSMMSASXMAXMXMMSXSAMXMAAXASAM
ASAMXAMXSXMAMMMXAMSSSMSAXXXMSXASASXXAASAMXMAMAMSXXAXASASASXXSAAAMASAMAXXAAAMXASXSMXXAMASMMSMSAMAMXXXMMMSMXMMMXMXAAAMXSASXSSSXAAAMMAMMMMMAMAM
MMMSSXMXMAMXMSMXMSAAAAMMMXMSMSMMAAMSSMXAMMMAMXMXXSXSMSAMXSMAMSXSXAXAMSMMMSMMSAMAXAMXXAXXXAAAMXXMMSMMMSAMXXSASASXSMMXMSAMAAAAMMSXMAAMAMAMXMAM
XXAXMASMSAMAAAAASMMMMXMASMMAAAXMAMAAMMMSAMSAMSAXMAAMMMAMXMMMMAXXAMXSMMSMAXXXXAMSMMSASMMMMSMXMSMMAAAAAMMMXMMAMASAMAAAXMSMMMMMXXMASXSSSSXSASAS
SASAMXMAMMSASMSMXASMMASXSASMSSXSAMMXAAAASASAMXMXAXMSASASMXAAMMSMMSAMXAAMASMMSMMXAXMXXAAXXAAASAAMSSSMSXMXSAMAMAMASMSMSAMXMMASMMXMMAAAAXASMSSM
XAMASXSXSASAXMXMSXMASAXASMSAAXXMAMSSSMSAXMMMSAMXMSASASAMAMMMSAAMAMASMSXSAXAMAMXMXMASXSMMSXSXMAXMAAXAMASXMAMXSXMXMXAXMAMAMAAAXMSXMMMMMMXMXXXM
MMMASMAAMMMAMASASAMXMASMMAMMMMMXMMXAMAMXMAAXMAXXXMAMXMMMSSMAMMXMXSXMAXMMMSSSXSMSAMXSAXMASMMMASXMXSXXXAMAXAMMSASMSSSMSASASMXSAMAMXXAASXMMSASX
AXMAXXMXMXSAMMMAMAMXMXAMXSMSXASASMMAMXMSSXMSXSAMXMXMMXSXAAXMASXMXAMSXSAAXXAXXXAAXAAMMMXXMAMMAMAAAMMSMSSMMSSMSAMAAAAASASASAMXXAXMMSAXSAAXMASX
SXMASXXXMAXASMMMMMSXMMASXAAXSXSXSASMMASMSAXMAXAMXXMAMASMSSMMAXAAASASASMMAAMMXMSMSMXSAMXMXSXMASMMMSAXMMAXSMAMMXMMMSMMMAMAMXMAMXMAMAMMSXMXMXMX
MAMMAMXAMXSSMMXAAXAMASAMXMMASXSXSAMMSMSAXMASASAMMMAAMAXAMXXMMSMMAASMAMMXMMXSAAAAXMASASMMAMXXMAAAXMXSSMXMAXAMXAMSMMMSMSMSMAMMSAXMASAAXMMASAAX
SAXSAXSXSXMMASMSSMXMMMASXXAAMMMAMAMAAMMMMAMMMMAMAASXMSSSXMAXMAXAXMXMSMAXXAASMMMSMXMSAMXMASMSSSSMMSAXMASAMSMSXMMAAAAAXAAXSAMMMMXXXMMXSMSASMSM
MAMAXMMMXAASAMAMMMMMSSMSXSMXSAMSMMMSXSASAAXAAMAMSMMAMAAMAMXMSASXSXXXXAMXMMXSMSMXMAMMAMXSASAAXAAAXMAMSAMAXAMSASMSSMSSSMMMSMSAAXSSSXSMXAMXSXMX
MSMSMMXSMSMMAXMASAMSAMXMASAAMXSAAXAMXSMSSSSSXSAXXXXAMMSMXXSXMASAXXMASAMXMSXXAAAASAXMAMMMMMMMMSAMMAMXMMXSMXMSAMAAAAXXMAXMXMSMMSAMAAMXSAMXXASM
AMAMAXAMXXXSXMXAXMXMASAMXMMMSMSXSMMSAMXXAXAAXAXMASMSMSMXXXAMMMMMMSMXSMMSAMXMSMSMSMSSMMMASXSSMMXSMAXMASAMXXXMMMMMMXMMSMMSAMXASMAMMSMMAAXXMASM
XMAMMMXSAMASMAMXSXXSAMAMSMMAAASMXXMAAASMXMMMMMXXXAAAMAMMMXMAAMAMAMXASAAAAMAAAAAMXMMASXSXMAMAAMAMXSXSAMXMAMXSXAMSMSAMAXAXAMAMMSSMXMXAXXMSAMXM
SMXSAAAMAMAMMSMAXAMMXSAMAAXSMXXASXSMSMAMXAAXMXMMMMSMMAMSAAXSXSAMAMXXSMMSASXSMSMSAMSAMMSAMXMSAMXSAXMMXMAXAMAAMAMAAAXSASMSSMXSAAXMASASAMXSAASM
AAAAMMSSXMASAAMSXSAMXSXSXSMXMASASAMXMAASASXMXAAXAXAASAXASXMMASXSASMMMXAXXMAAMXXXMMMXMAMAMXMXAMXSAXAXSXMXAMMXSAMMSMMMMSMAMXMMMSSMXAAXAAAMXMXM
MMMSAAXMMMSMMSSMAMMMMMMMMXAXSXSAMXMAXXXSXAAMSSSXMXSXMXSMMSAMAMAMXSAAAMXMAMMMMMSMSXSMMMXMMAXSAMAMASMXMASXSMMASXSAMXSAMXMAMAXASXXMMMMMMMXMMSSM
SAMAMMSMSMXAMMXMAMMSASASASAMMAMMMMMXMSAMXMXMAAMASMMXSMAXAXMMMMSMMMXSMSSSSSMAAAMMSAMMAMASXSMSAMXSASAXMAMAMAMMSAMXSASASXSMSMSXSXAMAAAAXSASAAXX
SMSMXXAAAAMMMMASASASASXMASAMXMAXAXSXMAAXMSXMAMXAMAMAMXSMMSXSXAAMXSMXXAAMAAMSMMSAMXMMASMSAMXSAMXMASXMMMSASAMAMXMAMASAMMSMAAXMMMSSSSSSSMAMMMMX
XAAXASMSMSMAAXXXAXMMMMAMAMAMXXSSMXXMAMXMAMASXSMMMAMAMMXXAAAXMSXSAMAAMMSMSSMMMAMXSAMSASAMXMASXMAMMMMAXMAXXMSAMXMAMXMAMAMMMXMSXAAMAAAXAMXMSASA
MXMXAMXAXMMSXSMMSMSSSSMMSSXMXXXAMXXSSSSMXSAMAMAAXSMMMAAMSMXXMAMMASASMAXMAAAAMMSASAXMSMXMXMASMXXXAAXMAMMAXMSXSASXSXSAMSSMSMASMMMSAMMMSXMXXASA
SASXSSSXMSXMAAAAXAAAXMASXMAAXXMSAMMAAAXAAMASAMMMAMASMSXAXXAXMSSSXMAXMXSMSSMMSMAXMMMXAMXXMXAXMASMSMXSAASMXAXXSAMSAASXMAAAXMAXXAASMAMAXAXXMMMM
SASAXAMXASAXSSSMMMMMMXMSASXMXMAXAXMMMMMMMMXAXXAMXXAMAMXSAMAMSAAXMMMMSXSAAXMASMMMMMXMMAMMAMSSMAXAAAASAMAAMSMXMSMMMMMMASMMXMMSMXMSSSMASMMAAAAA
MSMXMAMSSMMMXAAAXXMASMXSAMSAMXSMSMMASAAXMXAAMMXXSMSSXMXXASAMXMSMSAMXMAMMMMMMMMAAAAAAXMMAXXMMMMMSMMMSAXMMMMAXAXXAAAXXAXAMXAAAXMMMMMMAMMSXSMSS
SAMXSMMXXAAAMMMSAMXSMAAMAMMMXMXXAAMASXSXMSXSXSXASAMXAMXSXMAMMXMASASXMMMSXXSMMSSSSSSSSMSSSMXSAXXMAXAXXMXSAXMMMXSSSXMMSXMMSMSSSXSAAAMMXMXMMMXM
XAMMASMSSMMSMAAXXAXMXMMSMMASASXASXMASAMXXSAMAAMMMAMSAMAXMASXMAMMMAMXAMSMSXAAMXAAAAMAAAAAAAAMXXMXMMSSMSASMMXAXAXMAXSAMAMXSAMAAMASXMXMAMMSAXAM
SSMMSAMXAASMXMMSMMMSAMXXXSASASAXAAMAMAMMMMAMMXSASAMMAMXXXAXAMMSMSSSMSMSAXSSMMMMMMXMMMMMSMMMXMMAASAMAAMASAASXMMXMXXMAMXMMSAMMMMXASXSSXSASASMS
XAXSMMSSSMMXAMAAAAXMMSSMAXXMXMXSSXMXMAMAAMXMXASASASMSMXSAMXMMSAMMAAAXAMXMMMSMXSAMXSAAXXAMXSAASMMSAMMMMMMMMAAMAMSASMSMASASAMSMXSAMXAAAAXMAMAA
MXMXAAXMMMMSSMSSSSSMASAMSSMXXSAXAMMSSXSSSMSMMXMAMAMMXSAMXSAMXSASMSMMMSMMXMXAMXSAMXSSMMAMXAMMMMSASXMASMXSSMSSMASMASAXSMMASXMXMMAASMMMMMMMAMAM
MXXMMMSMXSAAAAAXAXAMMXAMAAAAMXXSAAAAXXMAMAXXMXMMMSMMXMXSASASASAMXXXAAXAMASAXMASXMMMMSMAXMMSXXAMMMMSAXSAMXAMXMMSMMMMXAXMAMXMASASMMAXSXSAMAXAX
MSMXAXXAAMMSMMMMSMSMMSMMXSMSXSMSXMMSMSMAMSMSMXMXMMAAMMXMASMMASAMXXSMXSXMAXAASASASXAAXXXMASAMMSMXMXMXSMXMMAMMMMXXXXXSMMMMSSXXAMMASMXAAMAMSMMS
AAASXMMMMSMAXXXAAMAAXSXSMXAMAAASAXMAXAAXMXAMXAXAMMXMAXAMMMMMAXAXMMXMXSAMASXXMASAMSMMAXMAMXASAMMSMAXMMMSASAMAAAAMXMXAXXXSAMMMMASAMXSMSMSMMAMX
SAXMSAAAAAMMMSMSSSMSMMAMAMAMXMSSMMMXASAMXMAMSMSXSSMSXMAXAAXMSSMMXMMSASMMMXXAMAMAMXMAXMASMSAMASASXSXSAAMXSAMSAMXAAAMMSMXMASAXSMMAMXAAMAXAMAMX
AMMASXMMSSSMASAMAAXXAMAMMSMMXXXXAAMXMMXXXMMMMAAAXMAXMASMSXSXAAXMAXSMAXXAXMSMMMSXMSMXMAXAMMMMAMXMAMAMMMSASMMXAXMSMSAMAMMSAMMXSAMAMXMSMMMSSSMM
SSMAMAMAMAAMAMAMXMMSAMXMXAAMAMMSSMSMXSXXMAXAMMMSMMSMXXMAXMSMSSMSXXAMSMSMSAMASAMXAAMSSSMSMAXAAXAMSMSMSXMASASMSMMAAXAMAMAMAMXMSAMXMMAMXXAAAAXX
MAMXSXMAMSMMXSXMASAMSMASMSSSMXAAXSAMAXMSSXSAMAAAAMMMSAMXMAXAXAMAXMXMXAMASXSAMASXMXSAAXAXSASMMSXSXAMAMXMXMXMAMMSASXSMSASMSMSXSMMAMMSMMMSSSMAA
SMMXMASAXMXMASASMSXSASMSAAAAMMMMSMMMMSMMAXAMSSSSXMAASXXMMAASMMMAXSAMMXMAMMMMSAMXMMMMSMMMMMSAASMMMSMAMSASMAMSMASAMAMAMAMAXXAAMXMSMMXAXMAAAXXM
XAMXXXASAMAMXSAMASMAMMXMXMMMMASXMMXSAAAMMAMMAXMMMSMAXMAXASMXAMMAXSASMSMASXSASAMMAAXAMMXAXASMMMAAAXXAMXAXMAMAMXMSMXMXMAMSMMMSMMMXAASAMAMSMMMM
SSMMSMAXXSXSAMAMAMAAXMAMXSMMSASMSMAMSSSMXMXMMSXAAXXAASMMMMASMMMXMSAMAAMXSXSAMAMXAMSASASASAMSXSSMSSSMMMAMSSSXSAAXMMMMSXMASXAXXXASMMMAAMXXXAAM
AAAAXAMSASAMXSXMXSSSSSMMAAAXMAXAAMXMXXMAXXSMXAMMMSASAMAAAMMMMAXMXMXSSMSSMMMMSAMXAXMASAMAMMXMMAXMAMXAAMAAAAAXSMXMMAAXMMAMAMASAMXMAASXMXASXSSS
SSMXXSAMMMAMASMMMAAAAAAMSSMMMAMSMSMMSAMAXMMAXAXAAXXMASXMSAMXSASMMSAMXMXXAAAMSMSMSXSXMAMXMSASAMMMXSSSXSMMMXXMXMASMSMSAMSXMXAMXXASMMMMSAMXAMXX
XAMXAXXMXSSMAXAMAMMMSMMXMAMMMMMXAMAMSAMASMMSMSMMMSAMAMXAMMMAMAMMAMXSAXASMMMXMXXXMAXXMXMXASAMMSAAXAAAAXXXMXSXXSXSAXASMMAMXSAMXMXXSAAAAASMXMAX
MAMSMMAAXAXMMSXXAMXXXMSMSSMAXMAMAXSMSAMMXMAAAXXAAXAMASMSMASXSASMSMAAMMMMSSMSXXAMXMXSMMSMMMXMASXSAMXMMXXAAAMAMMMMMMXMASMSAAAMAMSXSSMSSSSMSMMM
SMXAMSSMMMXXXAMMMMXXMXXAAAXXSMSMMMMAMMSSMMSMSMMMSSSSMMMXSAMXMASXXXMXSMSXXXXAAASAMMASAASAXMMMASXMAAXAMXMMMXSMXAAAMAMXAXXMASXMAXAMXAMMXAMAAAAX
AAMMXAAXMXASMMMXAXXMSMMMMSMMAAAAXSMSMAAAMAASXXAMXAMXMMXMMMSMMXMAXAMXAAXMMMMMSMMASMAMMMSSMXAMXSASXMSMMMXSAAAXSMSSSMSMMSMMMXMSSXSASXMSAMXMSSMM
MAAXMMSMMMMSAAASMMMAAAAAAMAXMSMXMXAXMMSAMSMMMMSSMMMSMSAAMASASASMSAMAMAMXAAAAAMSAMMSSMXXAXSSSSSMMMMAMMAAXXMMMXAAAAAMXXAAAXAMAXAMXMAMMMXAXXAMS
XSSXMXXMAAAMMMMMAAXSSSMMSSSMXXXMMMAMXXXMXMAASAAXASXMAAXXMXSASASMMAXXMAXMSXSSXMMAXSAAASMMMAAMMMAAXXASMMSSXMXSSSMSMMASMSSMSASAMMMASXMAXMXMSAXA
MXMAMMXSSSSSSMSSSMMMAAXAXXXAXMAASXSMSAMMAMAMMASXMMAMXMSXMXMXMAMAMSMXMXMXAAMAMSMMSMMMMXAXXMMMAMMMXSAMXAMXMMMAAXXXASAXMAAAXAMASXSMMMSSXSAMSXMM
XASAMXAMAAMAAAMAXMAXMAMXSSSSMMSMSAMAXAAMSSMMSSMMMSAMAMMASXXMMXMAMAASMAMMMMMAMXAXXAMASXSMMMXSMSXAXMAMXMASAAMMSMMSMMASMSMXSASXMASAMXXAASAMMMAX
SMSMSMAMSMMSMMMAMSMXSSSMAMMMMXMAMAMMSSMMAAAXXAAXASASAASAMAMASASMSXXAMXSSSXMAMMMMMSSXMAMSASAMSAMXSSXMAMAXMXSAAAXSXSMMAAAMSAMXMSXMASMMMXAMXAMM
AXXAXMXMAAXMMXMAMXSMAMAXMSAMXASXMSMXAMSSSSMMMXMMXMASMXMXAAMSSXSXXMMMSXAAAXSASXSASMMMMAMAXMASMXMXXMMSMMSSMXMMXAXMASXMXMSMMAMXXMAXAXXXMSMMXSXA
MMSMMMXXMXMMXAXXXAXMASAMXSAMXAMAMMMMMSAMXAXXAASXSMASMXXASMMXMMMMMSAAMMMMMMXASAAMSAAMSASMXSSMMASXMAAAXAAAMASMMSMMAMAMXAAAXMMSMSAMSSSXMAASAMMS
XAAAAXMSSMSSSMSAMXSXXMAMASASMXSAMAXAXMASXMMXSASAAMAMXMAMXMSMSAMXASMSMAXMASMMMMMMXMAXSXXAMXAASAXMAMSSSSMSMASXXAAMXSAMAMAMSMMAAMMXXAXASXMMASAM
MSSSMSAAAAAAAXAMXMAXXMSMASMMMAMAXAMSSSMMAAAMMAMXMMSXSASMAXAXSXXAXXMMXXSXAXSMASXAXAXASXSMSSSMMXXSSMXMAMXAMXSXSAXSAAAMXSAMAASMSMSAMMSMMMMSSMMA
XXAXAXXSMMMSMMMXSMSXSAAMAMASMMSMMSSMAMXSSMSSMAMMSAMAAAXMMMMXMSXSMXSASMSXXMMMAXMMMMMMMASAAAAMSXXAAMXMAMSSSMSAASMMXSXMASASMXMAMAXXMMAMAMXXAAAX
MMMMMMAXAAXAXMMAXAXMXAMMMSAMAAAAXMAXXMXXAAAXMASXMMSXMXMASXMAAMMMMAMASAXMXAMMMSAASAAAMAMMMMMSAMXSMMAXAMAMXAMSMAXXXMMMXMAMXMMXMXMXMAXSASMSMSMX
MASMSXSXXMMXMMMSSMSSMSXAXMAXMMMXMSAMXMXSMMMSSXSMMXMXMXSMMASMXSAASXMAMMMAXXAMXAXASMSXMASAAAXMXSMAXSSSMSAXMXMXSMMSAMAMMMXMSSSMSAAXXMASASAAXAMA
SASXSAXAASXMSAAAAAAXAMMMSSSXSMMSAMXSAMXAXXXMAXSMSASAMXSXSAXMASMXSMSASXSSSXSASAMXMMMMSXSMMMSAASAMXXAAASAMMSMAMXMXMSASASAAAAAASXMMMXAMXMXMMAAM
MMSMMAMSXSAAXMSSMMMMSMAMMAMXAAXMASASASMMSXSSMXSASMSAXASAMAAMAMMMSASASAAXMAMAMXXMSASMSXMAMSAMXSAXMMSMMMASMAMASASMXSASAMMXMSMMMAXXAASMMSASXSMX
MASAMAMXAMMMMMMXXAXAAMAXMAMSMMMMMXMXAMXXMMMAMMMAMAMMMASXMSMMSXSASMMAMMMXMAMAMXSXMASAXMMXMXASASMMAMAXXMAMXMSXSASAAMAMAMMSAMXXMMMMMMMAASASAMXM
MAXXMAMMXMMASMMSMSMMMXMMMMMSMXMASMSMMMSMMASMMAMAMAAAMXMAMXMMMAMASAMSMAXMSASMSASMMMMAMXXMASAMXXXAXXMSMMSSMXSMMAMMSMSMXMASMMMMMSASXAMMMSMSMXAX
MMSASMSMSASMMAAMXMASMMMAMXAXAASMXAXAAAAAXMSXSXSMSMSXSAMMMMMAMAMAMAXMMSAMXAXAMASXAMAXXXMXMASMXMMSSMMAXSMAMAMAMXMXXAMXSAXMASAAMXASMXSAMXMMXSMS
MSAMAAXAMASAXMMSASMMAASXMMSSSMSAMSSSMSMSMAMASAAXXAAMSMSAXAXASAMASXMAAMAMMMMSMMMXMXXMASAMXMMSXMAAAASMSMSAMXSAMAMMMMMAMAMXAXMMSMSMXMSMSAMAXAAA
MAMXMMMXMASAMMXSMSAMSMMASXMAXAMMMXAMMAAMXSMAMMSMMMMXXMSXSMSMSXSASMSMMSMASAAXAXSASAMMMSAMAMSAXMASMMMXXMSMSXSMSXMAXXMASASMMSSMSXMAAXXAXXMASMMM
MSXMAXMXMASMMSAMXSXMMXSAMAMMMMMMXMAMMMSMAMMXMXMAXXMXMXXMXXAMXAMASASAXXMASMMMAMSASASAAMMXAMAAMMXXAAMASXMMSXXMAASASASASXMAXXMAXAXSMSMMMASXSMAX
MMASMSMAMXSAAMXMAXAMMAMAMAMAAXAXAXSMSXMMXMSSMXSSMMSMMSAASMSXMXMAMASAMMSXMASXSMMMMAXMSMASMSMSSXAMSMMASAAASAMXSXMASAMASASXMMMSMMMXXXXXMASAMASX
ASAMAMXSMMSMSMAMXMSMMAXAMXSSSSSSMXMAXAXMXXAAXXXMAXAAXAMXMAXSAXAXSMMMMAXAMAMMXAXAMAMSAMXSAAXAMMSMXAMXSXMMSXMMMMMXMAMXMXAMXXAXAXMMSMSSMMMAMAMA
AMAMMMAXXAXAAXXMSAXASXMASAAAAXMAXAMAMSMSSMSMMSMXMSSSMXSXMAMAMMMXMAAXMXXMMASXSSMMMMMSASAMMMMMSAXASXMXMAXXXASAAAXASAMXSXSMSMMSXSSXMMAXAXSAMXXX
ASXMXMAXASMXMSXAMXXMASAAMMMMMXSMMXSXSAAAXXAAXASAAXAAMXSAMASMXAXXSMMSXXSASASMAMMXSMASMMMSAXXMXAMXMASAMAMSSMMSMSMMXAXXMAMAAAMMAXAAXMMSSMSXSXSM
AMXXAMASMXSMAMMXMMMSASMMMXSXMASAMASXSMMMSMSXSASMSMMMMAXMMASXSMSASAXMAMXAMASMAMSAXMASAAASMMMSMSXSXMMXMXMMAMAMXAASMMMAMAMXMSASXMSMMAMAXAXAXMAS
MXSMMSAAMAXMXMAAAAAMASMXXAMAMXMAMASASXMMSAAMMMMMAAASMMSXMASMMAAASXAMAMMMMXMMXMMXMAAXMMMSMXAXAMMMASXMASXSXMASMSMMASMXMMSAAXMMAMXMSXASMMMSMMAX
SAXMAMXMMXSASXMSSMXMAMXMMSSMMXXAMASXSAMAMMMSAXAXMSMSAMXMMXMAXXMXMMMXXSXMAXMASXSXSMMSAMXMXSSMMMASAMAXMSAMXSXSAASMAMMAXASMSSSSMMAASAMXAXMASMAS
MMSSMSMSMSAMXSXAMASMMMMXAAAAAXSMMXMASAMAXAXMASMSXXXMAMXAXSXSMSSXSAMSAMXAMXSASMMAAAAXMASAAXMAXSASMSXMXSAMXMASMMXMMAXAMXXAXAASXXXXSASXMMMXXMAS
MAAAXMXAXSMXAMMSMAAAAXMMMSSMMMXAAXMASXMASMSMAAMAMMSSSMMMMSAMAXMAMASMAMASXXMASAMSMMXSMAAMMSMAXMAXMXAAMSAMSMXMMSSMXAASXMASMMMMMSSMSAMMSAMMMXAS
MMSSMSSXMMXMMMAXMXSXMXXAAAXAXMSMMSMAMMMAXMAMXSMASMAAAAAXAMMMSMMSMMMXMXAXXAMAMXMAAXMXMMMAMAMXSMSMAMXSASAMXXMXMAAXSAMXASAXMXMSAAXXMASMSASXXMXX
SAAXMAMXXMAXASMMMAMAAASXSXSAXMAMAMMSSMMSMSAMSAMXSMMMSAMXSSMAXAAAAXAAMMSSSSMMSMXSXMAMXSSSXXSMSAMAMSAMXSXMMMAMMMSMASMSAMXXMAAMMMSXMAMASXSMMAXS
MASAMMSMMMASMAAAMASMMMMAAAAAXSAMAXAXAXAMXMMMXAMXSXMMMAMAMAMASMMSSMSSSXXMAMAMSXMAMAMAXMAMXAXAMXMAXXXSAXAXXASAAMAAMXMMASMMSXSASXXAMAMMSASAXMXA
XMMXXMAMSAAMXSSMMMSMMAMSMMMMMSAMXXSMMMXSAXAASXMAXXSASAMAXAMXSXAAXXAMAMMASMSMMMXAXSXSMMAMMSMMMXMXSMASMXSAASASMSXSXMSMAMMASXMAMMMXSXSXSASAMMSX
SXAXMSMAMXMSMMAXSAMXMAXMAXXMASAMSXMASAMXASAXMAMSMMSXSXMXASAMXMMSSMXXXAXXXAMXMAXXMXAAMMAMAMAASASAMMMMAAAMMXXAMXXMXAAMXMXAMAMMMAAMAXAAMAMXMASA
XMAXAAMSMSMSASAMMAXSXMASAMXMAMMAAASMMMMSASXSXMAMAMSXMASAMAASXMMAXXSMMSMMMSMMMSSXAMSMMSSMMSSMSASXXAXMMMSXXMMSAMXXAXMSMSMSSXMXSXSMMSMXMAMXMMSM
SSSMSXSXAMAMAMASMMMSAMXSMMMMXSSXMMMMAXAMAMAMAMASXMSASAMSASMMXXMAMXMMAAXAAXAXAAAMXMAXXAXAAXMAMMMMSMSMAAXMXXAAXASMMMXAAAAAMAMMMMXAASMXMMSMMAMM
MAAMMMMMAMAMMMXSAMXMAMMXMAAAMAMXSASXXMASAMXSXMXSXXXMMMXAMXMASMMSMMSASXSMMXAMSSXXSSMAMASMMSMXMAAXXXAXXXAXXXMMMMSASXSMSMSMSAMAAASMMSASXAAMSAMX
MMMMAAMAAMMMXSMMAMMSAMSASXMSAMXAMAXAMSXSXXXXXSAXMAXXSXSSMMMMSXAXAXMAXMSASMAMAMAXXAXMAMXAMAXSSSSSSSSXMSMSMMAXAAMMMAAMMXAMXASMSMMXMMAMMSAMSASX
SSSSXSMMSXSAASASMMMMASMASAAXMAMXMSXMMSAMXSMMAMMSMSAXMMSAAAAXMMASMMMXMMMAMSXMXSASXMMSMMSSMMMMAAAAMAAMXAMAAMXSMSSSMSMMSSXSXMMMMXMAAMAMAXMASAMM
AAAMMXAAAAMMMMAXXAXSMMMXMMMMMXMXSMAXAMAMAAAXAMXAAMMAAXSAMXMAMMMMXAXMAAMMXSMMXMAMXMAAAASAAAMMMMMMMMMMSASMSMAMXMAMMMSAXAAXMMMMSSMSSSMSMAXAMAMS
MMMMASMMMMMSXMXMSMMMSSSMXAAASAMMMSMMSXSMMSAMSSSMSASXXMMAMXSMXAAMSMSASXSSXSASAMAXMMSXSMMXSAMAXASMMMXAXAMMXMXXAMMMMASXSMSMSAAAAAMMAAXAXXMAMXMM
XAAMXSASXMAMAMXAAXAASMAMSSSMSASXAAMMXAXAMXAMAAXSXXSMAXMAXXMMSXXXAXAMXMXAXSMMXSSSMMXAMXSAXMMMXMXAAMMSSMSXMMMSMSAMMASAXAAAMSMMSSMMAMSASXMASMMS
SSXSASAMXMASAMMSMSMSXSXMAMXAXXMMMMSMMMMAMXMMMSMMXAMMAMMASMAAAMMSSSSMSASMMSXSAMMAMAMAMAMAXSASASXMMMXMAXAAXMAAAMMXMAXMMSMXMAXMMAMXAXAMXXSASAAA
MMMXXMMMMMMXAXAAXMXXXSMMXSMMMSSMXSAMAXXXMAMMXXMSMMMMMSXMAXAMMSAAXXXAMMAXAXXMAXXAMAMAMXMMMSAXASMXXMASXMSSMSSSSXMSMMMSAMXSMMSMSSMSMMSSMXMASMMM
AXAXSMSXAASXSMSXSAMXAMAXXMASXAAAMSASMSSMSXSMASAAAXXAAAAMAMXMAMMSMSMMMSMXMSSXXMSMSSMSMXASXMAMSMMMXSXSAMAXAXAAAAAAASAMASASAAXXAMMAMAAAAXMAMAAS
SMSSMAMMSXSAMAAAMMSMMMSMMMXMASMMMMAMAAMAMSMMAMXSSMSMSSSMSSSMAMXXMAXSASAMMAMMSMAAAXAAXSSMAMXMXAXMXMASAMASXMMMXXSMSMMSXMASMASMMMSAMMSMMMMMSSMM
XAXAMAMAMMMAMMMSSMXXAAXAASXMAXMXAMXMMMMAMXXMAMMXXAAAMAMXMAMXAMXMXAXMAMSAMASMASASAMMMMMAXMASMSSMXAAXSXMAMMMXXXMMXAMXSAMAMXXXAXASMSAMAXAXXAMAA
MMMMSXSXMAXXMMAMAMAMMXSXMXAMXMSSSSSMXASMSMMMXXAMMXMXMAMXMMMSMSAXMAXMXMASMAXXAXXMAAMMAXMAXAAAAMAMXSASAMSSMMSMXMSAMXASAMXSMSMSMMXMMASXMSAMXSXM
AAAXMMMXMXSAMMASMMSSSXSMSSSMSSXAAMAXSXSAMMSAMSMAXSSXSXMAMSXAMMXMMXXMMSMAMASMSMXMXMASMMXMXSSMMMSAAMASAMAAXAXXMASAXMAMSXMAAAXXMMSAMAMXSMXAMXMX
XSSSXSXAAASASMMXAMXAAAMAMAAAXXMMMMMMMAMXMAMXMAXXSAXMASMSMASMSSSSSMMSAMXSMAMAMXMMSAMSASMSAAAAAAXMMMAMXMMSMMXMXMMMSAMXXXXMMSXSAMSAMMSMAMSSMXAM
MXAMAXSXSMSAMMMMSSMXMMMAMSMMMSAAXAAAMMMAMAXXMXAXMMMAMMMAMXSMAXAAAAAMSMAMMSMMMSXAAMXMMMAMXXMMMSSXXMAMXMAMAMASAMAMAAMAMAXXAAAMAMMAMAAAMASAMSAM
AMAMXMMXMAMXMASAAAMAMXXXMAXMAXXASMSSSSSXSSSSSMSMSSSXXASAMSSMMSMSMMMSXMXSAXAAAXMXMXMSSMSMXSMSAMXXMXSSMMASAMAXASAMSAMXSSMMMMSMAXMAMSMMXMSAMXAM
MSAMXXXAMASMSMMMSMSASMSMSMSMASAMXAAAAXXXMAAXXXMAXAAMSASAXAXAMMXXMSMMAMMMXSAMXMXAMXAXXAAAXAXSAXSASAMMAMASAMMSASMMMAMMXMAXMAXMASMMMMSSSXMAMSMM
AMAMMMMXSMMAAXXMAMSASAAAAAAMASAMMXMMMMXMMMMMMXMAMMMMMASMMSXMMSXMMMSMAMAMAMMMMASMSSSXMSMSXMASXMXAMXSSSMASAMXAMXMASAMXASAMXSXMXXAXSXAXAAXAMAXS
SSSMMAXXXAMSMSMSSXMMMXSSMSMMAXAMXAXAMXMASXSMAASASAAXMXMXAMASAMASAMSSXSMSAAAAMMMAAAAMXMSMAMAXAMMSMXMAMMXSXMXAAXSMMAMSASAMSXXMMMMMSMMSMASXSSSX
MAMASMSMSMXMAXAAMAAMXXMAMXXMMSMSSSSMSAXSXMXMAMSASMSMSASXMMMMASAMXMXAMXASXSXSXXSMAXMAMMAXXMAXAXAAAASAMXMMASMMMMAXSAMMAMXMAMAMAASAMAXMXAXXAXXX
MAMAMAAAAXSMSMMMSSMMXXMAMMSMXAXMAMAASAMXMMMMAXMXMXMAXASAAMXMXMXSXMSAXMXMMMAMXMSXSASXMSASMMSSMMSSSMSASMXSAMXSAAMXMASMSMSMASXMXMMASXMMMSSMSMMA
SSXMMSMMMMSAAXAAMAMAASXMMMAMXSSMMMSMXXAXAMASMSMAMMMSMMMMXMMMSAMMMMSAMSMMAMAMMXMAXAAAMAXSAAXAMAMAAAMMMMAMXSASXSXMSXMAMASMMSXMSASXMMAASXAAAAXX
XAASAXXXXAMMMMMMXAMMXMAAASASMXAMSAXMAMXMXMAMMAXAMXAAMSAMXSAXMAMMAAMMMMASXMSSXAMSMMMMMMXSMMSMMSSSMMMAAMXMAMXMAMMAMAMXMMMAMSASAXAAXSSMSMMMASMM
MSMMAMMSMMSASASMSMSMMSMMMSASMMAMMMMMXSAAMMSSSXSXSMSSMMXSASMXXAMSSSMSSMAMXAASAXMXXXMSAMXXMXSAAAAMAXSSXXAXXXSAAMMXXAMAMASMMMXMMXSXXMAMMXSAMAAA
AMAMXMAAAMSASASXAXAAMAAAXMAMASAMXSAAAXXSXAAAMMXAXMAAAXMSASXSMSXMAMXAAMASMMMSSMMXMSMSASMASAMXMMSMSMAMMSXSAXSMMSSSSMSXSAMXSSSXXXMMMSSXMAMAMXSX
MMAMMMMXSASAMXMXSSMSSSSMMSAAAAASASMSXSAXMMMSMAMMMMSSMMAMSMAMAMSMAMMXXMXXMAMXAXXAMAMXMMAXMMSXXXXAAMAMMAMXMAXXAAAMAXAMMMMMAAASAMXAAAXXMMSMMXXM
MSAMASXAAAMSMXXAXAMAAMMAMXMMSMXMXXAAASASMSAAASXMXAAAXAMSAMXMAMAXMSMSASXASXSSMMSXMAXMMXXSXAAMMMMSMSSMMASXMSMSMSMSSMMSASAMXMMSMSMMMSSMXMAASASA
MSMSASAMMMMMMMMSSMMMSMSXSXXAMMXMXMMMMMAMAMSSMMAMMMSMMSMSMSAMMMMMSAASAMMMMMAAMMAXSSSMSMAMXMASAAXMMXMASAMXMAAXXMAXMAASASXSASXXMSASAMMMASMSMASX
XSMMASMXMAXAAAMXAXAXXMXAAXMASAMXAXAXXMSMSMAMAMSMMAMAXXAMAXXSAAXXMMMMSMAASXSMMMMXXAAAAMAMAMAMXSMMMASMMASXSMMMSMSMMMMXAMAXAMAXASAMASASXSMAMMMM
MMASAMXSSMSSSSSMSMMMXMMAMXXAXXMMXXASXXAAXMASMSMAMASXMMMMMMXMXXSAXSXMXSXSXMAXXXXXSSMMMSASMMXSAMAASASXSAMXSAMMMAXAMXSMMMXMAAMMMMXMXMASAMMMMSMA
MSAMXSXXAAAXMAMMXAAMXSAMXMXMSMSMSXMMMSMSSMMXXAXXMASXSAASASMAASMXMAMMASXXXSSMMMMMAXXXXSASAASXMSSMASXXMASAMMMAMAMAXSMSXAAXXXAAXSAMMXAMXMMSAAMS
AMXSMXMSXMXMSASMSSMSAASXMAXXAAAAMXSAMMMAAAXSSMSMXMXAASASAMMMMAMMSSMMASAMMXAMAAAMMSMMXMXMMMSAXXMASAXXSAMMSSXSXMSMMXMXSSSSSMMMXXASXMXSXMAMSSSX
MMAXMAMAXSAAAAAAAXAXMMAMASXSMXMXMXXAMSMMSSMAAXXMASMMMMMMMMAMXMAAAAAMAMAAAMMSSXSMXAMSMSMXSASXMXXXMASXMASMMAAXSMAMAAXAMXAAMAMSSSMMASXAMMXMXMAX
XXMASMMSAMMXMXMMMMMXXXXAXAXASXSSMXSAMSAXAXASXMASAMAMXXXAAMXMAXMASXMMSSMXSSXAAXXXSMSAAAASAXXAMMMSAMXMSAMXMMMMAMXMSXMASMMMMSMMAAASAMMXMSMSSMXS
SMSAXMAMXXXAXMXASASMMMMSMMSMMXAAAASAMSXMMXMMASAMSSXMSSMMSXMSASXMMXMAXAASMMMMSMMAXXSMXMSAMXMAMAXMAMAMXMSAXAASMMSXMAASMXSXXMXSMMXMASAAXXASAMMA
MAMXSMXMAXSXSASASASAMAAXMAAXXMMMMMXMMSMAXAMSMMASMSAAAMAAXAMMMMAAXAMMSAMMAXMXAAMMMMMSMSXAXMMMMSMSAMXXAXSMSSMSAAMASXMAAAXMMSAMXSXSXMMXSXMMAMAM
MMMMMMSMMMMAXXMXMXMASMSMMSSSMSSSMMSSMMAMAXMAASMMASMMMSMMSMMAAXMMMSMAMMMMXMSSSSMXMAAASMXSASAMXXASXXXXMXMMAXAXMASASMSSMMSXAMXSAMMMSMASMXSSSMSX
AXASAAXSAAMMMXMASASMAAXXAMAMXAAAAXAAAMMMAMSSMMMMAMXSXSAMAMSSMSAMAXMXMAXXSAMAMXAASMSXSMAXAXASAMXMASMMSASXXMSMXXMASAMXAMXMSMAMAMAXAXMAXAMAAAXA
XSMSMSMXSSSSXXSASXSAMAXMMXMSSMSMMMSSMSAMAMAXMAMMMSAMXSAXXXAMXAAMSMXAMSSMMXXAMXXAMAXMSMMSSMAMMMMMAMAAXAMXXXMMSMMMMAMSXMASAMASASMSMXXMMSMSMMAS
XXASMMMMAMAMSAMXSXSAXASXXSAAXMXXXAXAASMSMSSMSASAAMMMAXXMSMMSSMMMXAMXMMAMXSXMASMMMAXAXMXAAXSMSMSMAMMMMSMXMASAXMAASAMXMXMSASMXMAAXXMSAMXAAXMAM
MMMMMAAMAMAMASXXMASXMASAAMMMSMMXMMSMMMASAMAASMSMSSMMSSMAXAAAAAAMSSMMMSAMAMXMASASMSMMMMMSXMMAAXXXASAXXXAXXSMAMSSXSMMMSAMSXMASMMMSXXXAAMSMMMAS
MAMAMXXMXMSSMMSAMAMXSXMMMMMXMASXMXSXSMXMAMMMMAXMMMAAMAXMSMMXMMMXAAAXASXMAMAXAMAMAAMXAXMMMSMSMSASXSXSMSXSMMMSMAMXSASASAMXMMAMAAAAMSMMMMXAASAS
SASASMSMSMMAMAMMMSAAMXMAXAMSSXMXSAMXAMXAAMMXMSMMASMMSSMXXMSSSSSMMSSMMXXSMSMSXMXMAMMSMMMXAAAAXSASASMSASMMAAAXMAMXSAMMMMMAMMAXXXMASAAXSXXSMSAX
SASMSMSAAASAMMSXSAMXMASXSXSXMASAMASXSXSSMMXAXXAXASMMXMSAMXAAXAAMXMAAXMMMMAXXMSSXAXMMSMMMSSXMXMAMAMAMSMASMMSMSASAMAMASMSAMASMSSSSSXSMXMAXAMXM
MXMAXAMSMMMMXSAXAXSAAXXAAMSASAMXSAMXMAXAAMSXMMSMASXXAMMMXMASMSMMAXXMMMAAXXMXAXMAMSAAAMAMMXMSXMSMXMSMXMXSXAMASXMAMAMAXAAAXXMAAXXAMAXXAMAMAMXA
MAMMMMMAXMASMMMSMMSMSSMMMMSAMASMMMSASXSSMMSASAMMAMXSASAXXAAXAMXSASXMSSSMSASMSAMMMSMMXSASAAASAMXXXMMAMXASMXMMSASMMSSSMSMSMMSMMMMMMAMSMSSSMSXS
SXSAAXSASXXSASAMXMSAAMAAMMMXMAXMAMSAAAXMAXSAMASMASAMASMSXXMSAMXMMSAAMAAMSXXAMMMAAMASMSASMMMSAMASXSMASMMSAXSASXMASAAMAMXAAXMAXMAMMAMXAAAAASAM
SASMSMMSAMXSAMXSMXMMMSSMSXSSMSSSXMMXMAMMMMMAMAMXXSAMXMAXXXXSAMXSXSMMMMMMXXMSMSSMSSXMMMAMXMMSAMXXAXSMMXXMMMMASXSSMMSMSMSSSMSMMASXSMSMMMSMMMSM"""
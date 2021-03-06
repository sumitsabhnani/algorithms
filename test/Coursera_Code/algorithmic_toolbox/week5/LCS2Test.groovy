package Coursera_Code.algorithmic_toolbox.week5

import spock.lang.Specification
import spock.lang.Unroll

class LCS2Test extends Specification {

    @Unroll
    def 'should find longest common sequence'() {
        expect:
        LCS2.lcs2(a as int[], b as int[]) == length

        where:
        a               | b               | length
        [2, 7, 5]       | [2, 5]          | 2
        [7]             | [1, 2, 3, 4]    | 0
        [2]             | [2, 2]          | 1
        [2, 7, 8, 3]    | [5, 2, 8, 7]    | 2
        [1, 2, 4, 3, 2] | [2]             | 1
        [1, 2, 4, 3, 2] | [2, 2]          | 2
        [1, 2, 4, 2, 2] | [2, 2]          | 2
        [1, 1, 4, 2, 2] | [1, 2]          | 2
        [1, 1, 1, 2, 2] | [1, 1, 2]       | 3
        [2, 3, 1, 2, 3] | [1, 2, 3]       | 3
        [2, 7, 7, 7, 5] | [2, 7, 7, 5]    | 4
        [3, 3, 1]       | [1, 3, 3]       | 2
        [2, 7, 5, 2]    | [2, 5]          | 2
        [1, 1, 1, 1, 2] | [2, 2, 2, 2, 1] | 1
        [1, 1, 2, 1, 1] | [2, 2, 2, 2, 1] | 2
    }
}

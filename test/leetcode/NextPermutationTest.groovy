package leetcode

import spock.lang.Specification
import spock.lang.Unroll

class NextPermutationTest extends Specification {

    def next = new NextPermutation()

    @Unroll
    def 'should return next permutation'() {
        when:
        def nextPermutation = next.nextPermutation(nums.toArray() as int[])

        then:
        nextPermutation == expected

        where:
        nums         | expected
        [4, 1, 2, 4] | [4, 1, 4, 2]
        [5, 6, 5, 4] | [6, 4, 5, 5]
    }
}

package Coursera_Code.algorithmic_toolbox.week3

import spock.lang.Specification
import spock.lang.Unroll

class LargestNumberTest extends Specification {

    @Unroll
    def 'should return #result for #input'() {
        expect:
        LargestNumber.largestNumber(input.split()) == result

        where:
        input       | result
        '23 232'    | '23232'
        '96 907'    | '96907'
        '20 202'    | '20220'
        '10 100'    | '10100'
        '10 101'    | '10110'
        '23 39 92'  | '923923'
        '9 4 6 1 9' | '99641'
        '21 2'      | '221'
    }
}

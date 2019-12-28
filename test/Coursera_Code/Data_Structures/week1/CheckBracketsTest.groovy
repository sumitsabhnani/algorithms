package Coursera_Code.Data_Structures.week1

import spock.lang.Specification
import spock.lang.Unroll

class CheckBracketsTest extends Specification {

    @Unroll
    def 'check brackets'() {
        expect:
        CheckBrackets.checkBrackets(input) == output

        where:
        input         | output
        '{}[]'        | 'Success'
        '[()]'        | 'Success'
        'foo(bar);'   | 'Success'
        '{{(())}}'    | 'Success'
        '{'           | '1'
        '}[]'         | '1'
        '{[}'         | '3'
        'foo(bar[i);' | '10'
    }
}

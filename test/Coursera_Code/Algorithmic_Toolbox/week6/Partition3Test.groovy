package Coursera_Code.Algorithmic_Toolbox.week6


import spock.lang.Specification
import spock.lang.Unroll

class Partition3Test extends Specification {

    @Unroll
    def 'should correctly partition'() {
        expect:
        Partition3.partition3(A as int[]) == output

        where:
        A                                           | output
        [3, 3, 3, 3]                                | 0
        [1, 1, 1]                                   | 1
        [40]                                        | 0
        [17, 59, 34, 57, 17, 23, 67, 1, 18, 2, 59]  | 1
        [1, 2, 3, 4, 5, 5, 7, 7, 8, 10, 12, 19, 25] | 1
        [1, 2, 3, 4]                                | 0
    }
}

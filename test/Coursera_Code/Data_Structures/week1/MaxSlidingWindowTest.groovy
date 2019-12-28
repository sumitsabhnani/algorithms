package Coursera_Code.Data_Structures.week1

import spock.lang.Specification

class MaxSlidingWindowTest extends Specification {

    def 'should work with normal input'() {
        expect:
        MaxSlidingWindow.maxSlidingWindow(8, [2, 7, 3, 1, 5, 2, 6, 2] as int[], 4) == [7, 7, 5, 6, 6]
    }

    def 'should work with extra large input'() {
        given:
        def arr = [0]*100000 as int[]

        when:
        def startTime= System.currentTimeMillis()
        def result = MaxSlidingWindow.maxSlidingWindow(100000, arr, 1000)
        print('TIME::' + (System.currentTimeMillis() - startTime))

        then:
        result.size() == 100
    }
}

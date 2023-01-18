package Josh

import org.junit.jupiter.api.Test
import java.util.PriorityQueue

class TopKFrequentElem {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        //init two arrays, one checker, one output
        //loop through the array
        //    inside loop set conditions to map our inits
        //    if num exists increase num by one
        // else
        // record key value pair
        // if num value in map is greater than or equal to k
        // push k into output array
        // return output

        //Learned how to  traverse through maps
        //Learned how to use Get or Default to check for nullable values
        //Learned (key, value) in loop
/*
        val checkerMap = mutableMapOf<Int, Int>()
        val kArray = mutableListOf<Int>()

        for(i in 0..nums.size -1) {
            checkerMap[nums[i]] = checkerMap.getOrDefault(nums[i], 0) + 1

        }
        for((key, value) in checkerMap){
            if (value >= k) {
                kArray.add(key)
            }
        }
        return kArray.toIntArray()
*/
//            val checkerMap = mutableMapOf<Int, Int>()
            val map = mutableMapOf<Int, Int>()

            nums.forEach { num ->
                map[num] = map.getOrDefault(num, 0) + 1
            }
//            FIFO
            val pq = PriorityQueue<Int>( compareBy{ map[it] } )

            for (key in map.keys){
                pq.offer(key)
                if(pq.size > k) pq.poll()
            }

            val topK = IntArray(k)
            for (i in 0 until k) topK[i] = pq.poll()
            return topK
    }

    @Test
    internal fun testArr1(){
        val nums = intArrayOf(1,1,1,2,2,3)
        val k = 2
        val underTest = TopKFrequentElem()
        val expected = intArrayOf(1,2)
        expected.contentEquals(underTest.topKFrequent(nums, k))
    }
    @Test
    internal fun testArr2(){
        val nums = intArrayOf(1)
        val k = 1
        val underTest = TopKFrequentElem()
        val expected = intArrayOf(1)
        expected.contentEquals(underTest.topKFrequent(nums, k))
    }
}
import java.util.PriorityQueue;

/**
 * Leetcode 215. Kth Largest Element in an Array
 * Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
//------------------------------------ Solution 1 -----------------------------------
public class FindKthLargest {
    /**
     * Using min heap - In min heap minimum element is at the root and underneath all elements
     * are larger. If we limit the size of the Priority Queue to k and whenever we exceed that we poll
     * value to remove which is the smallest at the root. doing this for entire list will give us the kth largest
     * value at the root and (k-1) elements which are larger than result will be underneath
     * TC: O(nlogk) SC: O(k) k is max size of the PQ
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num: nums) {
            pq.add(num); //TC O(logk)

            if (pq.size() > k) {
                pq.poll(); //TC O(logk)
            }
        }
        return pq.poll();
    }

}

//------------------------------------ Solution 2 -----------------------------------
class FindKthLargest2 {
    /**
     * Using max heap - If we want to find 9th largest number in total 10 elements, the same problem
     * can be viewed as to find 2nd (n - k + 1) smallest number in total 10 elements. Apply the same
     * logic as min heap and at the end we will have (n -k + 1)th smallest element which is kth largest element
     *
     * TC: O(nlog(n-k)) SC: O(n - k)
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int num: nums) {
            pq.add(num); //TC O(log(n-k))

            if (pq.size() > (nums.length - k + 1)) {
                pq.poll(); //TC O(log(n-k))
            }
        }
        return pq.poll();
    }
}
/*
Date: 12/11/2021
Author: Saurabh Tripathi
Problem pattern : Sliding Window.

Problem Statement:
Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.

Input: [2, 1, 5, 1, 3, 2], k=3 
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].

Input: [2, 3, 4, 1, 5], k=2 
Output: 7
Explanation: Subarray with maximum sum is [3, 4].

*/


class MaxSubArrayOfSizeK
{
	public static int findMaxSubArray(int[] arr, int k)
	{

		int n = arr.length;
		if (arr==null || n==0) {
			return 0;
		}
		int sum = 0, maxSum = 0, windowStart=0;
		for (int windowEnd = 0;windowEnd<n ;windowEnd++ ) {
			sum += arr[windowEnd]; //Add element to the sum 

			if (windowEnd-windowStart+1 > k) {
				// If window size is greater than k then shift start of window and subtract its value from the sum
				sum -= arr[windowStart];
				windowStart++;				
			}
			//select the maximum of current sum and maxSum
			maxSum = Math.max(maxSum,sum);

		}
		return maxSum;
	}


	public static void main(String[] args) {
		
		int[] arr1 = {2, 1, 5, 1, 3, 2};
		int[] arr2 = {2, 3, 4, 1, 5};
		System.out.println("{2, 1, 5, 1, 3, 2},3  " + findMaxSubArray(arr1,3)); // O/P-9
		System.out.println("{2, 3, 4, 1, 5},2  " + findMaxSubArray(arr2,2)); // O/P-7
	}
}


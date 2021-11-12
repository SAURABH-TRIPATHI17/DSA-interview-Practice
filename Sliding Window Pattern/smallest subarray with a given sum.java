/*
Date: 12/11/2021
Author: Saurabh Tripathi
Problem pattern : Sliding Window.

Problem Statement:
Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.

Input: [2, 1, 5, 2, 3, 2], S=7 
Output: 2
Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].

Input: [2, 1, 5, 2, 8], S=7 
Output: 1
Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].

Input: [3, 4, 1, 1, 6], S=8 
Output: 3
Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].

*/

class MinSizeSubArraySum
{
	public static int findMinSubArray(int[] arr, int s)
	{
		int windowStart=0,sum=0,count = Integer.MAX_VALUE, minCount = 0;
		for (int windowEnd = 0; windowEnd<arr.length ; windowEnd++ ) {
			sum += arr[windowEnd]; //Add element to sum

			while(sum>=s)
			{
				count = Math.min(count,windowEnd-windowStart+1); // If sum is greater than or equal to "s" and windowSize is smaller than stored then update count;
				sum -= arr[windowStart];
				windowStart++;
			}
		}
		//check if count is equal to Integer.MAX_VALUE then return 0 else return the count
		return minCount = count==Integer.MAX_VALUE?0 : count;
	}


	public static void main(String[] args) {
	
		int[] arr1 = {2, 1, 5, 2, 3, 2};
		int[] arr2 = {2, 1, 5, 2, 8};
		int[] arr3 = {3, 4, 1, 1, 6};
		System.out.println("{2, 1, 5, 2, 3, 2},7  " + findMinSubArray(arr1,7)); // O/P-2

		System.out.println("{2, 1, 5, 2, 8},7  " + findMinSubArray(arr2,7)); // O/P-1

		System.out.println("{3, 4, 1, 1, 6},8  " + findMinSubArray(arr3,8)); // O/P-3
	}
}
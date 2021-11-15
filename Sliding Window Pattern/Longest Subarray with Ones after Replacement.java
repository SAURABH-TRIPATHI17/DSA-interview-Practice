/*
Date: 15/11/2021
Author: Saurabh Tripathi
Problem pattern : Sliding Window.

Problem Statement:
Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.

Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
Output: 6
Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.

Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
Output: 9
Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.

*/

import java.util.*;

class ReplacingOnes
{
	public static int findLength(int[] arr, int k)
	{
		int windowStart = 0, length = 0, maxOnes = 0;


		for (int windowEnd = 0; windowEnd < arr.length ; windowEnd++) {
			if (arr[windowEnd]==1) {
				maxOnes++;// To store the count of ones in our current substring
			}
			
				if (windowEnd - windowStart + 1 - maxOnes > k ) {//If more 0 are there in our substring than allowed, then we will shrink the window.
					if (arr[windowStart]==1) {
						maxOnes--;
					}
					windowStart++;
				}
			
			length = Math.max(length,windowEnd-windowStart+1);
		}
		return length;
	}

	public static void main(String[] args) {
		int[] n1 = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
		int[] n2 = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
		System.out.println(findLength(n1,2));
		System.out.println(findLength(n2,3));
	}

}

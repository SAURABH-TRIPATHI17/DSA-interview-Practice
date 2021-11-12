/*
Date: 12/11/2021
Author: Saurabh Tripathi
Problem pattern : Sliding Window.

Problem Statement:
Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.

You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.

Write a function to return the maximum number of fruits in both the baskets.

Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']

Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
Output: 5
Explanation: We can put 3 'B' in one basket and two 'C' in the other basket. 
This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']

*/

import java.util.*;

class MaxFruitCountOf2Types
{
	public static int findLength(char[] arr)
	{
		int windowStart=0,maxLength=0;
		HashMap<Character,Integer> fruitsInBasket = new HashMap<>(); //HashMap to store the frequency of fruits
		for (int windowEnd = 0; windowEnd<arr.length ; windowEnd++) {
			fruitsInBasket.put(arr[windowEnd],fruitsInBasket.getOrDefault(arr[windowEnd],0)+1);// add fruit in basket if not present or update the frequency

			while (fruitsInBasket.size()>2) { // if fruitsInBasket is greater than 2 then shrink the window until the basket size is equal to 2
				fruitsInBasket.put(arr[windowStart],fruitsInBasket.get(arr[windowStart])-1);
				if (fruitsInBasket.get(arr[windowStart])==0) {
					fruitsInBasket.remove(arr[windowStart]);
				}
				windowStart++;
			}
			maxLength = Math.max(maxLength,windowEnd-windowStart+1);//store the max length we got so far

		}
		return maxLength;
	}

	public static void main(String[] args) {
		char[] fruits1 = {'A', 'B', 'C', 'B','B', 'C'};
		char[] fruits2 = {'A', 'B', 'C', 'A', 'C'};
		System.out.println(findLength(fruits1));
		System.out.println(findLength(fruits2));
	}
}
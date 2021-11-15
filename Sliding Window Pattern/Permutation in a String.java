/*
Date: 15/11/2021
Author: Saurabh Tripathi
Problem pattern : Sliding Window.

Problem Statement:
Given a string and a pattern, find out if the string contains any permutation of the pattern.

Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.

Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.

Input: String="bcdxabcdy", Pattern="bcdyabcdx"
Output: true
Explanation: Both the string and the pattern are a permutation of each other.

Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.

*/

import java.util.*;

class StringPermutation
{
	public static boolean findPermutation(String str, String pattern)
	{
		int k = pattern.length();
		int windowStart = 0;
		boolean found = false;
		HashMap<Character,Integer> patternMap = new HashMap<>();
		HashMap<Character,Integer> stringMap = new HashMap<>();
		/* 
		We created two hashmaps to store the frequency of letters in pattern string and in our
		current substring. If the contents of both the maps are equal for any substring of 
		length of pattern then we will update the found as true and break the loop.
		*/
		char rightChar,leftChar;
		for (int i = 0; i<k ;i++ ) {
			rightChar = pattern.charAt(i);
			patternMap.put(rightChar,patternMap.getOrDefault(rightChar,0)+1);
		}

		for (int windowEnd = 0; windowEnd < str.length() ; windowEnd++ ) {
			
			rightChar = str.charAt(windowEnd);
			stringMap.put(rightChar,stringMap.getOrDefault(rightChar,0)+1);

			if (windowEnd - windowStart + 1 > k ) {//If substring length is greater than the pattern length then we will shrink the substring
				leftChar = str.charAt(windowStart);
				stringMap.put(leftChar,stringMap.get(leftChar)-1);//update the frequency of starting letter of the of the substring as it is excluded now.
				if (stringMap.get(leftChar)==0) {//If character frequency is 0 then we will remove it from our hashmap
					stringMap.remove(leftChar);
				}

				windowStart++;
			}
			
			if (stringMap.equals(patternMap)) {
				
				found = true;
				break;
			}

		}
		return found;
	}

	public static void main(String[] args) {
		System.out.println(findPermutation("oidbcaf","abc"));
		System.out.println(findPermutation("odicf","dc"));
		System.out.println(findPermutation("bcdxabcdy","bcdyabcdx"));
		System.out.println(findPermutation("aaacb","abc"));
	}
}

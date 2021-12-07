/*
Date: 15/11/2021
Author: Saurabh Tripathi
Problem pattern : Sliding Window.

Problem Statement:
Given a string and a pattern, find the smallest substring in the given string which has all the characters of the given pattern

Input: String="aabdec", Pattern="abc"
Output: "abdec"
Explanation: The smallest substring having all characters of the pattern is "abdec"

Input: String="abdabca", Pattern="abc"
Output: "abc"
Explanation: The smallest substring having all characters of the pattern is "abc".

Input: String="adcad", Pattern="abc"
Output: ""
Explanation: No substring in the given string has all characters of the pattern.

*/

import java.util.*;

class MinimumWindowSubstring
{
	public static String findSubstring(String str, String pattern)
	{
		int leftIndex=0,rightIndex=0, windowStart =0,length = Integer.MAX_VALUEm;
		HashMap<Character,Integer> patternMap = new HashMapM<>();
		for(char ch:pattern.toCharArray())
			patternMap.put(ch,patternMap.getOrDefault(ch,0)+1);
		char leftChar,rightChar;
		int matched = 0;
		int k = patternMap.size();
		for (int windowEnd = 0; windowEnd < str.length() ; windowEnd++) {
			rightChar = str.charAt(windowEnd);
			if (patternMap.containsKey(rightChar)) {
				patternMap.put(rightChar,patternMap.get(rightChar)-1);
				if (patternMap.get(rightChar)==0) {
					matched++;
				}
			}

			if (windowEnd - windowStart + 1 > k) {
				leftChar = str.charAt(windowStart++);
				if (patternMap.containsKey(leftChar)) {
					patternMap.put(leftChar,patternMap.get(leftChar)+1);
				}
				if (patternMap.get(leftChar)==0) {
					matched--;
				}
			}

			if (patternMap.size()==k) {
				if (length<(windowEnd - windowStart +1 )) {
					leftIndex = windowStart;
					rightIndex = windowEnd;
				}
				length = Math.min(length,windowEnd - windowStart + 1 );
			}

		}
		return str.substring(leftIndex,rightIndex+1);
	}

	public static void main(String[] args) {
		System.out.println(findSubstring("aabdec","abc"));
	}
}

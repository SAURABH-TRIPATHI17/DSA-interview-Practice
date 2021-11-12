/*
Date: 12/11/2021
Author: Saurabh Tripathi
Problem pattern : Sliding Window.

Problem Statement:
Given a string, find the length of the longest substring which has no repeating characters.

Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".

Input: String="abbbb"
Output: 2
Explanation: The longest substring without any repeating characters is "ab".

Input: String="abccde"
Output: 3
Explanation: Longest substrings without any repeating characters are "abc" & "cde".

*/
import java.util.*;

class NoRepeatingSubstring
{
	public static int findLength(String str)
	{
		int windowStart=0,length = 0;
		HashMap<Character,Integer> frequencyMap = new HashMap<>();//used this hashmap to check if character already in substring and to store the last index of the character
		char rightChar,leftChar;
		for (int windowEnd = 0; windowEnd<str.length() ;windowEnd++ ) {
			
			rightChar = str.charAt(windowEnd);
			
			if (frequencyMap.containsKey(rightChar)) {//if character already in hashmap then it is reapeating
				
				windowStart = Math.max(windowStart,frequencyMap.get(rightChar)+1);//check if our start is ahead of the index of char then we can ignore it else we will set our start to the nextIndex of the repeating character.
				
			}
			frequencyMap.put(rightChar,windowEnd);
			length = Math.max(length,windowEnd - windowStart +1 );//storing max length
		}
		return length;
	}

	public static void main(String[] args) {
		
		System.out.println(findLength("aabccbb"));
		System.out.println(findLength("abbb"));
		System.out.println(findLength("abccde"));
		
	}
}

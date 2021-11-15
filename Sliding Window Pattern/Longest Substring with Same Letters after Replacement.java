/*
Date: 15/11/2021
Author: Saurabh Tripathi
Problem pattern : Sliding Window.

Problem Statement:
Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.

Input: String="aabccbb", k=2
Output: 5
Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".

Input: String="abbcb", k=1
Output: 4
Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".

Input: String="abccde", k=1
Output: 3
Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".

*/

import java.util.*;

class CharacterReplacement
{
	public static int findLength(String str, int k)
	{
		int windowStart=0,length=0,maxRepeatChar=0;
		HashMap<Character,Integer> frequencyMap = new HashMap<>();
		char rightChar,leftChar;

		for (int windowEnd = 0; windowEnd < str.length() ;windowEnd++ ) {
			rightChar = str.charAt(windowEnd);
			frequencyMap.put(rightChar,frequencyMap.getOrDefault(rightChar,0)+1);
			maxRepeatChar = Math.max(maxRepeatChar,frequencyMap.get(rightChar));
			//In the above variable we will store the count of character with max frequency in our substring

			if (windowEnd - windowStart + 1 - maxRepeatChar > k) {//If there are more distinct varaibles than k in our substring we will shift the window
				leftChar = str.charAt(windowStart);
				frequencyMap.put(leftChar,frequencyMap.get(leftChar)-1);
				windowStart++;
			}


			length = Math.max(length,windowEnd-windowStart+1);
		}

		return length;
	}

	public static void main(String[] args) {
		System.out.println(findLength("aabccbb",2));// O/P - 5
		System.out.println(findLength("abbcb",1));// O/P - 4
		System.out.println(findLength("abccde",1));// O/P - 3
	}
}
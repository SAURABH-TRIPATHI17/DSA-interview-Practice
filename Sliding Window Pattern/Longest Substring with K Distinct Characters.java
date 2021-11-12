/*
Date: 12/11/2021
Author: Saurabh Tripathi
Problem pattern : Sliding Window.

Problem Statement:
Given a string, find the length of the longest substring in it with no more than K distinct characters.

Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".

Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".

Input: String="cbbebi", K=3
Output: 5
Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".

*/


import java.util.*;

class LongestSubstringKDistinct
{
	public static int findLength(String str,int k)
	{
		int windowStart=0,maxLength=0;
		HashMap<Character,Integer> frequencyMap = new HashMap<>(); // Store frequency of charecters in substring window
		Character leftChar, rightChar;
		for (int windowEnd = 0 ; windowEnd < str.length() ;windowEnd++ ) {
			rightChar = str.charAt(windowEnd);
			frequencyMap.put(rightChar, frequencyMap.getOrDefault(rightChar,0)+1);//add new charecter in hashmapfrequency if not present else update charecter frequency in hashmapfrequency

			while(frequencyMap.size()>k)//if frequencyMap is greater than size k then shrink the window until it is equal to k
			{
				leftChar = str.charAt(windowStart);
				frequencyMap.put(leftChar,frequencyMap.get(leftChar)-1); 
				if(frequencyMap.get(leftChar)==0)// if character frequency is 0 then it is not present in the substring so remove it from the mapfrequency
					frequencyMap.remove(leftChar);
				windowStart++;
			}
			maxLength = Math.max(maxLength,windowEnd-windowStart +1);

		}
		return maxLength;
	}

	public static void main(String[] args) {
		
		System.out.println(findLength("araaci",2));
		System.out.println(findLength("araaci",1));
		System.out.println(findLength("cbbebi",3));
		
	}

}
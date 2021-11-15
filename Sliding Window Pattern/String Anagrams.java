/*
Date: 15/11/2021
Author: Saurabh Tripathi
Problem pattern : Sliding Window.

Problem Statement:
Given a string and a pattern, find all anagrams of the pattern in the given string

Input: String="ppqp", Pattern="pq"
Output: [1, 2]
Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".

Input: String="abbcabc", Pattern="abc"
Output: [2, 3, 4]
Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".

*/

import java.util.*;

class StringAnagrams
{
	public static List<Integer> findStringAnagrams(String str, String pattern)
	{
		List<Integer> indices = new ArrayList<>();
		HashMap<Character,Integer> patternMap = new HashMap<>();
		int windowStart=0,matched=0;
		char rightChar,leftChar;
		int k = pattern.length();
		for(char ch: pattern.toCharArray())
			patternMap.put(ch,patternMap.getOrDefault(ch,0)+1);
		
		for (int windowEnd = 0; windowEnd < str.length() ; windowEnd++ ) {
			rightChar =  str.charAt(windowEnd);
			if (patternMap.containsKey(rightChar)) {
				patternMap.put(rightChar,patternMap.get(rightChar)-1);
			}
			if (patternMap.get(rightChar)==0) {
				matched++;
			}
			
			
			if (windowEnd - windowStart + 1 > k ) {
				leftChar = str.charAt(windowStart++);
				if (patternMap.containsKey(leftChar)) {
					if (patternMap.get(leftChar)==0) {
						matched--;
					}
					patternMap.put(leftChar,patternMap.get(leftChar)+1);
					
				}
					
				}
			if (matched == patternMap.size()) {
				indices.add(windowStart);
			}
			
			}
			
			return indices;
		}


		
	

	public static void main(String[] args) {
		System.out.println(findStringAnagrams("ppqp","pq"));
		System.out.println(findStringAnagrams("abbcabc","abc"));
	}
}
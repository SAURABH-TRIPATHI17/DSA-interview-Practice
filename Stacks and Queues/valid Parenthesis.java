/*
Date: 07/12/2021
Author: Saurabh Tripathi
Problem pattern : Stacks and Queues

Problem Statement:
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

sample 1:
Input: s = "()[]{}"
Output: true

sample 2:
Input: s = "([)]"
Output: false
*/
class Solution {
    public boolean isValid(String s) {
        
        Stack<Character>
            st = new Stack();
        
        for (int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            
            switch(ch)
            {
                case '}':
                    if(!st.empty()  && st.peek() == '{')
                {
                    st.pop();
                }
                    else
                    {
                        return false;
                    }
                    break; 
                    
                case ')':
                    if(!st.empty()  && st.peek() == '(')
                {
                    st.pop();
                }
                    else
                    {
                        return false;
                    }
                    break; 
                case ']': if(!st.empty()  && st.peek() == '[')
                {
                    st.pop();
                }
                    else
                    {
                        return false;
                    }
                    break; 
                default: st.push(ch);
            }
        }
         return st.isEmpty();
    }
}
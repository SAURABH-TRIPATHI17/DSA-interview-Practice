/*
Date: 07/12/2021
Author: Saurabh Tripathi
Problem pattern : Stacks and Queues

Problem Statement:
A simple implementation of Stack using Array in Java

*/
import java.util.*;
class MyStack
{
int[] stack; 
int size,top,maxSize; //size to store current size of Stack, maxSize is the maximum size of stack possible
MyStack()
{
size=0;
top=-1;
maxSize=5;
stack = new int[maxSize];
Arrays.fill(stack,-1);//fill stack -1 to represent empty elements
}

public int size()
{
return size;
}

public void push(int x)
{
if(size()==maxSize)//If size is full then stack overflow condtition (can't insert the element)
{
System.out.println("Stack is full");
return;
}
stack[++top]=x;
size++;
}

public int pop()
{
if(size()==0)//If size is zero then stack underflow condition
{
System.out.println("Stack is empty.");
return -1;
}
int pop = stack[top];
stack[top] = -1;
top--;
size--;

if(top==-1 && size != 0)
top = maxSize-1;

return pop;
}

public boolean isEmpty()
{
if(size()==0)
return true;

return false;
}

public int peek()
{
return stack[top];
}

public String toString()
{
return Arrays.toString(stack);
}

}
class Main {  
  public static void main(String args[]) { 
    //System.out.println("Hello, world!"); 
    MyStack stack = new MyStack();
    stack.push(1);
    stack.push(2);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    stack.push(3);
    stack.push(4);
    stack.push(5);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    stack.push(6);
    stack.push(7);
    System.out.println(stack);
  } 
}
/*
Date: 07/12/2021
Author: Saurabh Tripathi
Problem pattern : queues and Queues

Problem Statement:
A simple implementation of Stack using single Queue in Java

*/
import java.util.*;
class MyQueue
{
int[] queue; 
int size,front,rear,maxSize; //size to store current size of queue, maxSize is the maximum size of queue possible
MyQueue(int mSize)
{
size=0;
front=0;
rear=0;
maxSize=mSize;
queue = new int[maxSize];
Arrays.fill(queue,-1);//fill queue -1 to represent empty elements
}

public int size()
{
return size;
}

public void push(int x)
{
if(size()==maxSize && (rear+1)!=front)//If size is full then queue overflow condtition (can't insert the element)
{
//System.out.println("queue is full");
return;
}
queue[rear%maxSize]=x;
size++;
rear++;
}

public int pop()
{
if(size()==0)//If size is zero then queue underflow condition
{
//System.out.println("queue is empty.");
return -1;
}
int pop = queue[front%maxSize];
queue[front%maxSize] = -1;
front++;
size--;

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
return queue[front%maxSize];
}

public String toString()
{
return Arrays.toString(queue);
}

}

class MyStackUsingQueue
{
    int maxSize = 5;
    MyQueue queue = new MyQueue(maxSize);

    /*
    We will implement a single queue and pop all the elements before insertion 
    and insert all of them after insertion of current element. So the front 
    of queue will always point to the top of the queue
    Insertion complexity is O(n) in this case.
    */
    public void push(int x)
    {
        if (queue.size()==maxSize) {
            System.out.println("Stack is full");
            return;
        }
        int n= queue.size();
        queue.push(x);
        while(n>0)
        {
            int temp = queue.pop();
            queue.push(temp);
            n--;
        }
    }

    public int pop()
    {
        if (queue.size()==0) {
            System.out.println("Stack is empty");
            return -1;
        }
        return queue.pop();
    }

    public int size()
    {
        return queue.size();
    }

    public int peek()
    {
        return queue.peek();
    }

    public String toString()
    {
        return queue.toString();
    }
}
class Main {  
  public static void main(String args[]) { 
    //System.out.println("Hello, world!"); 
    MyStackUsingQueue stack = new MyStackUsingQueue();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    System.out.println(stack);
    stack.push(4);
    stack.push(5);
    System.out.println(stack);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
System.out.println(stack.pop());
    stack.push(6);
    stack.push(7);
    System.out.println(stack);
    System.out.println(stack.peek());
System.out.println(stack.pop());
System.out.println(stack.pop());
System.out.println(stack.pop());
  } 
}
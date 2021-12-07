/*
Date: 07/12/2021
Author: Saurabh Tripathi
Problem pattern : queues and Queues

Problem Statement:
A simple implementation of Queue using Array in Java

*/
import java.util.*;
class MyQueue
{
int[] queue; 
int size,front,rear,maxSize; //size to store current size of queue, maxSize is the maximum size of queue possible
MyQueue()
{
size=0;
front=0;
rear=0;
maxSize=5;
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
System.out.println("queue is full");
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
System.out.println("queue is empty.");
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
class Main {  
  public static void main(String args[]) { 
    //System.out.println("Hello, world!"); 
    MyQueue queue = new MyQueue();
    queue.push(1);
    queue.push(2);
    queue.push(3);
    queue.push(4);
    queue.push(5);
    System.out.println(queue.pop());
    System.out.println(queue.pop());
    System.out.println(queue.pop());
    System.out.println(queue.pop());
    queue.push(6);
    queue.push(7);
    queue.push(8);
    queue.push(9);
    System.out.println(queue.pop());
    System.out.println(queue.pop());
    queue.push(10);
    queue.push(11);
    System.out.println(queue);
System.out.println(queue.peek());
  } 
}
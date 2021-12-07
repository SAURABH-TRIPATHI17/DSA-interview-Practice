/*
Date: 07/12/2021
Author: Saurabh Tripathi
Problem pattern : Stacks and Queues

Problem Statement:
A simple implementation of Queue using Stack in Java

*/
import java.util.*;
class MyStack
{
int[] stack; 
int size,top,maxSize; //size to store current size of Stack, maxSize is the maximum size of stack possible
MyStack(int mSize)
{
size=0;
top=-1;
maxSize=mSize;
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

class QueueImplementaionUsingStack{
    int maxSize = 5;
    MyStack stack1 = new MyStack(maxSize);
    MyStack stack2 = new MyStack(maxSize);

    public void push(int x)
    {
        if (stack1.size()==maxSize) {
            System.out.println("Queue is full");
            return;
        }
        while(!stack1.isEmpty())
        {
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while(!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }

    }

    /* 
    Optimized push and pop for amorized o(1) time complexity
    push element in input stack(Stack1 in our case)
    pop elements from output stack(stack2 in our case)
    pop elements from stack2 if stack2 is empty then push all the elements from stack1
    to stack2 and pop the element from stack2.

    */
    public void push1(int x)
    {
        if (stack1.size()==maxSize) {
            System.out.println("Queue is full");
            return;
        }
        stack1.push(x);
    }

    public int pop1()
    {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int pop()
    {
        if (stack1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return stack1.pop();
    }

    public int size()
    {
        return stack1.size();
    }

    public boolean isEmpty()
    {
        return stack1.isEmpty();
    }
    
    public int peek()
    {
        return stack1.peek();
    }

    public int peek1()
    {
        return stack2.peek();
    }
    public String toString()
  {
    return stack1.toString() + stack2.toString();
  }
}


class Main {  
  public static void main(String args[]) { 
    //System.out.println("Hello, world!"); 
    QueueImplementaionUsingStack queue = new QueueImplementaionUsingStack();
    queue.push1(1);
    queue.push1(2);
    System.out.println(queue.pop1());
    System.out.println(queue.pop1());
    queue.push1(3);
    queue.push1(4);
    queue.push1(5);
    System.out.println(queue.pop1());
    queue.push1(6);
    queue.push1(7);
    System.out.println(queue);
    System.out.println(queue.peek());
    
  } 
}
import java.util.HashMap;
import java.util.Map;

class LFUCache {

    final int capacity;
    int curSize;
    int minFrequency;
    Map<Integer,DoubleLinkedList> frequencyMap;
    Map<Integer,DLLNode> cache;
    
    public LFUCache(int capacity) {
    
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;
        
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }
    
    public int get(int key) {
        //System.out.println(" get "+key);
        DLLNode currNode = cache.get(key);
        if(currNode==null)
            return -1;
        updateNode(currNode);
        return currNode.value;
        
    }
    
    public void put(int key, int value) {
        //System.out.println(" put "+key);
        if(capacity==0)
            return;
        if(cache.containsKey(key))
        {
            DLLNode currNode = cache.get(key);
            currNode.value = value;
            updateNode(currNode);
        }
        else
        {
            curSize++;
            if(curSize>capacity)
            {
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.remove(minFreqList.tail.prev);
                curSize--;
            }
            
            minFrequency=1;
            DLLNode newNode = new DLLNode(key,value);
            
            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1,curList);
            cache.put(key,newNode);
        }
    }
    
    public void updateNode(DLLNode curNode)
    {
        int curFreq = curNode.frequency;
        DoubleLinkedList curList = frequencyMap.get(curFreq);
        curList.remove(curNode);
        if(curFreq==minFrequency && curList.size==0)
            minFrequency++;
        curNode.frequency++;
        
        
        DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
        newList.addNode(curNode);
        frequencyMap.put(curNode.frequency,newList);
    }
    
    class DLLNode {
        DLLNode next,prev;
        int key,value,frequency;
        
        public DLLNode(int _key, int _val)
        {
            key=_key;
            value = _val;
            frequency = 1;
        }
        
    }
    
    class DoubleLinkedList{
        int size;
        DLLNode head,tail;
        public DoubleLinkedList()
        {
            size=0;
            this.head = new DLLNode(0,0);
            this.tail = new DLLNode(0,0);
            head.next = tail;
            tail.prev = head;
        }
        
        public void addNode(DLLNode node)
        {
            DLLNode headNext = head.next;
            head.next=node;
            node.next = headNext;
            node.prev = head;
            headNext.prev = node;
            size++;
        }
        
        public void remove(DLLNode node)
        {
            //System.out.println(node.value+" remove");
            DLLNode prevNode = node.next;
            DLLNode nextNode = node.prev;
            prevNode.next = node;
            nextNode.prev = node;
            size--;
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(2));
        cache.put(3,3);
        System.out.println(cache.get(1));
        cache.put(4,4);
        cache.put(5,5);
        System.out.println(cache.get(4));
        System.out.println(cache.get(4));
        cache.put(6,6);
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
        System.out.println(cache.get(6));
    }
}



/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
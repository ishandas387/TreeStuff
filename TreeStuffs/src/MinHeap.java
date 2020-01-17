import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Min heap getMin() should return the root element of the tree. O(1)
 * extractMin() will remove the root and minHeapify the tree again. O(logn)
 * insert() will find a suitable place for the insertion. minHeapify O(logN) if
 * a node is stored a index k, then its left child is stored at index 2k + 1 and
 * its right child at index 2k + 2.
 */

public class MinHeap{

    private int[] heap;
    private int size;
    private int capacity;
    private static final int FRONT=1;

    //initialize
    public MinHeap(int capacity){
        size=0;
        heap = new int[capacity+1];
        Arrays.fill(heap,-1);
    }

    //check if empty
    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == heap.length;
    }

    //return the parent of a node at pos i
    public int parent(int i){
        return heap[i/2];
    }

    //position of leftchild from current position
    public int leftChild(int i){
        return 2*i;
    }
    public int rightChild(int i){
        return (2*i)+1;
    }

    //is leaf node
    private boolean isLeaf(int i){
        if(i > size/2 && i <= size){
            return true;
        }
        return false;
    }

    //swapping two positions
    public void swap(int i , int j){
        int temp;
        temp = heap[j];
        heap[j]= heap[i];
        heap[i]= temp;

    }

    public void insert(int element){
        if(size > capacity){
            return;
        }
        heap[++size] =element;
        int current = size;

        //keeps on swapping until the parent is min
        while(heap[current] < heap[parent(current)]){
            //the parent is not min
            swap(current, parent(current));
            current = parent(current);
        }
    }

    //minheapify function
    public void minHeapify(int pos){
        //if it is not a leaf pos
        if(!isLeaf(pos)){
            if(heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)]){
                if(heap[leftChild(pos)] > heap[rightChild(pos)]){
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }
                else{
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    //function to remove and return the minimum
    public int remove(){
        int popped = heap[FRONT];
        heap[FRONT] = heap[size--];
        minHeapify(FRONT);
        return popped;
    }

    public static void main(String[] arg) 
    { 
        System.out.println("The Min Heap is "); 
        MinHeap minHeap = new MinHeap(15); 

        minHeap.usingPriorityQueue();
        minHeap.usingPriorityQueueAsMaxHeap();
        minHeap.insert(5); 
        minHeap.insert(3); 
        minHeap.insert(17); 
        minHeap.insert(10); 
        minHeap.insert(84); 
        minHeap.insert(19); 
        minHeap.insert(6); 
        minHeap.insert(22); 
        minHeap.insert(9); 
  
        System.out.println("The Min val is " + minHeap.remove()); 
    } 

    public void usingPriorityQueue(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(1);
        pq.add(12);

        System.out.println(pq.poll());
    }

    public void usingPriorityQueueAsMaxHeap(){
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        });
        pq.add(10);
        pq.add(1);
        pq.add(12);
        pq.add(4);

        System.out.println(pq.poll());
    }

    /**
     * PriorityQueue can be used as both min and max heap. based on the comparator you pass
     * For a PQ handling a specific object, the class should extend comparable and a comparator can be created 
     */
} 

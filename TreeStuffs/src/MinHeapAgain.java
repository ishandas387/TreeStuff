import java.util.Arrays;
/**
 * Creating a min heap has a complexity of O(nlogn)
 */
public class MinHeapAgain {

    // Min heap
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    // Helper methods

    private  int getLeftChildIndex(int parentIndex){
        return 2 * parentIndex +1;
    }

    private int getRightChildIndex(int parentIndex){
        return 2 * parentIndex +2;
    }

    private int getParentIndex(int index){
        return(index -1)/2;
    }

    private boolean hasLeftChild(int parentIndex){
        return getLeftChildIndex(parentIndex) < size;
    }

    private boolean hasRightChild(int parentIndex){
        return getRightChildIndex(parentIndex) < size;
    }

    private boolean hasParent(int index){
        return getParentIndex(index) >=0;
    }
    
    private int getLeftChild(int index){
        return items[getLeftChildIndex(index)];
    }

    private int getRightChild(int index){
        return items[getRightChildIndex(index)];
    }

    private int getParent(int index){
        return items[getParentIndex(index)];
    }

    private void swap(int i, int j){
        int temp = items[j];
        items[j] = items[i];
        items[i] = temp;
    }

    private void ensureCapacity(){
        if(size == capacity){
            items = Arrays.copyOf(items, capacity *2);
            capacity *= 2;
        }
    }

    public int peek(){
        if(size == 0){
            throw new IllegalStateException();
        }
        return items[0];
    }

    public int poll(){
        if(size == 0){
            throw new IllegalStateException();
        }
        int item = items[0];
        //move the last item to root
        items[0] = items[size -1];
        //then bubble down the root to down if it doesn't satisfy heap properties
        // in this case MIN
        //heapify
        heapifyDown();
        return item;
    }

    public void add(int item){
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size -1;
        while(hasParent(index) && getParent(index) > items[index]){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {

        //start with root node. 
        // check left child, only checking left child is sufficient 
        // as if there is no left child there will be no right child. 

        int index = 0;
        while(hasLeftChild(index)){
            int smallerIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && getRightChild(index) < getLeftChild(index)){
                smallerIndex = getRightChildIndex(index);
            }
            if(items[index] < items[smallerIndex]){
                break;
            } else {
                swap(index, smallerIndex);
            }
            index = smallerIndex;
        }
    }
}
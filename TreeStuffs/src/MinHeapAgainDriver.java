public class MinHeapAgainDriver {
    public static void main(String[] args) {
        MinHeapAgain minHeap = new MinHeapAgain();
        minHeap.add(3);
        minHeap.add(34);
        minHeap.add(1);
        minHeap.add(6);
        minHeap.add(2);
        System.out.println(minHeap.poll());
        minHeap.add(0);
        minHeap.add(32);
        System.out.println(minHeap.poll());
    }
}
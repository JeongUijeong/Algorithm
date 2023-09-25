package algorithm.heap.최대힙;

public class MaxHeap {

    public int[] heap;
    public int size;

    public MaxHeap(int length) {
        this.heap = new int[length];
        this.heap[0] = Integer.MAX_VALUE;
        this.size = 0;
    }

    public void upHeap(int pos) {
        int tmp = this.heap[pos];
        while (this.heap[pos / 2] < this.heap[pos]) {
            this.heap[pos] = this.heap[pos / 2];
            pos = pos / 2;
        }
        this.heap[pos] = tmp;
    }

    public void insert(int num) {
        this.heap[++size] = num;
        upHeap(size);
    }

    public void downHeap(int pos) {
        int tmp = this.heap[pos];
        while (pos <= size / 2) {
            int idx = pos * 2;
            if (idx < size && this.heap[idx] < this.heap[idx + 1]) {
                idx++;
            }
            this.heap[pos] = this.heap[idx];
            pos = idx;
        }
        this.heap[pos] = tmp;
    }

    public int get() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int tmp = this.heap[1];
        this.heap[1] = this.heap[size--];
        downHeap(1);
        return tmp;
    }

    public static void main(String[] args) {
        MaxHeap mh = new MaxHeap(100);
        mh.insert(10);
        mh.insert(5);
        mh.insert(8);
        mh.insert(15);
        mh.insert(3);
        mh.insert(12);

        for (int i = 1; i <= mh.size; i++) {
            System.out.print(mh.heap[i] + " ");
        }
        System.out.println();
        mh.insert(20);
        for (int i = 1; i <= mh.size; i++) {
            System.out.print(mh.heap[i] + " ");
        }
        System.out.println();
        System.out.println(mh.get());
        for (int i = 1; i <= mh.size; i++) {
            System.out.print(mh.heap[i] + " ");
        }
    }
}


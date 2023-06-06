//By Team members: Abrar Alkamajani - Rahaf Albrakati - Ghada Aljuhani - Rahaf Koshak
package GraphFramework;

import java.util.ArrayList;

public class MinHeap {

    private ArrayList<Edge> heap;

    public MinHeap() {
        this.heap = new ArrayList<Edge>();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        Edge temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void insert(Edge e) {
        heap.add(e);
        int current = heap.size() - 1;
        while (heap.get(current).getWeight()
                < heap.get(parent(current)).getWeight()) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public Edge extractMin() {
        Edge min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapify(0);
        return min;
    }

    private void heapify(int i) {
        int l = leftChild(i);
        int r = rightChild(i);
        int smallest = i;
        if (l < heap.size() && heap.get(l).getWeight()
                < heap.get(smallest).getWeight()) {
            smallest = l;
        }
        if (r < heap.size() && heap.get(r).getWeight()
                < heap.get(smallest).getWeight()) {
            smallest = r;
        }
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }
}

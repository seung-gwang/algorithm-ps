import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int[] heap = new int[100001]; // 크기를 1 더 크게 잡음
    public static int curSize = 0;

    // 힙에서 아래로 내려가면서 힙 정렬 유지
    public static void heapifyDown(int idx) {
        int leftIdx = 2 * idx + 1;
        int rightIdx = 2 * idx + 2;
        int largestIdx = idx;

        if (leftIdx < curSize && heap[leftIdx] > heap[largestIdx]) {
            largestIdx = leftIdx;
        }

        if (rightIdx < curSize && heap[rightIdx] > heap[largestIdx]) {
            largestIdx = rightIdx;
        }

        if (largestIdx != idx) {
            int tmp = heap[idx];
            heap[idx] = heap[largestIdx];
            heap[largestIdx] = tmp;
            heapifyDown(largestIdx);
        }
    }

    // 힙에서 위로 올라가면서 힙 정렬 유지
    public static void heapifyUp(int idx) {
        int parentIdx = (idx - 1) / 2;

        if (parentIdx >= 0 && heap[parentIdx] < heap[idx]) {
            int tmp = heap[parentIdx];
            heap[parentIdx] = heap[idx];
            heap[idx] = tmp;
            heapifyUp(parentIdx);
        }
    }

    // 힙에서 가장 큰 값을 추출
    public static int pop() {
        if (curSize == 0) {
            return 0;
        }
        int ret = heap[0];
        heap[0] = heap[--curSize];
        heapifyDown(0);
        return ret;
    }

    // 힙에 새로운 값을 추가
    public static void push(int n) {
        heap[curSize++] = n;
        heapifyUp(curSize - 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < N; ++i) {
            int input = Integer.parseInt(bf.readLine());

            if (input == 0) {
                output.append(pop()).append("\n");
            } else {
                push(input);
            }
        }
        System.out.print(output);
    }
}

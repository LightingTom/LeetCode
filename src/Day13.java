import java.util.Comparator;
import java.util.PriorityQueue;

public class Day13 {
    //use heap to store the information, and it will only take O(klogn) time
    //but the worst case: k = n^2
    public static int kthSmallest_heap(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            // Equal to create a class, smart choice
            pq.add(new int[]{matrix[i][0],i,0});
        }

        for (int i = 0; i < k-1; i++) {
            int[] target = pq.poll();
            if (target[2] != n - 1) {
                pq.add(new int[]{matrix[target[1]][target[2]+1],target[1],target[2]+1});
            }
        }
        return pq.poll()[0];
    }

    public static int kthSmallest_binary(int[][] matrix,int k){
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while (left < right){
            int mid = left + ((right-left)>>1);
            if (check(matrix,mid,k)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    public static boolean check(int[][] matrix, int target, int k){
        int n = matrix.length;
        int i = n - 1;
        int j = 0;
        int num = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= target) {
                num += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return num >= k;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,5,9},{10,11,13},{12,13,15}};
        System.out.print(kthSmallest_heap(mat,6));
        System.out.print(kthSmallest_binary(mat,6));
    }
}

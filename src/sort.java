import java.util.Arrays;

public class sort {
    public static void quickSort(int[] a, int p, int r) {
        if(p<r) {
            int q = partition(a, p, r);
            System.out.println(Arrays.toString(a));
            quickSort(a, p, q-1);
            quickSort(a, q+1, r);

        }
    }
    public static int partition(int[] a, int p, int r) {
        int x = a[r];
        int i = p-1;
        for (int j = p; j < r; j++) {
            if(a[j] < x) {
                i++;
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        int tmp = a[i+1];
        a[i+1] = a[r];
        a[r] = tmp;

        return i+1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4, 9, 2, 6, 8, 5, 7, 1, 3};
        quickSort(a, 0, a.length-1);


        // Merge sort
//        public static void mergeSort(int[] a, int p, int r) {
//            if(p<r) {
//                int q = (p+r)/2;
//                mergeSort(a, p, q);
//                mergeSort(a, q+1, r);
//                merge(a, p, q, r);
//                System.out.println(Arrays.toString(a));
//            }
//        }
//        public static void merge(int[] a, int p, int q, int r) {
//            int i=p, j=q+1, k=p;
//            int[] tmp = new int[a.length];
//            while(i<=q && j<=r) {
//                if(a[i] <= a[j])
//                    tmp[k++] = a[i++];
//                else
//                    tmp[k++] = a[j++];
//            }
//            while(i<=q) tmp[k++] = a[i++];
//            while(j<=r) tmp[k++] = a[j++];
//            for (int l = p; l <= r; l++) {
//                a[l] = tmp[l];
//            }
//        }

        // Insertion sort
//        for (int i = 1; i <= n-1; i++) { // 인덱스 0은 정렬되어 있다고 가정.
//            int tmp = a[i]; // 정렬하고자 하는 값
//            for (int j = i-1; j >= 0; j--) {
//                if(tmp < a[j]) { // 이전 값들보다 작다면 swap
//                    a[j+1] = a[j];
//                    a[j] = tmp;
//                }
//                else break;
//            }
//            System.out.println(Arrays.toString(a));
//        }

//        for(int i = 1; i < n; i++) {
//            int target = a[i];
//            int j = i - 1;
//            while(j >= 0 && target < a[j]) {
//                a[j + 1] = a[j];
//                j--;
//            }
//            a[j + 1] = target;
//            System.out.println(Arrays.toString(a));
//        }

         // Bubble Sort
//        for(int i = 0 ; i < a.length-1 ; i ++) {
//            for(int j = 0 ; j < a.length -i -1 ; j ++) {
//                if(a[j]>a[j+1]) {
//                    int tmp = a[j];
//                    a[j] = a[j+1];
//                    a[j+1] = tmp;
//                }
//            }
//            System.out.println(Arrays.toString(a));
//        }


//        for (int last = n; last > 2; last--) {
//            for (int i = 0; i < last-1; i++) {
//                if(a[i] > a[i+1]) {
//                    int tmp = a[i];
//                    a[i] = a[i+1];
//                    a[i+1] = tmp;
//                }
//            }
//            System.out.println(Arrays.toString(a));
//        }



        // Selection sort
//        for (int last = n-1; last >= 1; last--) { // 인덱스 0은 비교 안해도 됨.
//            int max_index = last;
//            for (int i = 0; i <= last-1; i++) {
//                if(a[max_index] < a[i]) max_index=i;
//            }
//            int tmp = a[max_index];
//            a[max_index] = a[last];
//            a[last] = tmp;
//            System.out.println(Arrays.toString(a));
//        }

//        int min, tmp;
//        for(int i=0; i<n-1; i++){ // n-1 : 마지막 요소는 자연스럽게 정렬됨
//            min = i;
//            for(int j=i+1; j<n; j++){
//                if(a[min] > a[j]){
//                    min = j;
//                }
//            }
//            tmp = a[min];
//            a[min] = a[i];
//            a[i] = tmp;
//            System.out.println(Arrays.toString(a));
//        }
    }

}

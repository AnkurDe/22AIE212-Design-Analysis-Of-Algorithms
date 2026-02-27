package Lab1;

//Write a program to implement inversion count.
//9. Given the Input (non-negative integers): A ={10 ,1,2,4,13,9,5} The number of inversions that are
//possible as follows:
//{( 10, 1 ), ( 10, 2 ),( 10 , 4 ), ( 10, 9 ), ( 10, 5) , (13 , 9 ), ( 13, 5) , ( 9 , 5 ) }
//Total count of inversions are: 8

public class Q8 {
    static int mergeSort(int[] arr, int left, int right) {
        int count = 0;

        if (left < right) {
            int mid = (left + right) / 2;

            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);
            count += merge(arr, left, mid, right);
        }

        return count;
    }

    static int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int count = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else {
                temp[k++] = arr[j++];
                count += (mid - i + 1);
            }
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= left) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, left, temp.length);
        return count;
    }

    static void main() {
        int[] arr = {10 ,1,2,4,13,9,5};
        System.out.println(mergeSort(arr, 0, arr.length - 1));
    }
}

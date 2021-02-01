package AllSolutions;

public class Jzoffer401 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0){
            return new int[0];
        }
        if(arr.length <= k){
            return arr;
        }
        partitionArray(arr, 0, arr.length - 1, k - 1);
        int[] result = new int[k];
        System.arraycopy(arr,0,result,0,k);
        return result;
    }

    private void partitionArray(int[] arr, final int startIndex, final int endIndex, final int targetIndex){
        if(startIndex >= endIndex){
            return;
        }
        final int pivotElement = arr[startIndex];
        int i = startIndex;
        int j = endIndex;
        while(i < j){
            while(i < j && arr[j] >= pivotElement){
                --j;
            }
            if(i < j){
                arr[i++] = arr[j];
            }
            while(i < j && arr[i] < pivotElement){
                ++i;
            }
            if(i < j){
                arr[j--] = arr[i];
            }
        }
        arr[i] = pivotElement;
        final int pivotIndex = i;
        if(pivotIndex != targetIndex){
            if (pivotIndex > targetIndex) {
                partitionArray(arr, startIndex, pivotIndex - 1, targetIndex);
            } else {
                partitionArray(arr, pivotIndex + 1, endIndex, targetIndex);
            }
        }
    }
}

package AllSolutions;

public class Jzoffer111 {
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        int pivot = -1;
        while (low < high){

            // To avoid overflow, we do not use "(high + low) / 2".
            pivot = low + (high - low) / 2;
            if (numbers[pivot] > numbers[high]){
                low = pivot + 1;
            }
            else if (numbers[pivot] < numbers[high]) {
                high = pivot;
            }
            else {
                --high;
            }
        }
        return numbers[low];
    }
}

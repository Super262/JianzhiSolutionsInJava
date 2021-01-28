package solutions;

public class Jzoffer661 {
    public int[] constructArr(int[] a) {
        if(a == null || a.length < 2){
            return new int[]{};
        }
        int[] prevA = new int[a.length];
        int[] afterA = new int[a.length];

        prevA[0] = 1;
        afterA[a.length - 1] = 1;

        for(int i = 1; i < prevA.length; ++i){
            prevA[i] = prevA[i - 1] * a[i - 1];
        }

        for(int i = afterA.length - 2; i >= 0; --i){
            afterA[i] = afterA[i + 1] * a[i + 1];
        }

        for(int i = 0; i < prevA.length; ++i){
            prevA[i] *= afterA[i];
        }

        return prevA;
    }
}

import java.util.Arrays;
public class CollectionOfInts {
    private int[] a;

    public CollectionOfInts(int[] keys) {
        a = Arrays.copyOf(keys, keys.length); // defensive copy
        Arrays.sort(a);
        }

        public boolean contains(int key) {
            return indexOf(key) != -1;
    }
    // linear search
//        private int indexOf(int key) {
//        // indexOf() implemented as a linear search.
//            for (int i = 0; i < a.length; i++) {
//                if (a[i] == key) return i;
//            }
//        return -1;
//        }
    //binary search
        private int indexOf(int key) {
        // indexOf() implemented as a binary search.
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) { // key is within a[lo...hi] or not present
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]){
                hi = mid - 1;
            }
            else if (key > a[mid]){
                lo = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
        }

        //I learn What an abstract data type is (ADT) how to filter out data and how the linear search compare to the binary search is how fast is it
        // binary search is way faster than linear search
}
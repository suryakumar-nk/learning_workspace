public class Merge2SortedArray {
    public static void main(String[] args) {
        int[] arr1 = {};
        int[] arr2 = {2,4,6,8,10};
        
        for (int i : merge(arr1, arr2)) System.out.println(i);
    }

    public static int[] merge(int[] arr1, int[] arr2)
    {
        if (arr1.length == 0) return arr2;
        if (arr2.length == 0) return arr1;
        
        int[] result = new int[(arr1.length + arr2.length)];
        int i = 0;
        int j = 0;
        int k = 0;

        while(true)
        {
            if (arr1.length == i && arr2.length == j) break;
            if (arr1.length == i)
            {
                result[k] = arr2[j];
                k++; j++; continue;
            }
            if (arr2.length == j)
            {
                result[k] = arr1[i];
                k++; i++; continue;
            }
            if (arr1[i] < arr2[j])
            {
                result[k] = arr1[i];
                k++; i++; continue;
            }
            if (arr1[i] > arr2[j])
            {
                result[k] = arr2[j];
                k++; j++; continue;
            }
        }
        return result;
    }
}

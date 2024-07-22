package Activities;

public class Activity4 {
    public static void main(String[] args) {
        int arr1[] = {19,21,13,17,04};
        int arrLen = arr1.length;

        System.out.print("Array before sort: ");
        for (int i=0; i<arrLen; i++){
            System.out.print(arr1[i] +" ");
        }

        for(int i =1; i<arrLen; i++){
            int key = arr1[i];
            int j = i - 1;

            while(j >=0 && arr1[j] > key){
                arr1[j+1] = arr1[j];
                j = j-1;
            }

            arr1[j+1]=key;
        }
        System.out.println();
        System.out.print("Sorted array: ");
        for (int i=0; i<arrLen; i++){
            System.out.print(arr1[i] +" ");
        }
    }
}

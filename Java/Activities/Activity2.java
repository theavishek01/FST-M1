package Activities;

import java.util.Arrays;

public class Activity2 {
    public static void main(String[] args) {
        int arr1[] = {10, 77, 10, 54, -11, 10};
        System.out.println("Original array: "+ Arrays.toString(arr1));

        int search = 10;

        int temp = 0;
        for (int i=0; i<= arr1.length-1; i++) {
            if (arr1[i] == 10) {
                temp = arr1[i] + temp;
            }
        }
        if(temp<=30){
            System.out.println("Total is "+temp);
        }
    }
}

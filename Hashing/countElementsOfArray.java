package Hashing;

import java.util.*;
/*
Inside a while loop, it takes input for the elements one by one and increments the corresponding index in the hashArr array.
This is a basic form of hashing, where each element is used as an index to store the count of that element in the array.
 */
public class countElementsOfArray {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Number of Elements: ");
        int numOfElements = input.nextInt();
        System.out.println("Enter the elements: ");

        int maxNum = 100000007;
        int[] hashArr = new int[maxNum];
        while (numOfElements > 0 ) {
            int index = 0;
            int nums = input.nextInt();
            hashArr[nums]++;
            numOfElements--;
        }

        System.out.println("Enter element which you want to find the frequency of : ");
        int find = input.nextInt();
        System.out.println("The frequency of " + find + " is: " + hashArr[find]);
    }
}

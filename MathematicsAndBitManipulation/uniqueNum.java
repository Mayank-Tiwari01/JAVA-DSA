package MathematicsAndBitManipulation;
//only works when all the numbers are even appearing number except for one number. the explanation is below.
public class uniqueNum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 4, 4, 4, 8, 8, 8, 9};
        System.out.println(unique(nums));
    }
    static int unique(int[] nums) {
        int unique = 0; //because when you XOR 0 with any number, it gives that same number.
        for (int i : nums) {
            unique ^= i; // at first, unique will have the first element of the array.
        }
        return unique;
    }
}
/*
It works because the XOR operation is both commutative and associative
And XORing a number with itself cancels out.
Commutative Property of XOR:
XOR is a binary operation with the property that it doesn't matter in which order you perform it.
In other words, for any two-numbers a and b, a ^ b is the same as b ^ a.
This property is known as the commutative property.

Example: 5 ^ 3 is the same as 3 ^ 5, and the result is 6 in both cases.

Associative Property of XOR: XOR is also associative,
which means that when you have more than two numbers, the order in which you perform the XOR operation doesn't matter.
For three numbers a, b, and c, (a ^ b) ^ c is the same as a ^ (b ^ c).

Example: (5 ^ 3) ^ 7 is the same as 5 ^ (3 ^ 7), and the result is 3 in both cases.

XORing a Number with Itself:
When you XOR a number with itself, the result is always 0. This is a fundamental property of the XOR operation.

Example: 5 ^ 5 is equal to 0.

Now, let's apply these properties to find a unique number in an array:

Given an array of numbers where all numbers appear twice except one, you can XOR all the numbers in the array together.

Because of the commutative property, it doesn't matter in which order you XOR the numbers.

For every number that appears twice in the array, XORing it with itself results in 0, effectively canceling it out.

The only number that is not canceled out is the unique number that appears only once.
XORing this unique number with 0 (the initial value) leaves it unchanged.
 */

package BasicJavaPrograms;

import java.util.Scanner;

public class UseScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        scanner.close();

        System.out.println(fun(str1, str2));
    }
    private static boolean fun(String str1, String str2) {
        return str1.equals(str2);
    }
}

package StringsAndStringBuilder;
//https://www.youtube.com/watch?v=Mmy9hdPXwRc&list=TLPQMDMwNTIwMjQVYQhf2MDQuw&index=3
public class CompareVersionNumbers {
    public static void main(String[] args) {
        String version1 = "0.1";
        String version2 = "1.1";
        System.out.println(compareVersion(version1, version2));
    }
    static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int len = Math.max(v1.length, v2.length);
        for (int i = 0; i < len; i++) {
            int j = 0;
            while (i < v1.length && j < v1[i].length() && v1[i].charAt(j) == '0')
                j++;
            int k = 0;
            while (i < v2.length && k < v2[i].length() && v2[i].charAt(k) == '0')
                k++;
            int one = (i >= v1.length || j == v1[i].length()) ? 0 : Integer.parseInt(v1[i].substring(j));
            int two = (i >= v2.length || k == v2[i].length() ) ? 0 : Integer.parseInt(v2[i].substring(k));

            if (one > two) return 1;
            if (two > one) return -1;
        }
        return 0;
    }
}

package StringsAndStringBuilder;
/*
Runtime
1 ms
Beats
86.75% (did it mah self)
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        String s = "########################################################################################################################################################################################################";
        String t = "m#q#k#t#h#y#p#h#t#y#s#e#f#h#n#l#r#z#q#t#s#p#n#l#l#d#h###p#g#f#w#k#d#f#b#p#r#s#m#c#k#t#m#b#z#h#q#w#k###e#y#v###h#t#e#t#u#g#k#t#r#g#d#l#e#g#w#q###e#y#j#x#x#h#h#t#w#m#j#p#o#o#w#q#n#c#u#k#x#l#c#c#h#d#z###";
        System.out.println(isEqual(s, t));
    }
    static boolean isEqual(String s, String t) {
        StringBuilder sFinal = new StringBuilder(s);
        StringBuilder tFinal = new StringBuilder(t);

        checkerChecker(sFinal);
        checkerChecker(tFinal);
        return (sFinal.toString().contentEquals(tFinal));
    }
    static void checkerChecker (StringBuilder str) {
        int i = 0;
        while (i < str.length()) {
            if ( i != 0 && str.charAt(i) == '#') {
                str.deleteCharAt(i);
                str.deleteCharAt(i - 1);
                if (i == 1) {
                    i -= 2;
                }
                else {
                    i -= 3;
                }
            }
            if (i == 0 && str.charAt(i)== '#') {
                str.deleteCharAt(i);
                i--;
            }

            i ++;
        }
    }
}

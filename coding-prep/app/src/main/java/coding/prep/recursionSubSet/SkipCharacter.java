package coding.prep.recursionSubSet;

public class SkipCharacter {
    public static void main(String[] args) {
        String str = "baccad";
        String res = "";
        // WithArgRecc(str, res);

        System.out.println(WithArgRecc2(str));
    }

    public static void WithArgRecc(String str,String res){
        if(str.isEmpty()) {
            System.out.println(res); 
            return;
        };

        char ch = str.charAt(0);

        if(ch == 'a') WithArgRecc(str.substring(1), res);
        else WithArgRecc(str.substring(1), res + ch);
    }

    public static String WithArgRecc2(String str) {
        if (str.isEmpty()) {
            return "";
        }
        ;

        char ch = str.charAt(0);

        if (ch == 'a')
            return WithArgRecc2(str.substring(1));
        else
            return ch + WithArgRecc2(str.substring(1));
    }
}

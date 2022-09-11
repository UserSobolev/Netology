public class Main {
    public static void main(String[] args) {
        String str1 = "Мама мыла раму";
        String str2 = "Раму";
        for (int i = 0; i < str1.length(); i++) {
            if (str1.regionMatches(true, i, str2, 0, str2.length())){
                System.out.println(i);
            }
        }
        str2.toLowerCase();
        StringBuilder newStr = new StringBuilder(str2).reverse();
        System.out.println(newStr.toString().toLowerCase());

    }
}

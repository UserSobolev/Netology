public class BinOps {
    public String sum(String a, String b) {
       int result =  Integer.parseInt(a, 2) + Integer.parseInt(b, 2);
       return Integer.toBinaryString(result);
    }

    public String mult(String a, String b) {
        int result =  Integer.parseInt(a, 2) * Integer.parseInt(b, 2);
        return Integer.toBinaryString(result);
    }
}
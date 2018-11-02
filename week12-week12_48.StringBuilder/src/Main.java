
public class Main {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(build(t));
    }

    public static String build(int[] t) {
        StringBuilder sb = new StringBuilder("{ \n ");
        int helper = 0;
        for (int i : t){
            sb.append(i);
            helper++;
            if (helper != t.length){
                sb.append(", ");
                if (helper % 4 == 0){
                    sb.append("\n ");
                }
            }
        }
        sb.append("\n}\n");
        return sb.toString();
    }
}

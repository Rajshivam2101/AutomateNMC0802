package programpractice;

public class ReverseString {


    public static void main(String[] args) {


        String name = "Shivam Singh Rajput";

        String[] str = name.split(" ");

        StringBuilder rev = new StringBuilder();


        for (String keep : str) {

            if (keep.equals(str[str.length - 2])) {
                StringBuilder stringBuilder = new StringBuilder(keep);
                rev.append(stringBuilder.reverse()).append(" ");

            } else {
                rev.append(keep).append(" ");
            }


        }

        System.out.println(rev);
    }
}

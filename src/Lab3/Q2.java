package Lab3;

// Long Integer multiplication
public class Q2 {

    public static String multiply(String num1, String num2) {

        int n1 = num1.length();
        int n2 = num2.length();

        int[] result = new int[n1 + n2];

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {

                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                int product = digit1 * digit2;

                int sum = product + result[i + j + 1];

                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {

        String num1 = "987654321987654321";
        String num2 = "123456789123456789";

        String result = multiply(num1, num2);

        System.out.println("Result:");
        System.out.println(result);
    }
}
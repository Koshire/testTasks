import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        String palindrome = "baoppoab";
        System.out.println(isPalindrome(palindrome));

        String reverse = " he llo !";
        System.out.println(reverse(reverse));

        Number number = reverseNumber(123.0045);
        System.out.println(number);

        Number numberDouble = reverseNumberDouble(123.0045);
        System.out.println(numberDouble);
        Number numberDouble2 = reverseNumberDouble(1230009.0);
        System.out.println(numberDouble2);

        Number numberInteger = reverseNumberInteger(12398);
        System.out.println(numberInteger);

        int[] mass = {12,3,7,1,1,33,90};
        System.out.println(Arrays.toString(sort(mass)));
    }

    private static int[] sort(int[] mass) {
        int length = mass.length;

        if (length <= 1) {
            return mass;
        }

        boolean isSorted = false;
        int buffer;

        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < length - 1; i++) {
                if (mass[i] > mass[i + 1]) {
                    isSorted = false;

                    buffer = mass[i];
                    mass[i] = mass[i + 1];
                    mass[i + 1] = buffer;
                }
            }
        }
        return mass;
    }


    private static Number reverseNumberInteger(Integer number) {
        if (Objects.isNull(number)) {
            return 0;
        }
        char[] chars = number.toString().toCharArray();

        String reverse = reverse(new String(chars));

        return Integer.parseInt(reverse);
    }

    private static Number reverseNumberDouble(Double number) {
        if (Objects.isNull(number)) {
            return 0;
        }
        char[] chars = number.toString().toCharArray();

        String reverse = reverse(new String(chars));

        return Double.parseDouble(reverse);
    }

    private static Number reverseNumber(Number number) {
        if (Objects.isNull(number)) {
            return 0;
        }
        char[] chars = number.toString().toCharArray();

        String reverse = reverse(new String(chars));

        Number result = new Number() {
            @Override
            public int intValue() {
                return Integer.parseInt(reverse);
            }

            @Override
            public long longValue() {
                return Long.parseLong(reverse);
            }

            @Override
            public float floatValue() {
                return Float.parseFloat(reverse);
            }

            @Override
            public double doubleValue() {
                return Double.parseDouble(reverse);
            }
        };

        if (number instanceof Double) {
            return result.doubleValue();
        }

        if (number instanceof Float) {
            return result.floatValue();
        }

        if (number instanceof Integer) {
            return result.intValue();
        }

        if (number instanceof Long) {
            return result.longValue();
        }

        return 0;
    }

    private static String reverse(String value) {
        if (Objects.isNull(value) || value.isBlank()) {
            return "";
        }

        char[] chars = value.toCharArray();

        int length = chars.length;

        for (int head = 0, tail = length - 1; head < tail; head++, tail--) {
            char headChar = chars[head];
            char tailChar = chars[tail];

            chars[head] = tailChar;
            chars[tail] = headChar;
        }
        return new String(chars);
    }

    private static boolean isPalindrome(String palindrome) {
        if (Objects.isNull(palindrome) || palindrome.isBlank()) {
            return true; // or false according to requirement
        }

        char[] chars = palindrome.toCharArray();

        int length = chars.length;

        for (int head = 0, tail = length - 1; head < length; head++, tail--) {
            if (chars[head] != chars[tail]) {
                return false;
            }
        }
        return true;
    }
}

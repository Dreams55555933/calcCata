import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите операцию:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            System.out.println(calc(input));
        }catch (RuntimeException ex){
            throw new Exception("т.к. строка не является математической операцией");
        }
    }

    public static String calc(String input) throws Exception {
        char[] chars = input.toCharArray();
        int result = 0;
        String[] nums = input.split("[+\\-*/]");
        boolean isRoman = false;
        int num1, num2;
        if(checkRoman(nums[0])&checkRoman(nums[1])){
            num1 = convertRomanToInt(nums[0]);
            num2 = convertRomanToInt(nums[1]);
            isRoman = true;
        }else if((!checkRoman(nums[0])&checkRoman(nums[1])||(checkRoman(nums[0])&!checkRoman(nums[1])))){
            throw new Exception("т.к. используются одновременно разные системы счисления");
        }else{
            num1 = Integer.parseInt(nums[0]);
            num2 = Integer.parseInt(nums[1]);
        }

        if (nums.length != 2){
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        if (num1 > 10 || num2 > 10) {
            throw new Exception("т.к. числа должны быть меньше или равно 10!");
        }
        for (char ch : chars) {

            if (ch == '+') {
                result = num1 + num2;
            }
            else if (ch == '-') {
                result = num1 - num2;
            }
            else if (ch == '*') {
                result = num1 * num2;
            }
            else if (ch == '/') {
                result = num1 / num2;
            }

        }
        if (isRoman){
            return convertIntToRoman(result);
        }else {
            return Integer.toString(result);
        }

    }
    private static int convertRomanToInt(String text){
        String [] roman ={"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        int num = 0;
        for (String s:roman) {
            if (Objects.equals(text, s)) {
                break;
            }
            num++;
        }
        return  num;
    }
    private static String convertIntToRoman(int num) throws Exception {
        String [] roman ={
                "O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        String result;
        if (num<=0){
            throw new Exception("т.к. в римской системе нет отрицательных чисел и нуля");
        }
        result = roman[num];
        return  result;
    }
    private static boolean checkRoman(String text){
        String [] roman ={
                "O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        boolean resultIsCheck = false;
        for (String s : roman) {
            if (s.equals(text)) {
                resultIsCheck = true;
                break;
            }
        }
        return resultIsCheck;
    }
}
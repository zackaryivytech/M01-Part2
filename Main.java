public class Main {
    public static void main(String[] args) {

        System.out.println(isValid(4388576018410707L));
        System.out.println(isValid(4388576018402626L));


    }

    public static boolean isValid(long number){

        int num1 = sumOfDoubleEvenPlace(number);

        int num2 = sumOfOddPlace(number);


        return (num1 + num2) % 10 == 0;
    }

    public static int sumOfDoubleEvenPlace(long number){

        int size = getSize(number);

        int sum = 0;

        int digit;

        for (int i = 1; i <= size; i++) {


            digit = getDigit((int) (number % 10));

            // Check if it's an even-positioned digit from the right
            if ((i) % 2 == 0) {
                sum += getDigit(digit * 2);  // Double the digit and add its digits
            }

            number /= 10;
        }

        return sum;

    }

    public static int getDigit(int number){

        int sum = 0;

        if(number / 10 == 0)
            return number;

        else{

            sum += number / 10;

            sum += number % 10;
        }

        return sum;

    }

    public static int sumOfOddPlace(long number){

        int size = getSize(number);

        int sum = 0;

        int digit;

        for (int i = 1; i <= size; i++) {


            digit = getDigit((int) (number % 10));

            // Check if it's an odd-positioned digit from the right
            if ((i) % 2 != 0) {
                sum += getDigit(digit);  // Double the digit and add its digits
            }

            number /= 10;
        }

        return sum;

    }

    public static boolean prefixMatched(long number, int d){

        while(number > 10){
            number /= 10;
        }

        return number == d;
    }

    public static int getSize(long d){
        int x = 0;
        while(d != 0){
            d = d / 10;
            x++;
        }
        return x;
    }

    public static long getPrefix(long number, int k){

        while(getSize(number) > k){

            number /= 10;
        }

        return number;
    }
}
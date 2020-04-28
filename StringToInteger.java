public class StringToInteger {

    private static int prepareOutput(long number, boolean isNegative) {
        // Instantiate long values for int limits
        long max_value = (long) Integer.MAX_VALUE;
        long min_value = (long) Integer.MIN_VALUE;

        if(isNegative) {
            number = -number;
            if (number < min_value) {
                return Integer.MIN_VALUE;
            }else{
                return (int) number;
            }
        }else{
            if (number > max_value) {
                return Integer.MAX_VALUE;
            }else{
                return (int) number;
            }
        }
    }
    
    public static int myAtoi(String str) {
        // We presume that the number is not negative
        boolean isNegative = false;

        boolean alreadySigned = false;

        boolean alreadyComputing = false;
        
        // Number to be returned
        long number = 0;

        // Iterate over characters
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                if (number >= Long.MAX_VALUE/10){
                    if (isNegative) {
                        return Integer.MIN_VALUE;
                    }else{
                        return Integer.MAX_VALUE;
                    }
                }
                number = number * 10 + Character.getNumericValue(c);
                alreadyComputing = true;
            }else if (c == '-') {
                if (alreadyComputing) {
                    return prepareOutput(number, isNegative);
                }
                if (alreadySigned) {
                    return 0;
                }
                isNegative = true;
                alreadySigned = true;
                alreadyComputing = true;
            }else if (c == '+') {
                if (alreadyComputing) {
                    return prepareOutput(number, isNegative);
                }
                if (alreadySigned) {
                    return 0;
                }
                alreadySigned = true;
                alreadyComputing = true;
            }else if (c == ' ') {
                if (alreadyComputing) {
                    return prepareOutput(number, isNegative);
                }
            }else if (c != ' '){
                return prepareOutput(number, isNegative);
            }
        }
        return prepareOutput(number, isNegative);
    }
    
    public static void main(String[] args) {
        System.out.println(myAtoi("+-2"));
    }
}
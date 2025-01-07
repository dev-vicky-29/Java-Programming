class Solution {
    public static String dashDigits(int number) {
        return String.join("-", Integer.toString(number).split(""));
    }
}
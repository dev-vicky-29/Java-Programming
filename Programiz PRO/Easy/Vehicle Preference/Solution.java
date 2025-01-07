public class Solution {
    public static String checkPreference(int preference) {
        switch (preference) {
            case 2:
                return "Bike";
            case 3:
                return "Trikes";
            case 4:
                return "Car";
            default:
                return "Other";
        }
    }
}
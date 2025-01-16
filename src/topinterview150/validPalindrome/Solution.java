package topinterview150.validPalindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        int leftIdx = 0;
        int rightIdx = s.length() - 1;
        char leftChar;
        char rightChar;
        while (leftIdx < rightIdx) {
            leftChar = Character.toLowerCase(s.charAt(leftIdx));
            if (!Character.isDigit(leftChar) && !Character.isLetter(leftChar)) {
                leftIdx++;
                continue;
            }
            rightChar = Character.toLowerCase(s.charAt(rightIdx));
            if (!Character.isDigit(rightChar) && !Character.isLetter(rightChar)) {
                rightIdx--;
                continue;
            }
            if (leftChar == rightChar) {
                leftIdx++;
                rightIdx--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Solution().isPalindrome("A man, a plan, a canal: Panama");
        new Solution().isPalindrome("race a car");
    }
}

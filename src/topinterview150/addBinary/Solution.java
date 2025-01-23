package topinterview150.addBinary;

public class Solution {
    public String addBinary(String a, String b) {
        String bitStr = "";
        final int aLen = a.length();
        final int bLen = b.length();
        final int maxABLen = Math.max(aLen, bLen);
        int aIdx = aLen - 1;
        int bIdx = bLen - 1;
        boolean carryOver = false;
        while (aIdx >= 0 && bIdx >= 0) {
            if (a.charAt(aIdx) == '0' && b.charAt(bIdx) == '0') {
                if (carryOver) {
                    bitStr = "1" + bitStr;
                    carryOver = false;
                } else {
                    bitStr = "0" + bitStr;
                    carryOver = false;
                }
            } else if ((a.charAt(aIdx) == '0' && b.charAt(bIdx) == '1')
                    || (a.charAt(aIdx) == '1' && b.charAt(bIdx) == '0')) {
                if (carryOver) {
                    bitStr = "0" + bitStr;
                    carryOver = true;
                } else {
                    bitStr = "1" + bitStr;
                    carryOver = false;
                }
            } else {
                if (carryOver) {
                    bitStr = "1" + bitStr;
                    carryOver = true;
                } else {
                    bitStr = "0" + bitStr;
                    carryOver = true;
                }
            }
            aIdx--;
            bIdx--;
        }
        if (aIdx >= 0) {
            for (int i = aIdx; i >= 0; i--) {
                if (a.charAt(i) == '0') {
                    if (carryOver) {
                        bitStr = "1" + bitStr;
                        carryOver = false;
                    } else {
                        bitStr = "0" + bitStr;
                        carryOver = false;
                    }
                } else if (a.charAt(i) == '1') {
                    if (carryOver) {
                        bitStr = "0" + bitStr;
                        carryOver = true;
                    } else {
                        bitStr = "1" + bitStr;
                        carryOver = false;
                    }
                }
            }
        } else if (bIdx >= 0) {
            for (int i = bIdx; i >= 0; i--) {
                if (b.charAt(i) == '0') {
                    if (carryOver) {
                        bitStr = "1" + bitStr;
                        carryOver = false;
                    } else {
                        bitStr = "0" + bitStr;
                        carryOver = false;
                    }
                } else if (b.charAt(i) == '1') {
                    if (carryOver) {
                        bitStr = "0" + bitStr;
                        carryOver = true;
                    } else {
                        bitStr = "1" + bitStr;
                        carryOver = false;
                    }
                }
            }
        }
        if (carryOver) {
            bitStr = "1" + bitStr;
        }
        return bitStr;
    }

    public static void main(String[] args) {
        new Solution().addBinary("1010", "1011");
        new Solution().addBinary("100", "110010");
    }
}

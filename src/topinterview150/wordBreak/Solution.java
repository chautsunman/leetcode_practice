package topinterview150.wordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        final int sLen = s.length();
        final boolean[] canBeConstructed = new boolean[sLen + 1];
        canBeConstructed[0] = true;
        int checkPrevIdx;
        for (int i = 1; i <= sLen; i++) {
            for (String word : wordDict) {
                checkPrevIdx = i - word.length();
                if (checkPrevIdx >= 0
                        && canBeConstructed[checkPrevIdx]
                        && s.substring(checkPrevIdx, i).equals(word)) {
                    canBeConstructed[i] = true;
                    break;
                }
            }
        }
        return canBeConstructed[sLen];

//        final Set<String> wordsSeen = new HashSet<>();
//        String[] strSplit;
//        boolean foundSolution;
//        for (String word : wordDict) {
//            strSplit = s.split(word);
//            foundSolution = true;
//            for (String strSplitPart : strSplit) {
//                if (!wordsSeen.contains(strSplitPart)) {
//                    foundSolution = false;
//                    break;
//                }
//            }
//            if (foundSolution) {
//                return true;
//            }
//            wordsSeen.add(word);
//        }
//        return false;
    }
}

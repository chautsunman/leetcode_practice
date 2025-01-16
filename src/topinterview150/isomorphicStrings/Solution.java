package topinterview150.isomorphicStrings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        final int sLen = s.length();
        final Map<Character, Character> charMap = new HashMap();
        final Set<Character> hadMapping = new HashSet();
        char currSChar;
        char currTChar;
        char mappedChar;
        for (int i = 0; i < sLen; i++) {
            currSChar = s.charAt(i);
            currTChar = t.charAt(i);
            if (charMap.containsKey(currSChar)) {
                mappedChar = charMap.get(currSChar);
                if (mappedChar != currTChar) {
                    return false;
                }
            } else {
                if (hadMapping.contains(currTChar)) {
                    return false;
                }
                charMap.put(currSChar, currTChar);
                hadMapping.add(currTChar);
            }
        }
        return true;
    }
}

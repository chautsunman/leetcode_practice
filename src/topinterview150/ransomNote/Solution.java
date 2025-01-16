package topinterview150.ransomNote;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        final int ransomNoteLen = ransomNote.length();
        final int magazineLen = magazine.length();
        final Map<Character, Integer> ransomNoteCharCnt = new HashMap();
        char currChar;
        int currCnt;
        for (int i = 0; i < ransomNoteLen; i++) {
            currChar = ransomNote.charAt(i);
            if (ransomNoteCharCnt.containsKey(currChar)) {
                ransomNoteCharCnt.put(currChar, ransomNoteCharCnt.get(currChar) + 1);
            } else {
                ransomNoteCharCnt.put(currChar, 1);
            }
        }
        for (int i = 0; i < magazineLen; i++) {
            currChar = magazine.charAt(i);
            if (!ransomNoteCharCnt.containsKey(currChar)) {
                continue;
            }
            currCnt = ransomNoteCharCnt.get(currChar);
            if (currCnt > 1) {
                ransomNoteCharCnt.put(currChar, currCnt - 1);
            } else {
                ransomNoteCharCnt.remove(currChar);
                if (ransomNoteCharCnt.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }
}

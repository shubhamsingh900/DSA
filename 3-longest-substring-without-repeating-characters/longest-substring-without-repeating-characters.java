import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, ans = 0;

        for (int r = 0; r < s.length(); r++) {
            while (!set.add(s.charAt(r))) {
                set.remove(s.charAt(l++));
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
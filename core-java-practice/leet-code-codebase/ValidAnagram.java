class Solution {
    public boolean isAnagram(String s, String t) {

        // if lengths differ, not anagram
        if (s.length() != t.length()) {
            return false;
        }

        // count characters
        int[] count = new int[26];

        // increment count for s
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // decrement count for t
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }

        // check if all counts are zero
        for (int n : count) {
            if (n != 0) {
                return false;
            }
        }

        // valid anagram
        return true;
    }
}


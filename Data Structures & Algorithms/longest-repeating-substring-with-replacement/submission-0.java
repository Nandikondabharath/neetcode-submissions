class Solution {
    public int characterReplacement(String s, int k) {
        int count[] = new int[26];
        int left = 0;
        int maxf = 0,maxlen = 0;
        for(int right=0;right < s.length();right++){
            char ch = s.charAt(right);
            count[ch - 'A']++;
            maxf = Math.max(maxf, count[ch - 'A']);
            while ((right - left + 1) - maxf > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }
}

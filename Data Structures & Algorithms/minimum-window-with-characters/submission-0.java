class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        int left =0,cnt =0;
        int minLen = Integer.MAX_VALUE;
        int sIndex = -1;
        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) >= 0) {
                    cnt++;
                }
            }
            while (cnt == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    sIndex = left;
                }
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        cnt--;
                    }
                }
                left++;
            }
        }
        return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLen);
    }
}

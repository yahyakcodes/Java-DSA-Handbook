class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.append('#');
        sb.append(new StringBuilder(s).reverse());

        int[] lps = new int[sb.length()];
        
        int i = 1;
        int len = 0;
        while(i < sb.length()) {
            if(sb.charAt(i) == sb.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else if(len > 0) {
                len = lps[len - 1];
            }
            else {
                i++;
            }
        }

        if(len == s.length()) return s;
        sb = new StringBuilder(s.substring(len));
        sb.reverse();
        sb.append(s);
        return sb.toString();
    }
}

// TC - O(N)
// SC - O(N)

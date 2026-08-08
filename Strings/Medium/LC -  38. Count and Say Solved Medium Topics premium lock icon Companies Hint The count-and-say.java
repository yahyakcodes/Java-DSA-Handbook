class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String rle = "1";
        for(int i = 2; i <= n; i++) {
            rle = findRle(rle);
        }
        return rle;
    }

    public String findRle(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); ) {
            char ch = s.charAt(i);
            int ind = i + 1;
            int freq = 1;
            while(ind < s.length() && s.charAt(ind) == ch) {
                freq++; ind++;
            }
            sb.append(freq);
            sb.append(ch);
            i += freq;
        }
        return sb.toString();
    }
}

//TC - O(N * L)
//SC - O(L)

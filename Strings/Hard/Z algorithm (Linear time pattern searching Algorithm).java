class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> ans = new ArrayList<>();
        String str = pat + "&" + txt;
        int n = str.length();
        int[] z = new int[n];
        int l = 0, r = 0;
        
        for(int i = 1; i < n; i++) {
            if(i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            
            while(i + z[i] < n && str.charAt(z[i]) == str.charAt(i + z[i])) {
                z[i]++;
            }
            
            if(i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(z[i] >= pat.length()) {
                ans.add(i - pat.length() - 1);
            }
        }
        
        return ans;
    }
}

// TC - O(n + m)
// SC - O(n + m)

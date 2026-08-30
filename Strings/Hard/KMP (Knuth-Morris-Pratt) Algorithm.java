// Best video exp => https://youtu.be/qases-9gOpk?si=DQyc7ll9tYIp6xg5 

class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> list = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;
        while(i < m) {
            if(pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            
            else if(len > 0) {
                len = lps[len - 1];
            }

            else i++;
        }
        
        int j = 0;
        i = 0;
        while(i < n) {
            if(txt.charAt(i) == pat.charAt(j)) {
                i++; 
                j++;
                
                if(j == m) {
                    list.add(i - j);
                    j = lps[j - 1];
                }
            }
            
            else if(j > 0) {
                j = lps[j - 1];
            }
            
            else i++;
        }
        
        return list;
    }
}

// TC - O(N + M)
// SC - O(M)

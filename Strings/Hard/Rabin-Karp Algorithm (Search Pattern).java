// 1. First, make a hash for the pattern and the first text window.
// 2. If both hashes match, check the actual characters to confirm it's a real match.
// 3. Now slide the window one step ahead — don't calculate the whole hash again.
// 4. Remove the old character, shift the hash, and add the new character.
// 5. Keep sliding until the end and save the starting index whenever we find the pattern.

// ⚠️ Hash match doesn't guarantee a match because different strings can have the same hash → compare characters (collisons).
// hpv = base^(n-1) % mod; calculate it step-by-step to avoid Math.pow() overflow.
// Keep hash positive after subtraction: if(hash < 0) hash += mod.
class Solution {
    public ArrayList<Integer> rabinKarp(String text, String pattern) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int n = pattern.length();
        int m = text.length();
        
        if(n > m) return list;
        
        int base = 256;
        int mod = 101;
        
        int texthash = 0;
        int patternhash = 0;
        
        for(int i = 0; i < n; i++) {
            patternhash = (patternhash * base + pattern.charAt(i)) % mod;
            texthash = (texthash * base + text.charAt(i)) % mod;
        }
        
        int hpv = 1;
        for(int i = 1; i < n; i++) {
            hpv = (hpv * base) % mod;
        }
        
        for(int i = 0; i <= m - n; i++) {
            if(texthash == patternhash) {
                boolean found = true;
                for(int j = 0; j < n; j++) {
                    if(pattern.charAt(j) != text.charAt(i + j)) {
                        found = false;
                        break;
                    }
                }
                if(found) list.add(i);
            }
            
            if(i < m - n) {
                texthash = (texthash - text.charAt(i) * hpv) % mod;
                texthash = (texthash * base) % mod;
                texthash = (texthash + text.charAt(i + pattern.length())) % mod;
                if(texthash < 0) {
                    texthash += mod;
                }
            }
        }
        
        return list;
    }
}

//TC: O(m + n) average, O(mn) worst case
//SC: O(k), or O(1) auxiliary space excluding output.

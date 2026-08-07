//Intution - look to complete closing bracket closing must have opening.

class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0, close = 0;
        int count = 0;
        for(char ch : s.toCharArray()) {
            if(ch == ')') {
                close++;
                if(open > 0) open--;
                else count++;
            }
            else open++;
        }
        if(open > 0) count += open;
        return count;
    }
}
// TC - O(N)
// SC - O(1)


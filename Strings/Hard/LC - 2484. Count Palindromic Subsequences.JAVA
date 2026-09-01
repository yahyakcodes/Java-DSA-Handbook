// Brute Force give TLE

class Solution {
    public int countPalindromes(String s) {
        int n = s.length();
        int mod = (int) 1e9 + 7;
        long ans = 0;

        for(int i = 0; i < n; i++) {
            int[][] left = new int[10][10];
            int[][] right = new int[10][10];
            for(int a = 0; a < i; a++) {
                for(int b = a + 1; b < i; b++) {
                    int x = s.charAt(a) - '0';
                    int y = s.charAt(b) - '0';
                    left[x][y]++;
                }
            }

            for(int a = i + 1; a < n; a++) {
                for(int b = a + 1; b < n; b++) {
                    int x = s.charAt(a) - '0';
                    int y = s.charAt(b) - '0';
                    right[x][y]++;
                }
            }

            for(int a = 0; a < 10; a++) {
                for(int b = 0; b < 10; b++) {
                    ans = (ans + ((long) left[a][b] * right[b][a]) % mod) % mod;
                }
            }
        }

        return (int) ans % mod;
    }
}

// TC - O(N * N * N)
// SC - O(1)

// OPTIMIAL SOLUTION

class Solution {
    public int countPalindromes(String s) {
        int n = s.length();
        int[][] left = new int[10][10];
        int[][] right = new int[10][10];

        int[] leftCount = new int[10];
        int[] rightCount = new int[10];

        int mod = (int) 1e9 + 7;
        long ans = 0;
        for(int i = 0; i < n; i++) {
            int x = s.charAt(i) - '0';
            for(int j = i + 1; j < n; j++) {
                int y = s.charAt(j) - '0';
                right[x][y]++;
            }
            rightCount[x]++;
        }
        
        for(int i = 0; i < n; i++) {
            int curr = s.charAt(i) - '0';

            rightCount[curr]--;

            for(int a = 0; a < 10; a++) {
                right[curr][a] -= rightCount[a];
            }

            for(int a = 0; a < 10; a++) {
                for(int b = 0; b < 10; b++) {
                    ans = (ans + ((long) left[a][b] * right[b][a])) % mod;
                }
            }

            for(int a = 0; a < 10; a++) {
                left[a][curr] += leftCount[a];
            }

            leftCount[curr]++;
        }

        return (int) ans;
    }
}

// TC - O(N * N)
// SC - O(1)

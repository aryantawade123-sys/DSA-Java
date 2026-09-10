class Solution {
    public boolean isPalindrome(int x) {
        // Step 1: Negative numbers can't be palindromes
        if (x < 0) {
            return false;
        }
        
        int original = x; // Store original value to compare later
        int rev = 0;
        
        // Step 2: Reverse the number
        while (x != 0) {
            int digit = x % 10;
            rev = rev * 10 + digit;
            x = x / 10;
        }
        
        // Step 3: Compare original with reversed
        return original == rev;
    }
} 
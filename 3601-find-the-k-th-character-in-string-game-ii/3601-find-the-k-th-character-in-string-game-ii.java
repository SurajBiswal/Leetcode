class Solution {
    public char kthCharacter(long k, int[] operations) {
        // Step 1: Simulate the final length of the string after operations
        long len = 1; // Initial string is "a", so length is 1
        int limitOfOperation = 0;

        // Only compute operations that affect up to the kth character
        for (int i = 0; i < operations.length; i++) {
            if (len >= k) break; // No need to go further if k is within current length
            len *= 2; // Each operation (either op=0 or op=1) doubles the string length
            ++limitOfOperation;
        }

        int increment = 0; // To count how many times we need to apply '+1' to 'a'

        // Step 2: Reverse the operations and trace back the origin of the k-th character
        for (int i = limitOfOperation - 1; i >= 0; i--) {
            if (k > len / 2) {
                // The k-th character is in the second half of the transformed string
                k -= len / 2; // Map it to the corresponding position in the original string
                
                // If the operation was 'append nextChars', we apply +1 to the character
                if (operations[i] == 1) ++increment;
            }
            // Prepare for the previous step by halving the string length
            len /= 2;
        }

        // Step 3: Starting character was 'a', apply increment (mod 26 to wrap around alphabet)
        return (char) ('a' + (increment % 26));
    }
}

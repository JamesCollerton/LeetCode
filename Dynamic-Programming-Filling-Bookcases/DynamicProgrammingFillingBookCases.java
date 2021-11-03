class Solution {
    
    public int minHeightShelves(int[][] books, int shelf_width) {
        
        int n = books.length;
        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            
            // This is the same as putting the book on the next shelf
            dp[i] = dp[i - 1] + books[i - 1][1];
            
            // Set the height/ width to the height/ width of this book
            int height = books[i - 1][1];
            int width = books[i - 1][0];
            
            // Get the first book before this one
            int j = i - 1;
            
            // Keep going back through the books before and trying
            // to move them onto this shelf
            while(j > 0 && width + books[j - 1][0] <= shelf_width) {
                
                // Alter the max height depending on the current
                // tallest book and the next book we're moving onto
                // this shelf
                height = Math.max(height, books[j - 1][1]);
                
                // Add this new book onto our shelf
                width += books[j - 1][0];
                
                //The minimum height we can achieve at book i is
                // the min of the current, or 
                dp[i] = Math.min(dp[i], height + dp[j - 1]);
                
                // Move back a book
                j--;
            }
            
        }
        return dp[n];
    }
}
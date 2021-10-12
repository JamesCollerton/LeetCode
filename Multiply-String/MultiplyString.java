class Solution {
    public String multiply(String num1, String num2) {
        // Start at the end of each string
        int m = num1.length(), n = num2.length();
        
        // Create a new solution. We know the maximum
        // size will be i + j + 1 as we know that the
        // multiplication of i and j fall there
        int[] pos = new int[m + n];

        // We go from the back to calculate the largest integers
        // first. In p2 we then need to be careful to add on as
        // we will already have a value there
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                // Here we want to make sure we add to the character that
                // has already been calculated
                int sum = mul + pos[p2];

                // For calculating the new units
                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  

        // Edge case here for when it's zero
        StringBuilder sb = new StringBuilder();
        for(int p : pos) {
            if(!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
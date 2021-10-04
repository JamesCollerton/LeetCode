class Solution {
    public int countPrimes(int n) {
       boolean[] isPrime = new boolean[n];
       for (int i = 2; i < n; i++) {
          isPrime[i] = true;
       }
       // We can end when i < sqrt(n) as multiplication
       // is symmetric
       for (int i = 2; i * i < n; i++) {
           
          // We know we can start marking off all of the multiples
          // of a number from the square, as all lower multiples will
          // already have been marked off by the previous primes
          if (isPrime[i]) {
              for (int j = i * i; j < n; j += i) {
                 isPrime[j] = false;
              }
          }
       }
        
       int count = 0;
       for (int i = 2; i < n; i++) {
          if (isPrime[i]) count++;
       }
       return count;
    }
}
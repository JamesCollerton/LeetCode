package com.trees;

public class DigitDpSolver {

    private final int MAXIMUM_INDEX = 20;
    private final int MAXIMUM_SUM = 180;
    private final int TIGHT_ON_OFF = 2;
    private final int[][][] memoisation = new int[MAXIMUM_INDEX][MAXIMUM_SUM][TIGHT_ON_OFF];

    public void solve() {
        System.out.println(digitDp(5, 12));
    }

    private int sumDigits(int index, int sum, int tight, int[] number) {

        // This is our base case. If our index moves past zero then we've
        // already looked at all of the digits in the number and we return
        // the running sum as there will be nothing more to add to it.
        if(index == -1) {
            return sum;
        }

        // Essentially this is saying have we seen this set of arguments
        // before and allows us to reuse results we already have.
        if(memoisation[index][sum][tight] != -1 && tight != 1) {
            return memoisation[index][sum][tight];
        }

        // This is the result we will be adding to in order to keep track
        // of our running total
        int result = 0;

        // If we are in a 'tight' mode then we know that we don't want
        // to exceed the value in this column of the original number. If
        // we are not then we can go all the way from 0 to 9.
        int rangeValue = (tight == 1) ? number[index] : 9;

        for(int i = 0; i <= rangeValue; i++) {

            // If the number at the current index is equal to our current
            // value in the range then we might be in 'tight' mode.
            int newTight = (number[index] == i) ? tight : 0;

            // For each of the new numbers we have created we want to go to
            // the next layer down, adding the current digit to our ongoing
            // sum
            result += sumDigits(index - 1, sum + i, newTight, number);

        }

        if(tight != 1) {
            memoisation[index][sum][tight] = result;
        }

        return result;
    }

    private int digitDp(int lowerBound, int upperBound) {

        initialiseMemoisation();

        int[] lowerBoundArr = convertIntToDigitArray(lowerBound);
        int[] upperBoundArr = convertIntToDigitArray(upperBound);

        int lowerBoundSum = sumDigits(lowerBoundArr.length - 1, 0, 1, lowerBoundArr);
        int upperBoundSum = sumDigits(upperBoundArr.length - 1, 0, 1, upperBoundArr);

        return upperBoundSum - lowerBoundSum;
    }

    // This helper method is for setting up our memoisation structure. We want all
    // of the entries to be set to -1 so we know if we have already found the result
    // for this configuration (as we know the sum will never be negative).
    private void initialiseMemoisation() {
        for(int i = 0; i < memoisation.length; i++) {
            for(int j = 0; j < memoisation[i].length; j++) {
                for(int k = 0; k < memoisation[i][j].length; k++) {
                    memoisation[i][j][k] = -1;
                }
            }
        }
    }

    // This helper method is used to convert a number to an array. For example,
    // if we get the number 1234 we make a reversed string 4321, which we then
    // use to make an array [4, 3, 2, 1]. This means we can more intuitively move
    // from left to right, whilst still starting in the units column.
    private int[] convertIntToDigitArray(int number) {
        String string = new StringBuilder(Integer.toString(number)).reverse().toString();
        int[] array = new int[string.length()];
        for (int i = 0; i < string.length(); i++)
        {
            array[i] = string.charAt(i) - '0';
        }
        return array;
    }

}

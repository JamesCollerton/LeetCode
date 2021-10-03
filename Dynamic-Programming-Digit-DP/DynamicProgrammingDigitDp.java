package com.trees;

public class DigitDpSolver {

    private final int MAXIMUM_INDEX = 20;
    private final int MAXIMUM_SUM = 180;
    private final int TIGHT_ON_OFF = 2;
    private final int[][][] memoisation = new int[MAXIMUM_INDEX][MAXIMUM_SUM][TIGHT_ON_OFF];

    public void solve() {
        System.out.println(digitDp(0, 12));
    }

    private int[] convertIntToDigitArray(int number) {
        String string = new StringBuilder(Integer.toString(number)).reverse().toString();
        int[] array = new int[string.length()];
        for (int i = 0; i < string.length(); i++)
        {
            array[i] = string.charAt(i) - '0';
        }
        return array;
    }

    private int sumDigits(int index, int sum, int tight, int[] number) {
        if(index == -1) {
            return sum;
        }

        if(memoisation[index][sum][tight] != -1 && tight != 1) {
            return memoisation[index][sum][tight];
        }

        int result = 0;

        int rangeValue = (tight == 1) ? number[index] : 9;

        for(int i = 0; i <= rangeValue; i++) {

            int newTight = (number[index] == i)? tight : 0;

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

    private void initialiseMemoisation() {
        for(int i = 0; i < memoisation.length; i++) {
            for(int j = 0; j < memoisation[i].length; j++) {
                for(int k = 0; k < memoisation[i][j].length; k++) {
                    memoisation[i][j][k] = -1;
                }
            }
        }
    }

}

package com.trees;

public class DigitDp {

//    private static int MAXIMUM_INDEX = 20;
//    private static int MAXIMUM_SUM = 180;
//    private static int TIGHT_ON_OFF = 2;
//    private static int[][][] memoisation = new int[MAXIMUM_INDEX][MAXIMUM_SUM][TIGHT_ON_OFF];

    public static void main(String[] args) {
        new DigitDpSolver().solve();
//        System.out.println(digitDp(1, 328));
    }

//    private static int[] convertIntToDigitArray(int number) {
//        String string = Integer.toString(number);
//        int[] array = new int[string.length()];
//        for (int i = 0; i < string.length(); i++)
//        {
//            array[i] = string.charAt(i) - '0';
//        }
//        return array;
//    }
//
//    private static int sumDigits(int index, int sum, int tight, int[] bound) {
//        if(index == -1) {
//            return sum;
//        }
//
//        if(memoisation[index][sum][tight] != -1 && tight != 1) {
//
//        }
//
////        if (dp[idx][sum][tight] != -1 and tight != 1)
////
////        return dp[idx][sum][tight];
////
////
////
////        long long ret = 0;
////
////
////
////        // calculating range value
////
////        int k = (tight)? digit[idx] : 9;
////
////
////
////        for (int i = 0; i <= k ; i++)
////
////        {
////
////            // caclulating newTight value for next state
////
////            int newTight = (digit[idx] == i)? tight : 0;
////
////
////
////            // fetching answer from next state
////
////            ret += digitSum(idx-1, sum+i, newTight, digit);
////
////        }
////
////
////
////        if (!tight)
////
////            dp[idx][sum][tight] = ret;
////
////
////
////        return ret;
//    }
//
//    private static int digitDp(int lowerBound, int upperBound) {
//        int[] lowerBoundArr = convertIntToDigitArray(lowerBound);
//        int[] upperBoundArr = convertIntToDigitArray(upperBound);
//
//        return 0;
//    }

}

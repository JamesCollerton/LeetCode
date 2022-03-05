package com.trees.exercises.RotationalCipher;

class Main {

    // Add any helper functions you may need here
    String rotationalCipher(String input, int rotationFactor) {

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            char toAdd;
            if(c >= 'A' && c <= 'Z') {
                toAdd = findRotatedChar(c, rotationFactor, 26, 'A');
            } else if(c >= 'a' && c <= 'z') {
                toAdd = findRotatedChar(c, rotationFactor, 26, 'a');
            } else if(Character.isDigit(c)) {
                toAdd = findRotatedChar(c, rotationFactor, 10, '0');
            } else {
                toAdd = c;
            }
            stringBuilder.append(toAdd);
        }

        return stringBuilder.toString();
    }

    private char findRotatedChar(char currentChar, int rotationFactor, int upperLimit, char lowestChar) {

        int numSteps = rotationFactor % upperLimit;
        int currentPosition = currentChar - lowestChar;
        int nextPosition = currentPosition + numSteps;

        if(nextPosition >= upperLimit) {
            nextPosition = numSteps - (upperLimit - currentPosition);
        }

        return (char) (lowestChar + nextPosition);

    }










    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new Main().run();
    }
}

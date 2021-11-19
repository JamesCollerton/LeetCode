class Solution {
    public String decodeString(String s) {
        
        char[] arr = s.toCharArray();
        
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        
        int currentNumber = 0;
        String currentString = "";
        
        for(char c: arr) {
            
            System.out.println("");
            System.out.println("Char: " + c);
            System.out.println("Number stack");
            for(int i: new ArrayList<>(numberStack)) {
                System.out.println(i);
            }
            System.out.println("String stack");
            for(String st: new ArrayList<>(stringStack)) {
                System.out.println(st);
            }
            System.out.println("Current String: " + currentString);
            System.out.println("Current Number: " + currentNumber);
            
            // If we're on a digit then the first time we reach
            // a number we need to push the current string we're on
            // onto the stack.
            if(Character.isDigit(c)) {
                
                if(!"".equals(currentString)) {
                    stringStack.push(currentString);
                }
                
                // This is in case we get subsequent numbers we need to
                // keep it increasing
                currentNumber = currentNumber * 10 + c - '0';
                
                // Reset the string for the next bracket
                currentString = ""; 
                
            // If we reached the start of a set of brackets we need to
            // put the number on the int stack
            } else if(c == '[') {
                
                numberStack.push(currentNumber);
                currentNumber = 0;
                
            // If we reached the end of the brackets then pop the last
            // number and string and repeat
            } else if(c == ']') {
                
                if(!"".equals(currentString)) {
                    stringStack.push(currentString);
                    currentString = "";
                }
                
                int repeatNumber = numberStack.pop();
                String repeatString = stringStack.pop();
                String newString = "";
                
                for(int i = 0; i < repeatNumber; i++) {
                    newString += repeatString;
                }
                
                if(!stringStack.isEmpty()) {
                    stringStack.push(stringStack.pop() + newString);
                } else {
                    stringStack.push(newString);
                }
                
                // stringStack.push(stringStack.pop() + newString);
                
            // Here we're just adding characters to a string
            } else {
                
                currentString += c;
                
            }
        }
        
        stringStack.push(currentString);
        
        StringBuilder stringBuilder = new StringBuilder();
        
        while(!stringStack.isEmpty()){
            stringBuilder.insert(0, stringStack.pop());
        }
        
        return stringBuilder.toString();
        
    }
}
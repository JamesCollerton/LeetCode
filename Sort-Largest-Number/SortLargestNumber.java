class Solution {
    public String largestNumber(int[] nums) {

        List<Integer> result = Arrays.stream(nums).boxed().sorted((aInt, bInt) -> {
            
            String a = Integer.toString(aInt);
            String b = Integer.toString(bInt);
            
            boolean aLongest = a.length() > b.length();
            
            int minLength = aLongest ? b.length() : a.length();
            
            // System.out.println("");
            // System.out.println("A: " + a);
            // System.out.println("B: " + b);
            
            if(a.length() == b.length()) {
                for(int i = 0; i < b.length(); i++) {
                    if(a.charAt(i) > b.charAt(i)) {
                        // System.out.println("A before B and same length");
                        return -1;
                    } else if(a.charAt(i) < b.charAt(i)) {
                        // System.out.println("B before A and same length");
                        return 1; 
                    }
                }
                // System.out.println("Same number!");
                return 0;
            } else if(aLongest) {
                for(int i = 0; i < b.length(); i++) {
                    if(a.charAt(i) > b.charAt(i)) {
                        // System.out.println("A before B and A longer");
                        return -1;
                    } else if(a.charAt(i) < b.charAt(i)) {
                        // System.out.println("B before A and A longer");
                        return 1; 
                    }
                }
                char aPrevChar = a.charAt(b.length() - 1);
                char aNextChar = a.charAt(b.length());
                // System.out.println("A before B, A longer, reached limit");
                return aNextChar >= aPrevChar ? -1 : 1;
            } else {
                for(int i = 0; i < a.length(); i++) {
                    if(a.charAt(i) > b.charAt(i)) {
                        // System.out.println("A before B and A shorter");
                        return -1;
                    } else if(a.charAt(i) < b.charAt(i)) {
                        // System.out.println("B before A and A shorter");
                        return 1; 
                    }
                }
                char bPrevChar = b.charAt(a.length() - 1);
                char bNextChar = b.charAt(a.length());
                return bNextChar >= bPrevChar ? 1 : -1;
            }
            
        }).collect(Collectors.toList());
        
        StringBuilder sb = new StringBuilder();
        
        for(int num: result) {
            // System.out.println(num);
            sb.append(String.valueOf(num));
        }
        
        return sb.toString();
    }
    
}
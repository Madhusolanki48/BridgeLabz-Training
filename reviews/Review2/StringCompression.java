package Review2;

public class StringCompression {
    public static void main(String[] args) {
    	//input string
        String str = "abbbbccde";
        String result="";
//        StringBuilder result = new StringBuilder();
        int count = 1;
        for (int i = 0; i<str.length(); i++) {
            //count repeated chars
            if (i<str.length()-1 && str.charAt(i)==str.charAt(i + 1)) {
                count++;
        
         } else {
                //in-built method to append
//                result.append(str.charAt(i));
//                if (count > 0){  
//                    result.append(count);
//                }
                    result = result+str.charAt(i)+count;
                    count = 1;
            }
        }
        System.out.println("Original String: "+str);
        System.out.println("Compressed String: " + result);
    }
}






//Longest Common Prefix in an Array of Strings
class Main {
    public String longestCommonPrefix(String[] str){
        // empty array check
        if (str == null || str.length == 0){ 
            return "";
        }
        String prefix = str[0]; // first string as prefix
        for (int i = 1;i < str.length;i++){
            // reduce prefix if not matching
            while (!str[i].startsWith(prefix)){ 
                prefix = prefix.substring(0, prefix.length() - 1); // remove last character
                if (prefix.isEmpty()){ // no common prefix
                    return "";
                }
            }
        }
        return prefix;
    }
}

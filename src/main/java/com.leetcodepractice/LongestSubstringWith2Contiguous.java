package com.leetcodepractice;
/*Not working for edge cases
 */

public class LongestSubstringWith2Contiguous {
    public static void main(String[] args) {
        System.out.println(new LongestSubstringWith2Contiguous().getString("aabbaabbaabbaab"));
        System.out.println(new LongestSubstringWith2Contiguous().getString("aabbaaaaabb"));
        System.out.println(new LongestSubstringWith2Contiguous().getString("ababa")); // null
        System.out.println(new LongestSubstringWith2Contiguous().getString("aabbaaaaabb"));
        System.out.println(new LongestSubstringWith2Contiguous().getString("aabbaabbaabbaa"));//aabbaabbaabb
        System.out.println(new LongestSubstringWith2Contiguous().getString("abbaabbaaabbaaa")); //abbaabbaa
    }

    private String getString(String str) {
        int longest = 0;
        int startIndex = 0;
        int maxCountOfChars = 0;
        for (int start = 0; start < str.length()-1; start++){
            for (int end = start; end < str.length(); end++){

                if (str.charAt(start) == str.charAt(end)){
                    maxCountOfChars++;

                    if (longest < end - start + 1 && maxCountOfChars%2 == 0){
                        startIndex = start;
                        longest = end - start + 1;
                    }

                    if (maxCountOfChars > 2){
                        break;
                    }

                }
                else if (str.charAt(start) != str.charAt(end) && maxCountOfChars == 2){
                    maxCountOfChars = 0;
                }
                else if (str.charAt(start) != str.charAt(end) && maxCountOfChars > 2){
                    maxCountOfChars = 0;
                    break;
                }
            }
        }

        return str.substring(startIndex, startIndex+longest);
    }
}

package com.leetcodepractice;

public class Delete3ConsecutiveStrings {

    public static void main(String[] args) {
        System.out.println(new Delete3ConsecutiveStrings().getString("aaabbaaa"));
    }

    private String getString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        int count = 1;
        for (int i=1; i< str.length(); i++){
            if (str.charAt(i-1) == str.charAt(i)){
                count++;
            }
            else{
                count = 1;
            }

            if (count < 3){
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}

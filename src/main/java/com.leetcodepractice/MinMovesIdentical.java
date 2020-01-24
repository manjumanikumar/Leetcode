package com.leetcodepractice;

public class MinMovesIdentical {
    public static void main(String[] args) {

        System.out.println(getMinMoves("baaaaaaaaab"));
        System.out.println(getMinMoves("baabab"));
        System.out.println(getMinMoves("baaabbaabbba"));
    }

    private static int getMinMoves(String str) {
        int minMoves = 0;
        int totalSeen = 0;
        for(int i=0; i<str.length();i++){
            for(int j=i+1; j<str.length(); j++){
                if(str.charAt(i) == str.charAt(j)){
                    totalSeen++;
                    if (totalSeen == 3){
                        minMoves = minMoves + 1;
                        i = j;
                        totalSeen = 0;
                    }
                }
                else{
                    break;
                }
            }
        }


        return minMoves;
    }
}

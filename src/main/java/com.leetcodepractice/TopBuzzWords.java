package com.leetcodepractice;

import java.util.*;
import java.util.stream.Collectors;

public class TopBuzzWords {

    public static void main(String[] args) {
        int numToys = 6, topToys = 2, numQuotes = 6;

       List<String> toys = Arrays.asList("elmo", "elsa", "legos", "drone", "tablet", "warcraft");

        List<String> quotes = Arrays.asList(
        "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "The new Elmo dolls are super high quality",
                "Expect the Elsa dolls to be very popular this year, Elsa!",
                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season");

        System.out.println(new TopBuzzWords().getTopBuzzWords(numToys, topToys, numQuotes, quotes, toys));
    }

    public List<String> getTopBuzzWords(int numToys, int topToys, int numQuotes, List<String> quotes, List<String> toys){

        Set<String> toySet = new HashSet<>(toys);
        Map<String, Wordstats> stringWordstatsMap = new HashMap<>();
        for (String toy : toys){
            stringWordstatsMap.put(toy, new Wordstats(toy, 0));
        }
        PriorityQueue<Wordstats> pq = new PriorityQueue<>(new Comparator<Wordstats>() {
            @Override
            public int compare(Wordstats o1, Wordstats o2) {
                if (o1.countTimes !=  o2.countTimes)
                    return Integer.compare(o2.countTimes, o1.countTimes);
                else if(o1.quoteIds.size() != o2.quoteIds.size())
                    return Integer.compare(o2.quoteIds.size(), o1.quoteIds.size());
                else
                    return o1.word.compareTo(o2.word);
            }
        });

      for(int i=0; i<quotes.size(); i++){
          String[] words = quotes.get(i).replace("[^a-zA-Z]", "").toLowerCase().split(" ");
          for (String word : words){
              if(toys.contains(word)){
                  stringWordstatsMap.get(word).countTimes++;
                  stringWordstatsMap.get(word).quoteIds.add(i);
              }
          }
      }

      pq.addAll(stringWordstatsMap.values());

     List<String> result = new ArrayList<>();

     while (!pq.isEmpty() && topToys > 0){
         result.add(pq.poll().word);
         topToys -- ;
     }

        return result;
    }

    public class Wordstats{
        String word;
        int countTimes;
        Set<Integer> quoteIds;
        public Wordstats(String word, int countTimes){
            this.word = word;
            this.countTimes = countTimes;
            this.quoteIds = new HashSet<>();

        }
    }

}

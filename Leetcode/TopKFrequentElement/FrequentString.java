package Leetcode.TopKFrequentElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequentString {
    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 3;

        Map<String, Integer> numCount = new HashMap<>();
        for (String word : words)
            numCount.put(word, numCount.getOrDefault(word, 0)+1);

        class Pair {
            String word;
            int count;
            public Pair(String word, int count) {
                this.count = count;
                this.word = word;
            }
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.count == b.count ? a.word.compareTo(b.word) : b.count - a.count);

        for (Map.Entry<String, Integer> entry : numCount.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        List<String> res = new ArrayList<>(k);
        while (!pq.isEmpty() && k-->0)
            res.add(pq.poll().word);
        for(String j : res) System.out.println(j);
    }
}

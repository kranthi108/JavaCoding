package org.example;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public static void main(String[] args) {
        Set<String> D = new HashSet<String>();
        D.add("poon");
        D.add("plee");
        D.add("same");
        D.add("poie");
        D.add("plie");
        D.add("poin");
        D.add("plea");
        String start = "toon";
        String target = "plea";
        System.out.print("Length of shortest chain is: "
                + shortestChainLength(start, target, D));
    }
    static int shortestChainLength(String start, String end, Set<String> dict) {
        if(start == end)
            return 0;
        if(!dict.contains(end))
            return 0;
        int level = 0, wordLength = start.length();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            System.out.println("dfa ");
            ++level; // reconsider
            int qSize = queue.size();
            for(int i=0; i<qSize; i++) {
                char[] word = queue.remove().toCharArray();
                for(int j=0; j<wordLength; j++) {
                    char originalCharecter = word[j];
                    for(char c = 'a'; c<'z'; c++) {
                        word[j] = c;
                        if(String.valueOf(word).equals(end)) {
                            return level + 1;
                        }
                        if(!dict.contains(String.valueOf(word))) {
                            continue;
                        }
                        dict.remove(String.valueOf(word));
                        queue.add(String.valueOf(word));
                    }
                    word[j] = originalCharecter;
                }
            }
        }
        return 0;
    }
}
package org.example;

import java.util.*;

public class Sample {
    @Override
    public int hashCode() {
        return 12;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = {5,10,15,20};
        TopVotedCandidate s = new TopVotedCandidate(a,b);
//        HashMap<Integer, Integer> s = new HashMap<>();
//        s.put(1,1);
//        boolean k = s.get(1)>=s.get(-1);
//        System.out.printf(String.valueOf(k));
    }
}

class TopVotedCandidate {
    TreeMap<Integer, Integer> timedWinner;
    int lead;
    public TopVotedCandidate(int[] persons, int[] times) {
        int n = times.length;
        lead = -1;
        timedWinner = new TreeMap();
        Map<Integer, Integer> votes = new HashMap();
        for(int i=0; i<n; i++){
            votes.put(persons[i], votes.getOrDefault(persons[i], 0)+1);
            if(i==0 || votes.get(persons[i])>=votes.get(lead)){
                lead = persons[i];
            }
            timedWinner.put(times[i], lead);
        }
    }

    public TopVotedCandidate() {

    }

    public int q(int t) {
        return timedWinner.floorEntry(t).getValue();
    }
}

package GP;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class HitCounter {
    private Map<String, Deque<Integer>> eventTimeStamps;
    public HitCounter() {
        eventTimeStamps = new HashMap<>();
    }
    public void insertElement(String eventName, int timestamp) {
        eventTimeStamps.putIfAbsent(eventName, new LinkedList<>());
        eventTimeStamps.get(eventName).addLast(timestamp);
    }

    public void printCountByElementName() {
        for(Map.Entry<String, Deque<Integer>> entry: eventTimeStamps.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().size());
        }
    }
    public void printCountByElementInLast5Minutes(int currentTime) {

        for(Map.Entry<String, Deque<Integer>> entry : eventTimeStamps.entrySet()) {
            Deque<Integer> timeStamps = entry.getValue();
            while(!timeStamps.isEmpty() && timeStamps.peekFirst() <= currentTime - 300) {
                timeStamps.pollFirst();
            }
            System.out.println(entry.getKey() + " " + timeStamps.size());
        }
    }

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();
        counter.insertElement("event1", 100);
        counter.insertElement("event1", 200);
        counter.insertElement("event2", 300);
        counter.insertElement("event2", 400);
        counter.printCountByElementName();
        counter.printCountByElementInLast5Minutes(500);
        System.out.println();
        counter.printCountByElementName();

    }
}
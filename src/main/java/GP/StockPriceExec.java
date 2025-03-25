package GP;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class StockPriceExec {
    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        System.out.println(stockPrice.current.price);
        stockPrice.update(1,10);
        stockPrice.update(2,5);
        System.out.println(stockPrice.maximum());
        System.out.println(stockPrice.minimum());
        System.out.println(stockPrice.current());
    }
}
class Stock{
    int price;
    int timestamp;
    public Stock(){}
    public Stock(int timestamp, int price){
        this.timestamp = timestamp;
        this.price = price;
    }
}
class StockPrice {
    PriorityQueue<Stock> maxHeap;
    PriorityQueue<Stock> minHeap;
    TreeMap<Integer, Integer> map;
    Stock current;

    public StockPrice() {
        maxHeap = new PriorityQueue<>((o1,o2) -> (o2.price - o1.price));
        minHeap = new PriorityQueue<>((o1,o2) -> (o1.price - o2.price));
        map = new TreeMap<>();
        current = new Stock();
    }

    public void update(int timestamp, int price) {
        Stock stock = new Stock(timestamp, price);
        if(timestamp >= current.timestamp)
            current = stock;
        minHeap.add(stock);
        maxHeap.add(stock);
        map.put(timestamp,price);
    }

    public int current() {
        return current.price;
    }

    public int maximum() {
        while(maxHeap.peek().price != map.get(maxHeap.peek().timestamp)){
            maxHeap.poll();//remove outdated data
        }
        return maxHeap.peek().price;
    }

    public int minimum() {
        while(minHeap.peek().price != map.get(minHeap.peek().timestamp)){
            minHeap.poll();//remove outdated data
        }
        return minHeap.peek().price;
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */

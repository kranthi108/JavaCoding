package DesignPatterns.Observer.Observable;

import DesignPatterns.Observer.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable{
    public List<NotificationAlertObserver> observerList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for(NotificationAlertObserver observer: observerList) {
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newAddedStock) {
        if(stockCount ==0) {
            notifySubscribers();
        }
        stockCount = stockCount+newAddedStock;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}

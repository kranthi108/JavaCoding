package DesignPatterns.Observer.Observable;

import DesignPatterns.Observer.Observer.NotificationAlertObserver;

public interface StockObservable {
    public void add(NotificationAlertObserver observer);
    public void remove(NotificationAlertObserver observer);
    public void notifySubscribers();
    public void setStockCount(int newAddedStock);
    public int getStockCount();
}

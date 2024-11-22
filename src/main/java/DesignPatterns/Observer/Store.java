package DesignPatterns.Observer;

import DesignPatterns.Observer.Observable.IphoneObservableImpl;
import DesignPatterns.Observer.Observable.StockObservable;
import DesignPatterns.Observer.Observer.EmailAlertObserverImpl;
import DesignPatterns.Observer.Observer.MobileAlertObserverImpl;
import DesignPatterns.Observer.Observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {
        StockObservable iphoneObservable = new IphoneObservableImpl();
        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("krsihna@gmail.com", iphoneObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("rama@gmail.com", iphoneObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("hare@gmail.com", iphoneObservable);
        iphoneObservable.add(observer1);
//        iphoneObservable.add(observer2);
        iphoneObservable.add(observer3);
        iphoneObservable.setStockCount(3);
    }
}

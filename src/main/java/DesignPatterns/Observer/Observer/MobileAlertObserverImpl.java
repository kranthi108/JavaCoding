package DesignPatterns.Observer.Observer;

import DesignPatterns.Observer.Observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {
    String userName;
    StockObservable observer;
    public MobileAlertObserverImpl(String userName, StockObservable observer) {
        this.userName = userName;
        this.observer = observer;
    }

    @Override
    public void update() {
        sendMobileAlert("product is available hurry up", userName);
    }
    public void sendMobileAlert(String note, String name) {
        System.out.println("message has been sent to " + userName);
    }
}

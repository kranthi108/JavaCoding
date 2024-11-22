package DesignPatterns.Observer.Observer;

import DesignPatterns.Observer.Observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {
    String email;
    StockObservable observable;
    public EmailAlertObserverImpl(String email, StockObservable observable) {
        this.observable = observable;
        this.email = email;
    }
    @Override
    public void update() {
        sendMail(email, "Product is in stock, Hurry up");
    }

    public void sendMail(String email, String note) {
        System.out.println(" Email sent to  " + email);
    }
}

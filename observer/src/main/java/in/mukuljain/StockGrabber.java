package in.mukuljain;

import java.util.ArrayList;

public class StockGrabber implements Subject {

    private ArrayList<Observer> observers;
    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;

    public StockGrabber() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);
        System.out.println("Observer " + (observerIndex + 1) + " deleted");
        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(observer -> observer.update(ibmPrice, aaplPrice, googPrice));
    }

    public void setIbmPrice(double newIbmPrice) {
        this.ibmPrice = newIbmPrice;
        notifyObserver();
    }

    public void setAaplPrice(double newAaplPrice) {
        this.aaplPrice = newAaplPrice;
        notifyObserver();
    }

    public void setGoogPrice(double newGoogPrice) {
        this.googPrice = newGoogPrice;
        notifyObserver();
    }
}

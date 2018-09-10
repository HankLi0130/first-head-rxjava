package tw.hankli.ch2_1;

import java.util.ArrayList;


public class WeatherSubject implements Subject {

    private ArrayList<Observer> observers;

    public WeatherSubject() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {

        int i = observers.indexOf(o);

        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObserver(String str) {
        for (Observer observer : observers) {
            observer.update(str);
        }
    }
}

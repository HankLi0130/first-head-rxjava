package tw.hankli.ch2_1;

public interface Subject {

    void registerObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObserver(String str);
}

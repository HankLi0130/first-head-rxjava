package tw.hankli.ch2_1;

public class Ch2_1Test {

    public static void main(String[] args) {

        Subject weather = new WeatherSubject();

        Observer user1 = new WeatherObserver("小王");

        Observer user2 = new WeatherObserver("小李");

        weather.registerObserver(user1);

        weather.registerObserver(user2);

        weather.notifyObserver("台北市中山區 目前溫度：28度");
    }
}

package tw.hankli.ch2_1;

public class WeatherObserver implements Observer {

    private String name;

    public WeatherObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String str) {
        System.out.println(name + " 接收到 " + str);
    }
}

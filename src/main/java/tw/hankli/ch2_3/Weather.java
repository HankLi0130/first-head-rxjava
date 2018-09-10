package tw.hankli.ch2_3;

public class Weather {

    private String location;

    private int temperature;

    private double humidity;

    public Weather(String location, int temperature, double humidity) {
        this.location = location;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getLocation() {
        return location;
    }

    public int getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    @Override
    public String toString() {
        return "地區：" + location + ", 溫度：" + temperature + ", 濕度：" + getHumidity();
    }
}

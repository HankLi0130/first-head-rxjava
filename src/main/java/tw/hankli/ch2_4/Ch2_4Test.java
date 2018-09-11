package tw.hankli.ch2_4;

import tw.hankli.ch2_3.Weather;

import java.util.ArrayList;
import java.util.List;

public class Ch2_4Test {

    public static void main(String[] args) {

        List<Weather> weathers = new ArrayList<>();

        weathers.add(new Weather("中山區", 28, 0.5));
        weathers.add(new Weather("信義區", 30, 0.1));
        weathers.add(new Weather("大安區", 29, 0.9));

        weathers.stream()
                .filter((weather) -> weather.getLocation().equals("中山區"))
                .forEach((weather) -> System.out.println(weather.toString()));
    }
}

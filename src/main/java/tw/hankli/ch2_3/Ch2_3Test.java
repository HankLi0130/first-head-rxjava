package tw.hankli.ch2_3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ch2_3Test {

    public static void main(String[] args) {

        List<Weather> weathers = new ArrayList<>();

        weathers.add(new Weather("中山區", 28, 0.5));
        weathers.add(new Weather("信義區", 30, 0.1));
        weathers.add(new Weather("大安區", 29, 0.9));

        weathers.stream()
                .filter(new Predicate<Weather>() {
                    @Override
                    public boolean test(Weather weather) {
                        return weather.getLocation().equals("中山區");
                    }
                })
                .forEach(new Consumer<Weather>() {
                    @Override
                    public void accept(Weather weather) {
                        System.out.println(weather.toString());
                    }
                });
    }
}

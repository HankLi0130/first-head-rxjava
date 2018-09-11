package tw.hankli.ch2_2;

public class Ch2_2Test {

    public static void main(String[] args) {

        String[] weathers = new String[]{"中山區 28度", "信義區 30度", "大安區 29度"};

        Iterator iterator = new StringArrayIterator(weathers);

        while (iterator.hasNext()) {

            System.out.println(iterator.next());

        }
    }
}

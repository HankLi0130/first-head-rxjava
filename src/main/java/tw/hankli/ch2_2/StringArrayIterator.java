package tw.hankli.ch2_2;

public class StringArrayIterator implements Iterator {

    private String[] stringArr;

    private int position;

    public StringArrayIterator(String[] stringArr) {
        this.stringArr = stringArr;
    }

    @Override
    public boolean hasNext() {
        return position < stringArr.length && stringArr[position] != null;
    }

    @Override
    public Object next() {

        String str = stringArr[position];

        position += 1;

        return str;
    }
}

package home.yehor.Logic;

public class HashEntry {

    private int key;
    private long value;

    HashEntry(int key, long value) {
        this.key = key;
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }
}
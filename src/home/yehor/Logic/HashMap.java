package home.yehor.Logic;

public class HashMap {

    private int capacity;
    private final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final int MAXIMUM_CAPACITY = 711720956;
    private final int MAX_SEARCH_ITERATION = (int) Math.pow(Integer.MAX_VALUE, 0.5);
    private int size;
    private HashEntry[] table;

    public HashMap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity should be positive!");
        }
        if (capacity >= MAXIMUM_CAPACITY) {
            throw new IllegalArgumentException("Capacity too big!");
        }
        this.capacity = capacity;
        table = new HashEntry[capacity];
    }

    public Long put(int key, long value) {
        int iteration = 0;
        double loadFactor = (double) (size + 1) / capacity;
        if (loadFactor >= DEFAULT_LOAD_FACTOR) {
            rehash();
        }
        int hashedKey = getEntryPos(key, iteration);
        while (table[hashedKey] != null) {
            if (key == table[hashedKey].getKey()) {
                long oldValue = table[hashedKey].getValue();
                table[hashedKey].setValue(value);
                return oldValue;
            }
            iteration++;
            hashedKey = getEntryPos(hashedKey, iteration);
        }
        table[hashedKey] = new HashEntry(key, value);
        size++;
        return null;
    }

    public Long get(int key) {
        int iteration = 0;
        int hashedKey = getEntryPos(key, iteration);

        // As we don't have delete() method implemented, there is no chance that we won't find existing element by
        // breaking the while() loop because of having previous element as deleted (null)
        //
        // If delete() method was present - this method would have gotten a refactoring
        while (table[hashedKey] != null) {
            if (key == table[hashedKey].getKey()) {
                return table[hashedKey].getValue();
            }
            iteration++;
            hashedKey = getEntryPos(hashedKey, iteration);
        }
        return null;
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    private int getEntryPos(int key, int searchIteration) {
        if (searchIteration > MAX_SEARCH_ITERATION) {
            rehash();
        }
        return (Integer.hashCode(key) % capacity + (int) Math.pow(searchIteration, 2) % capacity) % capacity;
    }

    private void rehash() {
        if (capacity >= MAXIMUM_CAPACITY / 2) {
            throw new NumberFormatException("HashMap too big, can't insert more elements!");
        }
        capacity *= 2;
        HashEntry[] temp = table;
        table = new HashEntry[capacity];
        size = 0;
        for (HashEntry hashEntry : temp) {
            if (hashEntry != null) {
                put(hashEntry.getKey(), hashEntry.getValue());
            }
        }
    }
}
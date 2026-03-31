package Tuto3;
public class ArrayBag<T> implements BagInterface<T> {

    private final T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;

    public ArrayBag() {
        bag=(T[]) new Object[DEFAULT_CAPACITY];
        numberOfEntries=0;
    }

    @SuppressWarnings("unchecked")
    public ArrayBag(int capacity) {
        bag= (T[]) new Object[capacity];
        numberOfEntries=0;
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries==0;
    }

    @Override
    public boolean isFull() {
        return numberOfEntries>=bag.length;
    }

    @Override
    public boolean add(T newEntry) {
        if (isFull()) {
            return false;
        }
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        }
        T result = bag[numberOfEntries - 1];
        bag[numberOfEntries - 1] = null; 
        numberOfEntries--;
        return result;
    }

    @Override
    public boolean remove(T anEntry) {
        int index = getIndexOf(anEntry);
        if (index > -1) {
            bag[index] = bag[numberOfEntries - 1];
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int count = 0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (anEntry.equals(bag[i])) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean contains(T anEntry) {
        return getIndexOf(anEntry) > -1;
    }

    @Override
    public T[] toArray() {
        T[] result = (T[]) new Object[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++) {
            result[i] = bag[i];
        }
        return result;
    }

    private int getIndexOf(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (anEntry.equals(bag[i])) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public BagInterface<T> union(BagInterface<T> otherBag) {
        int combinedSize = this.getCurrentSize() + otherBag.getCurrentSize();
        BagInterface<T> everything = new ArrayBag<>(combinedSize);

        T[] leftItems = this.toArray();
        for (T item : leftItems) {
            everything.add(item);
        }

        T[] rightItems = otherBag.toArray();
        for (T item : rightItems) {
            everything.add(item);
        }
        return everything;
    }
    
    @Override
    public BagInterface<T> intersection(BagInterface<T> otherBag) {
        int minCapacity = Math.min(this.getCurrentSize(), otherBag.getCurrentSize());
        BagInterface<T> resultBag = new ArrayBag<>(minCapacity);
        BagInterface<T> tempOtherBag = new ArrayBag<>(otherBag.getCurrentSize());
        T[] otherArray = otherBag.toArray();
        for (T item : otherArray) {
            tempOtherBag.add(item);
        }
        T[] thisArray = this.toArray();
        for (T item : thisArray) {
            if (tempOtherBag.contains(item)) {
                resultBag.add(item);
                tempOtherBag.remove(item);
            }
        }
        return resultBag;
    }
    
    @Override
    public BagInterface<T> difference(BagInterface<T> otherBag) {
        BagInterface<T> resultBag = new ArrayBag<>(this.getCurrentSize());
        T[] thisArray = this.toArray();
        for (T item : thisArray) {
            resultBag.add(item);
        }
        T[] otherArray = otherBag.toArray();
        for (T item : otherArray) {
            if (resultBag.contains(item)) {
                resultBag.remove(item);
            }
        }
        return resultBag;
    }
}

class Tester{

    public static void main(String[] args) {
        BagInterface<String> bag1 = new ArrayBag<>();
        BagInterface<String> bag2 = new ArrayBag<>();
        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "another string"};

        System.out.println("Filling bag1...");
        testAdd(bag1, contentsOfBag1);
        System.out.println("Filling bag2...");
        testAdd(bag2, contentsOfBag2);

        System.out.println("\n--- Initial Bags ---");
        System.out.print("bag1: ");
        displayBag(bag1);
        System.out.print("bag2: ");
        displayBag(bag2);

        System.out.println("\n--- Testing Union ---");
        BagInterface<String> bag3 = bag1.union(bag2);
        System.out.print("bag3 (bag1 union bag2): ");
        displayBag(bag3);

        System.out.println("\n--- Testing Intersection ---");
        BagInterface<String> bag4 = bag1.intersection(bag2);
        System.out.print("bag4 (bag1 intersection bag2): ");
        displayBag(bag4);

        System.out.println("\n--- Testing Difference ---");
        BagInterface<String> bag5 = bag1.difference(bag2);
        System.out.print("bag5 (bag1 difference bag2): ");
        displayBag(bag5);
    }

    /**
     * Tests the add method by filling a bag with an array of strings.
     */
    private static void testAdd(BagInterface<String> aBag, String[] content) {
        for (String item : content) {
            if (aBag.add(item)) {
                System.out.print(item + " ");
            } else {
                System.out.print("\nUnable to add " + item + " (Bag is full)");
            }
        }
        System.out.println();
    }

    /**
     * Tests getCurrentSize and toArray while displaying bag contents.
     */
    private static void displayBag(BagInterface<String> aBag) {
        System.out.println("The bag contains " + aBag.getCurrentSize() + " string(s):");
        Object[] bagArray = aBag.toArray();
        for (Object item : bagArray) {
            System.out.print(item + " ");
        }
        System.out.println("\n");
    }
}
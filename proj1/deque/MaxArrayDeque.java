package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    Comparator<T> comparator;

    public MaxArrayDeque() {
        super();
    }

    public MaxArrayDeque(Comparator<T> c) {
        super();
        comparator = c;
    }

    public T max() {
        return maxBy(comparator);
    }

    public T max(Comparator<T> c) {
        return maxBy(c);
    }

    private T maxBy(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T returnItem = get(0);
        for (int i = 1; i < size(); i++) {
            if (c.compare(returnItem, get(i)) < 0) {
                returnItem = get(i);
            }
        }
        return returnItem;
    }
}

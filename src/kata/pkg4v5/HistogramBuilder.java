package kata.pkg4v5;

import java.util.ArrayList;

public class HistogramBuilder<T> {
    
    private final ArrayList <T> items;
    
    public HistogramBuilder (ArrayList<T> items){
        this.items = items;
    }
    
    public <A> Histogram<A> build(Attribute <T,A> attribute){
        Histogram<A> histogram = new Histogram<>();
        for (T item : items) {
            A value = attribute.get(item);
            histogram.increment(value);
        }
        
        return histogram;
    }
}
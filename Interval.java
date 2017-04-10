
public class Interval<T extends Comparable<T>> implements IntervalADT<T> {
    private T start;
    private T end;  
    private String label;

    public Interval(T start, T end, String label) {
        this.start = start;
        this.end = end;
        this.label = label;
    }

    @Override
    public T getStart() {
        return start;
    }

    @Override
    public T getEnd() {
        return end;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public boolean overlaps(IntervalADT<T> other) {
        if (this.getEnd < other.getStart() || other.getEnd < this.getStart()) 
            return false; //TODO Change the > < to CompareTo
        return true; 
    }

    @Override
    public boolean contains(T point) {
        if (point >= this.getStart() && point <= this.getEnd()) //TODO change the< > to commpare to
            return true;
        return false;
    }

    @Override
    public int compareTo(IntervalADT<T> other) {
        if (this.getStart().compareTo(other.getStart.()) == 0) {
            if (this.getEnd().compareTo(other.getEnd.()) == 0) {
                return 0; 
            } else {
                if(this.getEnd().compareTo(other.getEnd()) < 0) 
                    return  -1;
                else 
                    return 1;
            }       
        } else {
            if (this.getStart().compareTo(other.getStart()) < 0)
                return  -1;
            else
                return 1;
        }

    }
}






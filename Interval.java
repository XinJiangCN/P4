
public class Interval<T extends Comparable<T>> implements IntervalADT<T> {
	
	// TODO declare any needed data members
	private T start;
	private T end;
	private String label;

	public Interval(T i, T j, String string) {
		// TODO Auto-generated constructor stub
		this.start = i;
		this.end = j;
		this.label = string;
	}

	@Override
	public T getStart() {
		// TODO Auto-generated method stub
		return start;
	}

	@Override
	public T getEnd() {
		// TODO Auto-generated method stub
		return end;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return label;
	}

	@Override
	public boolean overlaps(IntervalADT<T> other) {
		// TODO Auto-generated method stub
		if(end.compareTo(other.getStart()) < 0) {
			return false;
		} else if (other.getEnd().compareTo(start) < 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean contains(T point) {
		// TODO Auto-generated method stub
		if(start.compareTo(point) < 0 && end.compareTo(point) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(IntervalADT<T> other) {
		// TODO Auto-generated method stub
		if(start.compareTo(other.getStart()) == 0) {
			return start.compareTo(other.getStart());
		} else {
			return end.compareTo(other.getEnd());
		}
	}

	@Override
	public String toString() {
		String printFormat = label;
		printFormat += " [" + start + ", " + end +"]";
		return printFormat;
	}
}

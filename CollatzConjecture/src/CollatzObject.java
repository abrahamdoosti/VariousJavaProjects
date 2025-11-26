import java.util.ArrayList;
import java.util.List;

public class CollatzObject {

	private long startingNumber;
	private long collatzLength;
	private long highestValue;
	private List<Long> series=new ArrayList();

	public CollatzObject(long startingNumber, long collatzLength, long highestValue, List<Long> series) {
		this.startingNumber = startingNumber;
		this.collatzLength = collatzLength;
		this.highestValue = highestValue;
		this.series=series;
	}
	public long getStartingNumber() {
		return startingNumber;
	}

	public void setStartingNumber(long startingNumber) {
		this.startingNumber = startingNumber;
	}

	public long getCollatzLength() {
		return collatzLength;
	}

	public void setCollatzLength(long collatzLength) {
		this.collatzLength = collatzLength;
	}

	public long getHighestValue() {
		return highestValue;
	}

	public void setHighestValue(long highestValue) {
		this.highestValue = highestValue;
	}
	

	public List<Long> getSeries() {
		return series;
	}
	public void setSeries(List<Long> series) {
		this.series = series;
	}
	@Override
	public String toString() {
		return "CollatzObject [startingNumber=" + startingNumber + ", collatzLength=" + collatzLength + ", highestValue="
				+ highestValue + "]";
	}
	
	

}

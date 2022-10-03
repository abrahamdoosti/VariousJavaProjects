
public class Bracket {
	
	private float min=0f;
	private float max=0f;	
	private float percent=0f; 
	
	public Bracket() {

	}

	public Bracket(float min, float max,float percent) {
		this.min = min;
		this.max = max;
		this.percent=percent;
	}
	
	public float calculateBracketTax(float salary) {
		if (salary < min) {
			return 0f;
		} else if (max == -1.0) {
			if (salary < min) {
				return 0f;
			} else {
				return (salary - min) * (percent / 100);
			}
		} else if (salary >= min && salary <= max) {
			return (salary - min) * (percent / 100);
		} else {
			return (max - min) * (percent / 100);
		}

	}

	public float getMin() {
		return min;
	}

	public void setMin(float min) {
		this.min = min;
	}

	public float getMax() {
		return max;
	}

	public void setMax(float max) {
		this.max = max;
	}

	public float getPercent() {
		return percent;
	}

	public void setPercent(float percent) {
		this.percent = percent;
	}

}

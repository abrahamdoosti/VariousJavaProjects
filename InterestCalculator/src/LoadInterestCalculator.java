
public class LoadInterestCalculator {
	
	public static double computeMonthlyPayment(double principal,double interest,int months,APR aprMode) {
		if(aprMode!=null&&aprMode==APR.MONTH) {
			interest=interest/12;
			return (calcNominator(principal, interest, months)/calcDenominator(interest, months));
		}	
		else {
			months=months/12;
			return (calcNominator(principal, interest, months)/calcDenominator(interest, months));
		}
	}
	
	public static double calcNominator(double principal, double interest, int months) {
		return Math.pow((1+interest),months)*principal;
	}
	
	public static double calcDenominator(double interest,int months) {
		double sum=0.0;
		int i=1;
		while(months>=i) {
			sum=sum+Math.pow((1+interest),(months-i));
			i=i+1;
		}
		return sum;
	}

}

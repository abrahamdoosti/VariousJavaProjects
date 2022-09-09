
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int months=15*12;
      double principal=270000;
      //interest per year
      double interest=0.035;
      //is the interest calculated per year or month
      APR aprMode=APR.MONTH;
      System.out.println(LoadInterestCalculator.computeMonthlyPayment(principal, interest, months, aprMode));
	}

}

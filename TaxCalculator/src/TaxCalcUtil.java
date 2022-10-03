import java.util.ArrayList;
import java.util.List;

public class TaxCalcUtil {
	
	private List<Bracket> brackets=new ArrayList<>();
	
	
	public TaxCalcUtil() {
		//single filing status brackets
		brackets.add(new Bracket(0,9700,10));
		brackets.add(new Bracket(9701,39475,12));
		brackets.add(new Bracket(39476,84200,22));
		brackets.add(new Bracket(84201,160725,24));
		brackets.add(new Bracket(160726,204100,32));
		brackets.add(new Bracket(204101,510300,35));
		brackets.add(new Bracket(510301,-1,37));
		
		//married filing jointly status brackets
		/*brackets.add(new Bracket(0,19400,10));
		brackets.add(new Bracket(19401,78950,12));
		brackets.add(new Bracket(78951,168400,22));
		brackets.add(new Bracket(168401,321450,24));
		brackets.add(new Bracket(321451,408200,32));
		brackets.add(new Bracket(408201,612350,35));
		brackets.add(new Bracket(612351,-1,37));*/
		
	}
	public static void main(String[] args) {
		TaxCalcUtil taxCalcUtil=new TaxCalcUtil();
		float salary=33000;
		System.out.println(taxCalcUtil.calculateTax(salary));
	}
	
	public float calculateTax(float salary) {
		float tax=0;
		for(Bracket b:brackets) {
			tax=tax+b.calculateBracketTax(salary);
		}
		return tax;
	}
	
	

}

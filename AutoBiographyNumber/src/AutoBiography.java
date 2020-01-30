
public class AutoBiography {
	
	
	public static boolean isAutoBiography(long number){
		long digit=0;
		long temp=number;
		int counter=0;
		if(number==0){
			return false;
		}
		while(temp>0){
			digit=temp%10;
			temp=temp/10;
			counter++;
			
		}
		
		long[] digits=new long[counter];
		int index=counter-1;
		temp=number;
		while(temp>0){
			digits[index]=temp%10;
			temp=temp/10;
			index--;
			
		}
		return checkNumber(digits);
		
	}
	
	private static boolean checkNumber(long[] digits){
		long[] tempDigits=digits;
		for(int i=0;i<digits.length;i++){
			int count=0;
			for(int j=0;j<digits.length;j++){
				if(digits[j]==i){
					count++;
				}
			}
			if(count!=digits[i]){
				return false;
			}
			
		}
		return true;
	}
	
	

}

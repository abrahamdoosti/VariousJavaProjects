
public class POE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1={1,8,3,7,10,2};
		int[] array2={1,5,3,1,1,1,1,1,1};
		int[] array3={2,1,1,1,2,1,7};
		int[] array4={1,2,3};
		int[] array5={3,4,5,10};
		System.out.println(getPOE(array1));
		System.out.println(getPOE(array2));
		System.out.println(getPOE(array3));
		System.out.println(getPOE(array4));
		System.out.println(getPOE(array5));
		

	}
	
	public static int getPOE(int[] myArray){
		for(int i=0;i<myArray.length;i++){
			if(isPOE(i, myArray)){
				return i;
			}
		}
		return -1;
		
	}
	
	public static boolean isPOE(int val,int[] myArray){
		int before=-1;
		
		int after=-1;
		
		for(int i=0;i<val;i++){
			before=myArray[i]+before;
		}
		
		for(int i=val+1;i<myArray.length;i++){
			after=myArray[i]+after;
		}
		
		if(before==after&&(before!=-1&&after!=-1)){
			return true;
		}
		else{
			return false;
		}
		
		
	}
	

}

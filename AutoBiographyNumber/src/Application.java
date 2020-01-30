
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] nums = { 0, 1, 1210, 3211000, 23456,6210001000l};
	/*	for (long num : nums) {
			boolean isAuto = AutoBiography.isAutoBiography(num);
			if (isAuto) {
				System.out.println(num + " is autobiography");
			} else {
				System.out.println(num + " is NOT autobiography");
			}
		}*/
		
		for (long num=0;num<9999999999l;num++) {
			boolean isAuto = AutoBiography.isAutoBiography(num);
			if (isAuto) {
				System.out.println(num + " is autobiography");
			}/* else {
				System.out.println(num + " is NOT autobiography");
			}*/
		}

	}

}

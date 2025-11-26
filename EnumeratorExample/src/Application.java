
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student= new Student("abebe","kebede",Weekday.MONDAY);
        System.out.println(student);
        
        for(Weekday day: Weekday.values()) {
        	System.out.println(day);
        	System.out.println("day is, "+day.getSelectedDay());
        }
	}

}

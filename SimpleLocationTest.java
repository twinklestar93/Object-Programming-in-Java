public class SimpleLocationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleLocation ucsd = 
				new SimpleLocation(32.9, -117.2);
		SimpleLocation lima = 
				new SimpleLocation(-12.0, -77.0);
		
		// allow the user to change the location 
		lima.setLatitude(-12.04);
		lima.setLontitude(-77.13);
		
		System.out.println(lima.getlatitude() + ", " + ucsd.getLontitude());
	}

}

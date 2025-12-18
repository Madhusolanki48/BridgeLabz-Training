
public class VolumeOfEarth {
	 public static void main(String[] args) {
	        double r = 6378;    //radius of earth in km
	        double volumeInKm = (4/3) * Math.PI * r * r * r;  //volume in km^3
	        double volumeInMiles = volumeInKm * 0.239913;    //volume in miles^3
	        System.out.println("The volume of earth in cubic kilometers is " +
	                           volumeInKm + " and cubic miles is " + volumeInMiles);
	 }

}

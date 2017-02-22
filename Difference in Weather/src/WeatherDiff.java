import java.io.*;
import java.util.*;
public class WeatherDiff {
	public static void main (String [] args) throws FileNotFoundException{
	Scanner input = new Scanner (new File("./data/weather.txt"));
	double first = input.nextDouble();
	double second = input.nextDouble();
	for(int i=0;i<7;i++){
		System.out.println(first + " to " + second + ", change = " + (second-first));
	}
	}
}
	
	


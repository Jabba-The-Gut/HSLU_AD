package ch.hslu.ad.sw04.D3.Aufg5;

public class DataGenerator {
	
	public static String[] testData(int size){
		final String[] data = new String[size];
		for(int i = 0; i < data.length; i++) {
			data[i] = new String("a*c");
		}
		return data;
	}

}

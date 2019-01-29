package helloworld;

public class DataPoints {


	
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		
		double score_data[] = {10.1, 11.2, 12.3, 13.4, 14.5};
		int i, x;
		
		System.out.println("Mean of the dataset: " + compute_mean(score_data));
		System.out.println("Variance of the dataset: " + compute_variance(score_data));
		System.out.println("Standard Deviation of the dataset: " + compute_standarddev(score_data));
		
		
	}
	
	public static double compute_mean(double data[]) {
		
		double sum = 0;
		double mean = 0;
		
		for (int i = 0; i < data.length; i++) {			
			sum += data[i];
		}
			
		mean = sum / data.length;
		
		return mean;
		
	}
//	
	public static double compute_variance(double data[]) {
		
		
		double mean = compute_mean(data);
		
		double sum = 0;
		double variance = 0;
		
		for (int i = 0; i < data.length; i++) {				
			sum += ((data[i] - mean) * (data[i] - mean));	
		}
		
		variance = Math.sqrt((sum / data.length));
				 
		return variance;
	}
	
	public static double compute_standarddev(double data[]) {
		
		return  Math.sqrt(compute_variance(data));
		
		
	}
}

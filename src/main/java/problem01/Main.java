package problem01;

public class Main {
	public static void main(String[] args) {
		int[] arr = {-10, -3, 5, 6, -20 };
		findMaxProduct(arr);
	}

	public static void findMaxProduct(int[] arr) {
		
		int num1=0, num2=0, max=0;
		for (int i=0 ; i<arr.length ; i++) {
			int temp1=0;
			int temp2=0;
			temp1 = arr[i];
			for (int j=i+1 ; j<arr.length; j++) {
				temp2 = arr[j];
				if (temp1*temp2 > max) {
					max = temp1*temp2;
					num1=temp1;
					num2=temp2;
				}
			}
		}
		System.out.println("["+num1+","+num2+"]");
		
	
	}
}

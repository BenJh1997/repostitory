package helloworld;

import java.util.Scanner;

public class AdvancedProg {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to advanced programming");
		
		System.out.println(50/3);
		
		Scanner input = new Scanner(System.in);
		System.out.print("number of people: ");
		int num_people = input.nextInt();
		
		String yourname;
		int yourage;
		
		System.out.print("Your name: ");
		String yourname = input.nextLine();
	}
}

package ency;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class open {

	public static void main(String[] args) {
		encry1 sy = new encry1();
		Scanner sc = new Scanner(System.in);

		String Id = null;
		String Pw = null;


		System.out.print("아이디 : ");
		Id = sc.next();

		
		try {
			Pw = sy.enc(Id);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println(Id);
		System.out.println(Pw);

	}

}

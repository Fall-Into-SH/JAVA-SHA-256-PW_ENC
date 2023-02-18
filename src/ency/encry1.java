package ency;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class encry1 {
	// 암호화 총괄
	public String enc(String Id) throws NoSuchAlgorithmException {
		SHA256 sha256 = new SHA256();
		
		// 비밀번호 적합성 체크를 위한 클래스
		PassCheck pc = new PassCheck();
		
		// 추가 암호화를 위한 클래스
		encry2 enc2 = new encry2();
		
		// 입력을 받기 위한 scanner 객체
		Scanner sc = new Scanner(System.in);

		// 반복문 실행을 위한 변수
		boolean run = true;
		
		// 비밀번호가 담길 변수
		String Pw = null;
		
		while (run) {
			// 비밀번호 입력 받기
			System.out.print("비밀번호 : ");
			Pw = sc.next();
			
			// 비밀번호 적합성 체크
			String check = pc.paPw(Pw, Id);
			
			// 적합성에 문제가 없을시
			if (check.equals("적합성통과")) {
				// 추가 암호화 실시 -> SHA-256은 레인보우 테이블이 존재 하기 때문 
				// + 해당 암호화 과정은 GitHub에 올라갈 예정이니 만약 사용시 수정 바람
				Pw = enc2.plusPw(Pw);
				run = false;
			} else {
				// 비밀번호 적합성에 문제가 있을경우 해당 문제를 보여준다.
				System.out.println(check);
			}
		}
		
		// 추가 암호화 과정까지 끝내면 SHA-256으로 암호화
		return sha256.encrypt(Pw);

	}
}

package ency;


public class encry2 {
	// 추가 암호화 -> SHA-256의 레인보우 테이블을 막기위해
	// 과정을 간단하게 설정하면 각문자 마다 정해진 조건에 따라서 조건에 맞는 아스키코드를 더해준다.

	private String encryption(String enc) {
		String save = "";
		int sum = 0;
		int k;

		// 최대 15자 가능
		int[][] ch = new int[3][5];

		for (int i = 0; i <= 3; i++) { // 암호화

			for (int j = 0; j <= 4; j++) {
				sum++;
				if (enc.length() >= sum) {
					k = i + j;
					// 문자를 아스키 코드로 변환
					ch[i][j] = (int) enc.charAt(k);

					switch (j) {
					case 0:
						ch[i][j] += 100; // ㅇ
						break;
					case 1:
						ch[i][j] += 107; // ㅏ
						break;
					case 2:
						ch[i][j] += 97; // ㅁ
						break;
					case 3:
						ch[i][j] += 103; // ㅎ
						break;
					case 4:
						ch[i][j] += 104; // ㅗ
						break;
					}
					
					//System.out.println("몇번 실화되나?");
					save += Integer.toString(ch[i][j]);
				} else {
					break;
				}
			}
			
			// 실행횟수와 문자열의 크기가 같으면 종료된다.
			if (enc.length() == sum) {
				break;
			}
		} // for문 종료

		// save에 저장됌
		return save;
		// 여기까지 기존
		
	}
	public String plusPw(String Pw) {
		// 이렇게 받은 숫자 정보는 무조건 한 문자가 3자리 단위로 가도록 설계되었다.
		String result = encryption(Pw);
		//System.out.println(result);		
		return result;
	}
	
}

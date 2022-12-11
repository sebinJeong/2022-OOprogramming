/*
 	객체지향 프로그래밍 평가과제 (배점 25점)
 	학과 : 컴퓨터공학부
 	학번 : 202103095
 	이름 : 정세빈
 	
 	과제 주제 : 2021년 한류 컨텐츠에 대한 해외 선호도
 */
package ooprog;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {
	@SuppressWarnings("static-access")
	
	public static void main(String[] args) throws IOException{ 
		//문자 기반 입력스트림에 보조스트림 연결하여 파일 읽기 
		BufferedReader bf = new BufferedReader(new FileReader("/Users/jeongsebin/Documents/KoreanWave2022.txt"));
		
		//readLine으로 한 라인 씩 읽고 출력
		while(true) {
			String line = bf.readLine();
			if(line==null) break; // 빈 줄이 있으면 정지
			System.out.println(line);
		}
	
		bf.close(); //입력스트림 닫기
		
		System.out.println();
		
		//출력스트림으로 콘솔에서 입력받은 값 output 파일에 저장
		PrintWriter pw = new PrintWriter("/Users/jeongsebin/Documents/output.txt");
		Scanner sc = new Scanner(System.in);
		System.out.println("어떤 문화 컨텐츠에 대해 알고 싶나요? 숫자를 입력해주세요.");
		System.out.println("1.음악 2.드라마 3.영화"); 
		String selectD = sc.nextLine();
		pw.println(selectD);
		
		//데이터 입력 함수 출력
		Manager manager = new Manager();
		manager.DataInputArr();
		
		//선택한 부문에 따라서 값을 출력
		//입력한 값과 동일한 키값을 가진 hashMap의 value 값을 각 부문의 ___List 필드로 선언 후 출력
		switch(selectD) { 
			case "1":
				System.out.println("한류 음악에 대한 자료를 알려드리겠습니다.");
				System.out.println();
				KpopList list1 = (KpopList)manager.dataRepo.get(1);
				list1.Display();
				break;
			case "2":
				System.out.println("한류 드라마에 대한 자료를 알려드리겠습니다.");
				System.out.println();
				DramaList list2 = (DramaList)manager.dataRepo.get(2);
				list2.Display();
				break;
			case "3":
				System.out.println("한류 영화에 대한 자료를 알려드리겠습니다.");
				System.out.println();
				MovieList list3 = (MovieList)manager.dataRepo.get(3);
				list3.Display();
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
		}
		pw.close(); //출력 스트림 종료
		sc.close(); //스캐너 종료
	}
}

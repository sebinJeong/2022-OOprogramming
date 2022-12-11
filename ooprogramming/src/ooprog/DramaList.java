package ooprog;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class DramaList implements CategoryInterface{
	private ArrayList<Drama> list = null;
	
	//Drama 데이터를 담을 list 생성
	public DramaList() {
		list = new ArrayList<Drama>();
	}
	//Drama 데이터를 list에 입력(실체 메소드) 
	public void Insert(Hallyu data) {
		list.add((Drama)data);
	}
	
	// 데이터값을 정렬해서 출력하는 함수(실체 메소드)
	public void Display() throws IOException{
		//Drama.txt 파일 생성 후 정렬된 값 파일에 입력
		PrintWriter pw = new PrintWriter("/Users/jeongsebin/Documents/drama.txt");
		
			if (list == null)
				return;
			for(Drama item: list) {
				pw.print(item.ranknum+"위 ");
				pw.print(item.country+" ");
				pw.println(item.percent+"%");
			}
			pw.close();
			
			//선호도 상위 3개국을 출력하기 위해 DramaList의 datatype과 ranking으로 해당하는 리스트만 출력
			System.out.println("선호도 상위 3개국");
			for(Drama item: list) {
				
				if("top".equalsIgnoreCase(item.ranking) && item.datatype==Datatype.NATION) {
					item.display(); //drama의 부모클래스의 출력함수
				}

			}
			System.out.println();
			//선호도 하위 3개국을 출력하기 위해 DramaList의 datatype과 ranking으로 해당하는 리스트만 출력
			System.out.println("선호도 하위 3개국");
			for(Drama item: list) {
				if("bottom".equalsIgnoreCase(item.ranking) && item.datatype==Datatype.NATION) {
					item.display();
				}

			}
			System.out.println();
			//최선호 드라마 3개국을 출력하기 위해 DramaList의 datatype과 ranking으로 해당하는 리스트만 출력
			System.out.println("최선호 드라마");
			for(Drama item: list) {
				if("top".equalsIgnoreCase(item.ranking) && item.datatype==Datatype.DRAMA) {
					item.display();
				}

			}
			
	}
}

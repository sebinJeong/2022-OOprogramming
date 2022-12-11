package ooprog;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MovieList implements CategoryInterface{

	private ArrayList<Movie> list = null;
	
	//Movie 데이터 값을 담을 list 생성
	public MovieList() {
		list = new ArrayList<Movie>();
	}
	
	//list에 데이터 값 저장(실체 메소드)
	public void Insert(Hallyu data) {
		list.add((Movie)data);
	}
	
	// 데이터값을 정렬해서 출력하는 함수(실체 메소드)
	public void Display() throws IOException{
		//Movie.txt파일 생성 후 정렬된 값 파일에 입력
		PrintWriter pw = new PrintWriter("/Users/jeongsebin/Documents/Movie.txt");
		
			if (list == null)
				return;
			for(Movie item: list) {
				pw.print(item.ranknum+"위 ");
				pw.print(item.country+" ");
				pw.println(item.percent+"%");
			}
			pw.close();
			//선호도 상위 3개국을 출력하기 위해 MovieList의 datatype과 ranking으로 해당하는 리스트만 출력
			System.out.println("선호도 상위 3개국");
			for(Movie item: list) {
				
				if("top".equalsIgnoreCase(item.ranking) && item.datatype==Datatype.NATION) {
					item.display(); //Movie의 부모클래스의 출력함수
				}

			}
			System.out.println();
			//선호도 하위 3개국을 출력하기 위해 MovieList의 datatype과 ranking으로 해당하는 리스트만 출력
			System.out.println("선호도 하위 3개국");
			for(Movie item: list) {
				if("bottom".equalsIgnoreCase(item.ranking) && item.datatype==Datatype.NATION) {
					item.display();
				}

			}
			System.out.println();
			//최선호 영화를 출력하기 위해 MovieList의 datatype과 ranking으로 해당하는 리스트만 출력
			System.out.println("최선호 영화");
			for(Movie item: list) {
				if("top".equalsIgnoreCase(item.ranking) && item.datatype==Datatype.MOVIE) {
					item.display();
				}

			}
			
	}
}

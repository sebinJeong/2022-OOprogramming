package ooprog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;



public class Manager{
	
	//hashMap을 이용하여 key에 컨텐츠 종류 번호, value에 interface를 상속받은 
	HashMap<Integer, CategoryInterface> dataRepo = new HashMap<Integer, CategoryInterface>();
	
	//파일에 있는 자료값 배열에 입력
	public void DataInputArr() throws IOException {
		
		BufferedReader bf = new BufferedReader(new FileReader("/Users/jeongsebin/Documents/data.txt"));
		
		//예외 처리 에러 발생 시 printStackTrace 실행 에러 내역 출력
		try {
			int row = 0;
			String line="";
			
			//파일에 있는 자료 한줄씩 읽기 
			while((line=bf.readLine()) != null) {
				String category = null;
				Datatype datatype = null;
				String ranking = null;
				int		ranknum = 0;
				String	country = null;
				float   percent = 0.0f;
		
				//, 기준으로 data 분할
				String[] Col = line.split(",", -1);
				
				if (Col.length<5) continue;
				
				//한 줄에 6개의 자료존재 
				//음악,nation,top,1,인도,92.4
				//category,datatype,ranking,ranknum,country,percent으로 분류하기
				for(int i=0; i<6; i++) {
					switch(i) {
					case 0:
						category = Col[i];
						break;
					case 1:
						datatype = Datatype.valueOf(Col[i].toUpperCase()); //열거타입 데이터 얻기
						break;
					case 2:
						ranking = Col[i];
						break;
					case 3:
						ranknum = Integer.parseInt(Col[i]);
						break;
					case 4:
						country = Col[i];
						break;
					case 5:
						percent = Float.parseFloat(Col[i]);
						break;
					default:
						break;
					}
				}
				
				//category에 따라 hashMap에 입력하기 
				if("음악".equalsIgnoreCase(category)) {
					KpopList list = null;
					
					//dataRepo 맵 컬렉션에 키값 1과 데이터를 담은 ArrayList 저장하거나
					//이미 value에 저장된 리스트 반환
					if (dataRepo.containsKey(1)) {
						list = (KpopList)dataRepo.get(1);
					} else {
						list = new KpopList();
						dataRepo.put(1, list);
					}
					//insert 함수로 category, datatype, ranking, ranknum, country, percent를 담은 리스트를
					//list에 저장 
					Kpop ins_item = new Kpop(category, datatype, ranking, ranknum, country, percent);
					list.Insert(ins_item);
					
				} else if("드라마".equalsIgnoreCase(category)) {
					DramaList list = null;
					
					if (dataRepo.containsKey(2)) {
						list = (DramaList)dataRepo.get(2);
					} else {
						list = new DramaList();
						dataRepo.put(2, list);
					}
					
					Drama ins_item = new Drama(category, datatype, ranking, ranknum, country, percent);
					list.Insert(ins_item);
					
				} else if("영화".equalsIgnoreCase(category)) {
					
					MovieList list = null;

					if (dataRepo.containsKey(3)) {
						list = (MovieList)dataRepo.get(3);
					} else {
						list = new MovieList();
						dataRepo.put(3, list);
					}
					
					Movie ins_item = new Movie(category, datatype, ranking, ranknum, country, percent);
					list.Insert(ins_item);
				}
				
			}
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(0);
		} 
		
		//입력스트림 닫기
		bf.close();
		

	}

	
}

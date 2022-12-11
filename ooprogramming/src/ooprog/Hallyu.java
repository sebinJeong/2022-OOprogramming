package ooprog;

//Kpop, Drama, Movie 클래스의 부모 클래스
public class Hallyu {
	public String category;
	public Datatype datatype;
	public String ranking;
	public int ranknum;
	public String country;
	public float percent;
	
	public Hallyu(String category, Datatype datatype, String ranking, int ranknum, String country, float percent){
		this.datatype = datatype;
		this.category = category;
		this.ranking = ranking;
		this.ranknum = ranknum;
		this.country = country;
		this.percent = percent;
	}
	
	//출력 함수
	public void display() {

		System.out.print(ranknum+"위 ");
		System.out.print(country+" ");
		System.out.println(percent+"%");
	}
}

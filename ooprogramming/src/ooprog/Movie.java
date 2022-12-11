package ooprog;

public class Movie extends Hallyu{
	//super()를 활용하여 부모클래스를 상속받음
	public Movie(String category, Datatype datatype, String ranking, int ranknum, String country, float percent){
		super(category, datatype, ranking, ranknum, country, percent);
	}
	 
}

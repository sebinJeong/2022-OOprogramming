package ooprog;

import java.io.IOException;

//선호도 순위 출력을 위한 인터페이스
public interface CategoryInterface {
	
	public void Insert(Hallyu data);
	public abstract void Display() throws IOException; //출력음 담당하는 함
}

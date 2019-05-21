package memento;
import java.util.ArrayList;

public class Caretaker {
	private ArrayList<Memento> savedScores=new ArrayList<Memento>();
	public void addMemento(Memento memento) {
		 if(savedScores.size()<10)
	        savedScores.add(memento);
		 else {
			 savedScores.remove(0);
			 savedScores.add(memento);
		 }
		}
	public Memento getMemento(int index) {
		return savedScores.get(index); 
	}
}
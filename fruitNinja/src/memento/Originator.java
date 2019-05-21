package memento;

public class Originator {
	private int score;
	public void setScore(int newScore) { //setting the value for the score
		 System.out.println("From Originator: Current Score is :\n"+newScore+ "\n");
		 score=newScore;
	}
	public Memento storInMemento() {
		
		System.out.println("From Originator: Saving to Memento");
		return new Memento(score);
	}
	public int restoreFromMemento(Memento memento) {
		 score = memento.getSavedScore();
		 System.out.println("From Originator: Previous Score Saved in Memento\n"+score + "\n");
		 return score;
	}
}

package memento;

public class Memento {
	private int scoreSave;
	public Memento(int scoreSve) {
		this.scoreSave=scoreSve;
	}
	public int getSavedScore() {
		return scoreSave;
	}
}

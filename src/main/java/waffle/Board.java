package waffle;

import general.Case;

/*Appelle pas dans le main. Ce classe contient les fonctions de set, get et itteration*/

public abstract class Board implements CaseIterator, Waffle {
	CaseType[][] board;
	private int length;
	private int height;
	int index_l = 0;
	int index_h = 0;
	
	public Board(int height, int length){
		this.length = length+1;
		this.height = height+1;
		board = new CaseType[height+1][length+1];
	}
	
	public void setCase(CaseType caseType) {
		board[index_h][index_l] = caseType;
	}
	
	public void setCase(int h, int l, CaseType caseType) {
		board[h][l] = caseType;
	}
	
	public void setTo_length(int l) {
		index_l = l;
	}
	
	public void setTo_height(int h) {
		index_h = h;
	}
	
	
	public CaseType getCase() {
		return board[index_h][index_l];
	}
	
	@Override
	public CaseType getCase(int h, int l) {
		return board[h][l];
	}
	
	@Override
	public Case getIndex(){
		return new Case(index_h, index_l);
	}
	
	@Override
	public int getLength() {
		return length-2;
	}
	
	@Override
	public int getHeight() {
		return height-2;
	}
	
	
	// Iterator
	
	@Override
	public Iterator getIterator() {
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator {

		@Override
		public boolean hasNext_length() {
			if(index_l >= length-1) {
				return false;
			}
			return true;
		}

		@Override
		public boolean hasNext_height() {
			if(index_h >= height-1) {
				return false;
			} else {
				return true;
			}
		}

		@Override
		public Object next_length() {
			return board[index_h][index_l++];
		}

		@Override
		public Object next_height() {
			return board[index_h++][index_l];
		}	
	}
}
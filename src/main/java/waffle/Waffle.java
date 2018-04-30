package waffle;

import general.Case;

public interface Waffle {
	void manger(Case eatCase);
	CaseType getCase();
	CaseType getCase(int h, int l);
	void setCase(CaseType caseType);
	void setCase(int h, int l, CaseType caseType);
	public Case getIndex();
	public int getLength();
	public int getHeight();
	boolean isWon(Case myCase);
}

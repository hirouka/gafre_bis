package waffle;

import general.Case;

/*Pour initialiser le tableau, appelle Gaufre gaufre = new Gaufre(longeur, hauteur)*/
public class Gaufre extends Board{
	
	public Gaufre(int height, int length){
		super(height, length);
		
		for(Iterator it_h = this.getIterator(); it_h.hasNext_height();){
			
			this.setTo_length(0);
			for(Iterator it_l = this.getIterator(); it_l.hasNext_length();){
				this.setCase(CaseType.FREE);
				it_l.next_length();
			}
			it_h.next_height();
		}
		
		this.setCase(0, 0, CaseType.POISON);
	}

	@Override
	public void manger(Case eatCase) {
		int i = eatCase.getX();
		int j = eatCase.getY();
		
		this.setTo_length(j);
		this.setTo_height(i);
		
		for(Iterator it_h2 = this.getIterator(); it_h2.hasNext_height();){
			this.setTo_length(j);
			for(Iterator it_l2 = this.getIterator(); it_l2.hasNext_length();){
				this.setCase(CaseType.EATEN);
				it_l2.next_length();
			}
			it_h2.next_height();
		}
	}

	@Override
	public boolean isWon(Case myCase) {
		int x = myCase.getX();
		int y = myCase.getY();
		
		return ((x==0)&&(y==0));
		
	}
	
	public void printGaufre() {
		int i = 0;
		int j = 0;
		
		this.setTo_length(j);
		this.setTo_height(i);
		
		System.out.println(" ");
		System.out.println(" ");
		
		for(Iterator it_h2 = this.getIterator(); it_h2.hasNext_height();){
			System.out.println(" ");
			this.setTo_length(j);
			for(Iterator it_l2 = this.getIterator(); it_l2.hasNext_length();){
				System.out.print(this.getCase());
				System.out.print(" ");
				it_l2.next_length();
			}
			it_h2.next_height();
		}
	}
}

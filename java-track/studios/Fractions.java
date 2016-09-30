
public class Fractions {

	/*
	 * Fractions fields
	 * numerator int
	 * denominator int
	 * 
	 * methods 
	 * add fractions
	 * multiply fractions
	 * make a reciprocal
	 * simplify itself
	 * 
	 */

	private int num;
	private int denom;

	public Fractions(int num, int denom) {
		super();
		this.num = num;
		this.denom = denom;
	}


	public int getNum() {
		return num;
	}


	public int getDenom() {
		return denom;
	}

	//to add fractions, denoms must be equal.  Then apply to nums, then add nums
	public String add(Fractions fract1, Fractions fract2){
		int fract1Denom = fract1.getDenom();
		int fract2Denom = fract2.getDenom();

		if(fract1Denom == fract2Denom){
			int newNum = fract1.getNum() + fract2.getNum();
			return newNum + "/" + fract1.getDenom();
		}
		else{
			int newDenom = fract1.getDenom() * fract2.getDenom();
			int fract1NewNum = fract1.getNum() * fract2.getDenom();
			int fract2NewNum = fract2.getNum() * fract1.getDenom();

			int finalNum = fract1NewNum + fract2NewNum;

			return finalNum + "/" + newDenom;
		}
	}

	//multiply fractions straight across

	public String mult(Fractions fract1, Fractions fract2){
		int multNum = fract1.getNum() * fract1.getNum();
		int multDenom = fract1.getDenom() * fract2.getDenom();
		return multNum + "/" + multDenom;
	}

	//simplify, find greatest common denominator (gcd), divide into both num and denom
	public String simplify(Fractions fraction){
		//find the larger of the num or denom
		int largest;
		if(fraction.getDenom() > fraction.getNum()){
			largest = fraction.getDenom();
		}
		else{
			largest = fraction.getNum();
		}
		
		//find largest number that divides num and denom evenly
		int gcd = 0;
		for (int i = largest; i>=2; i--){
			if(fraction.getNum() % i == 0 && fraction.getDenom() % i == 0){
				gcd = i;
				break;
			}
		}
			
			//divide num and denom by gcd
			//Need to figure out why the gcd isn't getting reset from above.
			if (gcd != 0){
				int newNum = fraction.getNum() / gcd;
				int newDenom = fraction.getDenom() / gcd;
				return newNum + "/" + newDenom;
			}
				
		return fraction.getNum() + "/" + fraction.getDenom();
			
	}




	@Override
	public String toString() {
		return "Fractions [num=" + num + ", denom=" + denom + "]";
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Fractions fract1 = new Fractions(1,2);
		System.out.println(fract1);
		Fractions fract2 = new Fractions(5,10);
		System.out.println(fract2);
		
		System.out.println(fract1.add(fract1, fract2));
		
		System.out.println(fract2.simplify(fract2));
		
		Fractions fract3 = new Fractions(5,25);
		System.out.println(fract3);
		
		
		


	}

}

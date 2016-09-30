
public class Rectangle {
	
	/*
	 * rectangle has a
	 * length int
	 * width int
	 */
	
	private int length;
	private int width;
	
	

	public Rectangle(int length, int width) {
		super();
		this.length = length;
		this.width = width;
	}



	public int getLength() {
		return length;
	}





	public int getWidth() {
		return width;
	}
	
	//area = width * length
	public int area(){
		int area = this.length * this.width;
		return area;
	}

	//perimeter = (width * 2) + (length * 2)
	public int perimeter(){
		int perimeter = (this.width * 2) + (this.length * 2);
		return perimeter;
	}
	
	//determine if rectangle is square, length == width
	public String isSquare(){
		if(getLength() == getWidth()){
			return "This is a square";
		}
		else{
			return "This is not a square";
		}
	}
		
	//compare areas to determine which is bigger
	public String isBigger(Rectangle rect1, Rectangle rect2){
		int rect1Area = rect1.area();
		int rect2Area = rect2.area();
		if(rect1Area > rect2Area){
			return "rect1 is bigger";
		}
		else if(rect2Area > rect1Area){
			return "rect2 is bigger";
		}
		else{
			return "The rectangles are the same size";
		}
		
	}
	
	
	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + "]";
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rect1 = new Rectangle(3, 3);
		System.out.println(rect1);
		System.out.println(rect1.isSquare());
		System.out.println(rect1.area());
		System.out.println(rect1.perimeter());
		
		Rectangle rect2 = new Rectangle(5,6);
		System.out.println(rect1.isBigger(rect1, rect2));
		
		Rectangle rect3 = new Rectangle(3,10);
		
		System.out.println(rect2);
		System.out.println(rect3);
		System.out.println(rect2.isBigger(rect2, rect3));
		
	}

}

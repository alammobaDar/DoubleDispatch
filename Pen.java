package Package;

public class Pen implements Tool{

	@Override
	public void useOnCircle(Circle circle) {
		System.out.println("Using a pen on Circle");
		
	}

	@Override
	public void useOnSquare(Square square) {
		System.out.println("Using a pen on Square");
		
	}

}

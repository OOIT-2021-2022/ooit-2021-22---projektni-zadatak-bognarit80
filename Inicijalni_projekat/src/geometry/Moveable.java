package geometry;

public interface Moveable {
	
	//could also define in Shape class but it's more flexible like this
	void moveTo(int x, int y);
	void moveBy(int x, int y);
}

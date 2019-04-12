package BridgePattern;

public class Circle extends Shape {

	int r, x, y;

	public Circle(int r, int x, int y, DrawApi drawApi) {
		super(drawApi);
		this.r = r;
		this.x = x;
		this.y = y;
	}

	@Override
	public void drawCircle() {
		drawApi.drawCircle(r, x, y);
	}

}

package Data;

public class boundingBox {
	private spriteInfo spriteData;
	private int x1, x2, y1, y2;
	
	
	/* Constructor using definite Boundaries */
    public boundingBox(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;	
	}
	
    /* Constructor using spriteInfo object */
    public boundingBox(spriteInfo spriteData) {
        this(spriteData, 0, 128, 0, 128);
    }

    /* Constructor using spriteInfo object and boundary adjustments relative to the origin (top left) */
    public boundingBox(spriteInfo _sprint, int adjustX1, int adjustX2, int adjustY1, int adjustY2) {
        this.spriteData = _sprint;
        this.x1 = spriteData.getCoords().getX() + adjustX1;
        this.x2 = spriteData.getCoords().getX() + adjustX2;
        this.y1 = spriteData.getCoords().getY() + adjustY1;
        this.y2 = spriteData.getCoords().getY() + adjustY2;
    }
	
    public String toString() {
        return "x1 = " + x1 + ", x2 = " + x2 + ", y1 = " + y1 + ", y2 = " + y2;
    }
    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }
    public void setX1(int val) {
        x1 = val;
    }

    public void setX2(int val) {
        x2 = val;
    }

    public void setY1(int val) {
        y1 = val;
    }

    public void setY2(int val) {
        y2 = val;
    }
}

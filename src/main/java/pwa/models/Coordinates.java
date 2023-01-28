package pwa.models;

public class Coordinates {

	private int x;
	private int y;

	public Coordinates(int pX, int pY){
		this.x = pX;
		this.y = pY;
	}

	public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

	public boolean isTheMoveStillInTheWarehouse(Coordinates pCoordinates){
		return pCoordinates.getX() >= 0
				&& pCoordinates.getY() >= 0
				&& pCoordinates.getX() <= this.x
				&& pCoordinates.getY() <= this.y;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinates other = (Coordinates) obj;
		if (x != other.x || y != other.y)
			return false;

		return true;
	}
}
package pwa.models;

import pwa.enums.Orientation;

public class AutomatonPosition {

	private Coordinates automatonCoordinates;
	private Orientation automatonOrientation;

	public AutomatonPosition(Coordinates pautomatonCoordinates,
			Orientation pautomatonOrientation) {
		this.automatonCoordinates = pautomatonCoordinates;
		this.automatonOrientation = pautomatonOrientation;
	}

	public Orientation getAutomatonOrientation() {
		return automatonOrientation;
	}

	public void setAutomatonOrientation(Orientation pAutomatonOrientation) {
		this.automatonOrientation = pAutomatonOrientation;
	}

	public Coordinates getAutomatonCoordinates() {
		return automatonCoordinates;
	}

	public void setAutomatonCoordinates(Coordinates pAutomatonCoordinates) {
		this.automatonCoordinates = pAutomatonCoordinates;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((automatonCoordinates == null) ? 0 : automatonCoordinates.hashCode());
		result = prime * result + ((automatonOrientation == null) ? 0 : automatonOrientation .hashCode());
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
		AutomatonPosition other = (AutomatonPosition) obj;
		if (automatonCoordinates == null) {
			if (other.automatonCoordinates != null)
				return false;
			} else if (!automatonCoordinates.equals(other.automatonCoordinates))
				return false;
		if (automatonOrientation != other.automatonOrientation)
			return false;
		return true;
	}
}
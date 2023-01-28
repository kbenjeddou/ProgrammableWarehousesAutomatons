package pwa.enums;

public enum Orientation {

    NORTH('N', "North"),
    EAST('E', "East"),
    WEST('W', "West"),
    SOUTH('S', "South");

    private char codeOrientation;
    private String libelleOrientation;

    private Orientation(char pCodeOrientation, String pLibelleOrientation){
        this.codeOrientation = pCodeOrientation;
        this.libelleOrientation = pLibelleOrientation;
    }

    public char getCodeOrientation() {
        return codeOrientation;
    }

    public String getLibelleOrientation() {
        return libelleOrientation;
    }

}

package pwa.enums;

public enum AutomatonInstruction {

    DROITE('D', "Pivoter à droite"),
    GAUCHE('G', "Pivoter à gauche"),
    AVANCER('A', "Avancer");

    private char codeInstruction;
    private String libelleInstruction;


    private AutomatonInstruction(char pCodeInstruction, String libelleInstruction) {
        this.libelleInstruction = libelleInstruction;
        this.codeInstruction = pCodeInstruction;
    }

    public String getLibelleInstruction() {
        return libelleInstruction;
    }

    public char getCodeInstruction() {
        return codeInstruction;
    }

}

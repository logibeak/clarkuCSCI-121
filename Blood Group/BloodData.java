public class BloodData {
    enum Blood{
        Ap("A", '+'),
        An("A", '-'),
        Bp("B", '+'),
        Bn("B", '-'),
        ABp("AB", '+'),
        ABn("AB", '-'),
        Op("O", '+'),
        On("O", '-');
        private final String bloodType;
        private final char rhFactor;
        Blood(String bloodType, char rhFactor){
            this.bloodType = bloodType;
            this.rhFactor = rhFactor;
        }
        public String getBloodType() {
            return bloodType;
        }

        public char getRhFactor() {
            return rhFactor;
        }
    }
    private String bloodType;
    private char rhFactor;

    public char getRhFactor() {
        return rhFactor;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public void setRhFactor(char rhFactor) {
        this.rhFactor = rhFactor;
    }
    BloodData(){
        setBloodType(Blood.Op.bloodType);
        setRhFactor(Blood.Op.getRhFactor());
    }
    BloodData(Blood bloodType){
        setBloodType(bloodType.bloodType);
        setRhFactor(bloodType.rhFactor);
    }

    public BloodData stringToBloodData(String s) {
        BloodData r = switch (s) {
            case "Ap" -> new BloodData(BloodData.Blood.Ap);
            case "An" -> new BloodData(BloodData.Blood.An);
            case "Bp" -> new BloodData(BloodData.Blood.Bp);
            case "Bn" -> new BloodData(BloodData.Blood.Bn);
            case "Op" -> new BloodData(BloodData.Blood.Op);
            case "On" -> new BloodData(BloodData.Blood.On);
            case "ABn" -> new BloodData(BloodData.Blood.ABn);
            case "ABp" -> new BloodData(BloodData.Blood.ABp);
            default -> null;
        };
        return r;
    }
}
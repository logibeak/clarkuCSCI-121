public class BloodData {
    //Enum which stores the different blood types
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

        //Convert strings to correct enum
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
    //data fields
    private String bloodType;
    private char rhFactor;
    //get set methods
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
    //constructors
    BloodData(){
        setBloodType(Blood.Op.bloodType);
        setRhFactor(Blood.Op.getRhFactor());
    }
    BloodData(Blood bloodType){
        setBloodType(bloodType.bloodType);
        setRhFactor(bloodType.rhFactor);
    }

    //switch-case to convert string to type stored in enum
    public static BloodData stringToBloodData(String s) {
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
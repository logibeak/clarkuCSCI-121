public class BloodData {
    //Enum which stores the different blood types
    enum Blood{
        APOSITIVE("A", '+'),
        ANEGATIVE("A", '-'),
        BPOSITIVE("B", '+'),
        BNEGATIVE("B", '-'),
        ABPOSITIVE("AB", '+'),
        ABNEGATIVE("AB", '-'),
        OPOSITIVE("O", '+'),
        ONEGATIVE("O", '-');
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
        setBloodType(Blood.OPOSITIVE.bloodType);
        setRhFactor(Blood.OPOSITIVE.getRhFactor());
    }
    BloodData(Blood bloodType){
        setBloodType(bloodType.bloodType);
        setRhFactor(bloodType.rhFactor);
    }

    //convert string to type stored in enum
    public static BloodData stringToBloodData(String s) {
        try{return new BloodData(Blood.valueOf(s.replace("+","POSITIVE").
                replace("-","NEGATIVE").toUpperCase()));
        } catch (Exception g){
            return null;
        }
    }
}
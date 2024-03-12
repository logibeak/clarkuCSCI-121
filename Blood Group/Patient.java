public class Patient {
    private int id;
    private int age;
    BloodData bloodData;

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBloodData(BloodData bloodData) {
        this.bloodData = bloodData;
    }

    public BloodData getBloodData() {
        return bloodData;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    Patient(){
        setId(0);
        setAge(0);
        setBloodData(new BloodData());
    }
    Patient(int id, int age, BloodData bloodData){
        setId(id);
        setAge(age);
        setBloodData(bloodData);
    }
}

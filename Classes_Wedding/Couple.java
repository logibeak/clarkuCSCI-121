public class Couple {
    private Person bride;
    private Person groom;
    Couple(Person newBride, Person newGroom){
        bride=newBride;
        groom=newGroom;
    }

    @Override
    public String toString(){
        return bride.getFirstName() + " and " + groom.getFirstName();
    }

    public Person getBride() {
        return bride;
    }

    public Person getGroom() {
        return groom;
    }
}

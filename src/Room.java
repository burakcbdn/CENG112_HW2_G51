public class Room implements IRoom {


    @Override
    public boolean dequeueAny() {
        return false;
    }

    @Override
    public boolean dequeueDog() {
        return false;
    }

    @Override
    public boolean dequeueCat() {
        return false;
    }

    @Override
    public boolean enqueueDog() {
        return false;
    }

    @Override
    public boolean enqueueCat() {
        return false;
    }

    public void operate(String user, String operation){
        switch (user) {
            case "donor":
                System.out.println("Donor" + operation);
                break;
            case "caregiver":
                break;
            case "rescuer":
                break;
            case "animalcontrol":
                break;
        }
    }
}

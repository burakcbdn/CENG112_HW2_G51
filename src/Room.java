public class Room implements IRoom {

    IQueue<String> dogQueue = new IQueue<>();
    IQueue<String> catQueue = new IQueue<>();
    IQueue<String> bothQueue = new IQueue<>();
    IQueue<String> mealQueue = new IQueue<>();

    @Override
    public boolean dequeueAny() {
        if (bothQueue.dequeue() == null) {
            return false;
        } else {
            bothQueue.dequeue();
            return true;
        }
    }

    @Override
    public boolean dequeueDog() {
        if (dogQueue.dequeue() == null) {
            return false;
        } else {
            dogQueue.dequeue();
            return true;
        }
    }

    @Override
    public boolean dequeueCat() {
        if (catQueue.dequeue() == null) {
            return false;
        } else {
            catQueue.dequeue();
            return true;
        }
    }

    @Override
    public boolean enqueueDog() {
        if (dogQueue.enqueue("Dog")) {
            bothQueue.enqueue("Dog");
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean enqueueCat() {
        if (catQueue.enqueue("Cat")) {
            bothQueue.enqueue("Cat");
            return true;
        } else {
            return false;
        }
    }

    public boolean feed() {
        if (mealQueue.dequeue() == null) {
            return false;
        } else {
            mealQueue.dequeue();
            return true;
        }
    }

    public boolean addMeal(String meal) {
        if (mealQueue.enqueue(meal)) {
            return true;
        } else {
            return false;
        }
    }

    public void operate(String user, String operation) {
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

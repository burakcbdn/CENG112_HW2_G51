//Room Class

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

    //feeds animals
    public boolean feed() {
        if (mealQueue.dequeue() == null) {
            return false;
        } else {
            mealQueue.dequeue();
            return true;
        }
    }

    //adds new meal
    public boolean addMeal(String meal) {
        if (mealQueue.enqueue(meal)) {
            return true;
        } else {
            return false;
        }
    }

    //makes operations
    public void operate(Operation op) {
        String operator = op.getOperator();
        String operation = op.getOperation();

        switch (operator) {

            case "donor":
                if (addMeal(operation)) {
                    System.out.println("Donors tries to donate: SUCCESS.");
                } else {
                    System.out.println("Donors tries to donate: FAIL.");
                }
                break;

            case "caregiver":
                if (feed()) {
                    System.out.println("CareGiver tries to feed the animals: SUCCESS.");
                } else {
                    System.out.println("CareGiver tries to feed the animals: FAIL.");
                }
                break;

            case "animalcontrol":
                switch (operation) {

                    case "dog":
                        if (enqueueDog()) {
                            System.out.println("AnimalControl tries to bring new animals: SUCCESS.");
                        } else {
                            System.out.println("AnimalControl tries to bring new animals: FAIL.");
                        }
                        break;

                    case "cat":
                        if (enqueueCat()) {
                            System.out.println("AnimalControl tries to bring new animals: SUCCESS.");
                        } else {
                            System.out.println("AnimalControl tries to bring new animals: FAIL.");
                        }
                        break;

                }
                break;

            case "rescuer":
                switch (operation) {

                    case "dog":
                        if (dequeueDog()) {
                            System.out.println("Rescuer tries to adopt a dog: SUCCESS.");
                        } else {
                            System.out.println("Rescuer tries to adopt a dog: FAIL.");
                        }
                        break;

                    case "cat":
                        if (dequeueCat()) {
                            System.out.println("Rescuer tries to adopt a cat: SUCCESS.");
                        } else {
                            System.out.println("Rescuer tries to adopt a cat: FAIL.");
                        }
                        break;

                    case "any":
                        if (dequeueAny()) {
                            System.out.println("Rescuer tries to adopt any animal: SUCCESS.");
                        } else {
                            System.out.println("Rescuer tries to adopt any animal: FAIL.");
                        }
                        break;
                }
                break;
        }
    }
}

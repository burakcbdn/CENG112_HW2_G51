public interface IRoom {

    //adopting random animal
    public boolean dequeueAny();

    //adopting dog
    public boolean dequeueDog();

    //adopting cat
    public boolean dequeueCat();

    //new dog to shelter
    public boolean enqueueDog();

    //new cat to shelter
    public boolean enqueueCat();

}

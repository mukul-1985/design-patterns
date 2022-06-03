package in.mukuljain;

public class Animal {

    public Flys flyingType;

    public String tryToFly() {
        return flyingType.fly();
    }

    public void setFlyingAbility(Flys newFlyType) {
        this.flyingType = newFlyType;
    }
}

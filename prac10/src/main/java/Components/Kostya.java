package Components;
import Interfaces.Programmer;

public class Kostya {
    private final Programmer programmer;
    public Kostya(Programmer programmer) {
        this.programmer = programmer;
    }
    public void code() {
        programmer.doCoding();
    }

    @Override
    public String toString() {
        return "Kostya{" +
                "programmer=" + programmer +
                '}';
    }
}

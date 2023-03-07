import IteratorPattern.MyCollection;
import MediatorPattern.*;

public class Main {
    public static void main(String[] args) {
        MyCollection myCollection = new MyCollection(3);
        myCollection.add("one");
        myCollection.add("two");
        myCollection.add("three");
        for (String item : myCollection) {
            System.out.println(item);
        }   // iterator


        ConcreteMediator m = new ConcreteMediator();

        ConcreteColleague1 c1 = new ConcreteColleague1(m);
        ConcreteColleague2 c2 = new ConcreteColleague2(m);

        m.setColleague1(c1);
        m.setColleague2(c2);

        c1.send("How are you?");
        c2.send("Fine, thanks");
    }
}

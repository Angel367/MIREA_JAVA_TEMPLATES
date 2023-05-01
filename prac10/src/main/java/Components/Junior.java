package Components;

import Interfaces.Programmer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("jun")
@Qualifier("jun")
public class Junior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("I`m junior-programmer");
    }
}

package Components;

import Interfaces.Programmer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("sen")
@Qualifier("sen")
public class Senior implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("I`m senior-programmer");
    }
}

package Components;

import Interfaces.Programmer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("mid")
@Qualifier("mid")
public class Middle implements Programmer {
    @Override
    public void doCoding() {
        System.out.println("I`m middle-programmer");
    }
}

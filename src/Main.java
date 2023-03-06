import PrototypePattern.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Cookie tempCookie = null;   // prototype
        Cookie prot = new CoconutCookie();
        CookieMachine cm = new CookieMachine(prot);
        tempCookie = cm.makeCookie();
        System.out.println(tempCookie);


    }
}

package FactoryMethodPattern;

public interface Developer {

    void write();

    static Developer of(String type){
        switch(type){
            case "JAVA" : return new JavaDeveloper();
            case "RUBY" : return new RubyDeveloper();
            default: throw new UnsupportedOperationException("Not supported for " + type);
        }
    }

}

 class JavaDeveloper implements Developer {
    @Override
    public void write() {
        System.out.println("Java developer writes java code");
    }
}

 class RubyDeveloper implements Developer {
    @Override
    public void write() {
        System.out.println("Ruby developer writes ruby code");
    }
}


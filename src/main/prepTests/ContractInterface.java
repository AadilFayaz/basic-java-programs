package src.main.prepTests;

public interface ContractInterface {
    public static final int num = 30;

    default int doSomething() {
        return num;
    }

    static String someStaticMethod(){
        return "This is interface static method";
    }

    String needsToBeOverridden();
}

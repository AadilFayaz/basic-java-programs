package src.main.prepTests;

public class ContractInterfaceImpl implements ContractInterface {

    public int public_field = 5;
    protected int protected_field = 10;
    private int private_field = 15;
    int package_private_field = 20;

    @Override
    public int doSomething() {
        return 1 + ContractInterface.super.doSomething();
    }

    @Override
    public String needsToBeOverridden() {
        return "Class level implementation + --" + ContractInterface.someStaticMethod();
    }
}

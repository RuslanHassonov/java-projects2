package be.mobyus.ie5.screens;

public class MakeOrderScreen extends AbstractScreen {

    @Override
    public String[] drawScreenInternal(String... parameters) {
        System.out.println("Welcome, you are now shopping...");
        System.out.println("Please enter the name of the product (q to quit).");
        return new String[] { readFromConsole("Input") };
    }
}

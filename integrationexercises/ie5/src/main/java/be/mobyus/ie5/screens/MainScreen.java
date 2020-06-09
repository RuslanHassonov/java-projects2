package be.mobyus.ie5.screens;

public class MainScreen extends AbstractScreen{

    @Override
    public String[] drawScreenInternal(String... parameters) {
        System.out.println("Welcome, you are now shopping...");
        System.out.println("Make your selection (q to quit).");
        return new String[] { readFromConsole("Input") };
    }
}

package be.mobyus.ie5.screens;

public class ShopSelectionScreen extends AbstractScreen {

    @Override
    public String[] drawScreenInternal(String... parameters) {
        System.out.println("Welcome, please choose your shop (q to quit).");
        return new String[] { readFromConsole("Input") };
    }
}

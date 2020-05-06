package be.mobyus.ie5.screens;

import static java.lang.System.exit;
import static java.lang.System.in;

import java.util.Scanner;

public abstract class AbstractScreen implements Screen {

	private final Scanner scanner = new Scanner(in);

	@Override
	public String[] drawScreen(String... parameters) {
		for (int i = 0; i < 5; i++) {
			System.out.println("");
		}

		return drawScreenInternal(parameters);
	}

	public abstract String[] drawScreenInternal(String... parameters);

	public String readFromConsole(String prefix) {
		System.out.print("\n" + prefix + ":");
		String input = scanner.next();

		if ("q".equals(input)) {
			exit(0);
		}
		return input;
	}
}

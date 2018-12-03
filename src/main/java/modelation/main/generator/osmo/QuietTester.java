package modelation.main.generator.osmo;

import java.io.OutputStream;
import java.io.PrintStream;

import osmo.tester.OSMOTester;

public class QuietTester extends OSMOTester {

	@Override
	public void generate(long seed) {
		PrintStream originalStream = System.out;

		System.setOut(new PrintStream(new OutputStream() {
			public void write(int b) {
				// NO-OP
			}
		}) {
			public PrintStream printf(String string, Object...args) {
				originalStream.printf(string, args);
				return null;
			}
		});

		super.generate(seed);

		System.setOut(originalStream);
	}
}

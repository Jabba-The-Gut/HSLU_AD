package ch.hslu.ad.sw12;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.ad.sw02.D1.Aufg3.Main;

public class WordProblemWithDEA {
	private final static Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		// some test scenarios
		LOG.info("0" + " --> Ist ein Wort der Sprache L: " + isWordLanguage("0"));
		LOG.info("010" + " --> Ist ein Wort der Sprache L: " + isWordLanguage("010"));
		LOG.info("01110" + " --> Ist ein Wort der Sprache L: " + isWordLanguage("01110"));
		LOG.info("0111010" + " --> Ist ein Wort der Sprache L: " + isWordLanguage("0111010"));
		LOG.info("01110111110" + " --> Ist ein Wort der Sprache L: " + isWordLanguage("01110111110"));
		LOG.info("1" + " --> Ist ein Wort der Sprache L: " + isWordLanguage("1"));
		LOG.info("011" + " --> Ist ein Wort der Sprache L: " + isWordLanguage("011"));
		
	}

	public static boolean isWordLanguage(final String str) {
		String state = "z0";
		for (char c : str.toCharArray()) {
			switch (c) {
			case '0':
				switch (state) {
				case "z0":
					state = "z1";
					break;
				case "z2":
					state = "z4";
					break;
				default:
					return false;
				}
				break;
			case '1':
				switch (state) {
				case "z1":
					state = "z2";
					break;
				case "z2":
					state = "z3";
					break;
				case "z3":
					state = "z2";
					break;
				case "z4":
					state = "z2";
					break;
				default:
					return false;
				}
				break;
			default:
				return false;
			}
		}
		return "z4".equals(state) || "z1".equals(state);
	}

}

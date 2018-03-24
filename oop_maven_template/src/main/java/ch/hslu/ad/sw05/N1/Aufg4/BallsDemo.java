/*
 * Copyright 2017 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.ad.sw05.N1.Aufg4;

import javax.swing.JFrame;

import javax.swing.JPanel;

/**
 * Einfaches GUI auf Swing basierend, zum Anzeigen von Formen
 */
@SuppressWarnings("serial")
public final class BallsDemo extends JFrame {
	private final JPanel panel = new CustomPanel(600, 600);

	/**
	 * Konstruktor.
	 */
	public BallsDemo() {
		super("Moving Balls");
		this.add(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	/**
	 * main-Methode.
	 * 
	 * @param args
	 *            nicht verwendet.
	 */
	public static void main(final String[] args) {
		new BallsDemo();
	}
}

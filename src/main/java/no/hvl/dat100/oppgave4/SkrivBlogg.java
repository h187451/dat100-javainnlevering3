package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		try {
			File innfil = new File(mappe + filnavn);
			PrintWriter skriver = new PrintWriter(innfil);
			skriver.print(samling.toString());
			skriver.close();
			return true;
		} catch (FileNotFoundException e) {
			return false;
		}
	}
}

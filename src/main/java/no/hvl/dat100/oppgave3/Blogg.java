package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	public Innlegg[] innleggtabell;
	public int nesteledig = 0;

	public Blogg() {
		innleggtabell = new Innlegg[20];
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for (int i=0;i<nesteledig;i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				return i;
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		if (finnInnlegg(innlegg) != -1) {
			return true;
		}
		return false;
	}

	public boolean ledigPlass() {
		if (nesteledig >= innleggtabell.length) {
			return false;
		}
		return true;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if (!finnes(innlegg)) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		return false;
	}
	
	public String toString() {
		String str = nesteledig + "\n";
		for (int i=0;i<nesteledig;i++) {
			str += innleggtabell[i].toString();
		}
		return str;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] nytabell = new Innlegg[innleggtabell.length * 2];
		for (int i=0;i<nesteledig;i++) {
			nytabell[i] = innleggtabell[i];
		}
		innleggtabell = nytabell;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		if (!ledigPlass()) {
			utvid();
		}
		return leggTil(innlegg);
	}
	
	public boolean slett(Innlegg innlegg) {
		for (int i=0;i<nesteledig;i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				nesteledig--;
				innleggtabell[i] = innleggtabell[nesteledig];
				innleggtabell[nesteledig] = null;
				return true;
			}
		}
		return false;
	}
	
	public int[] search(String keyword) {	
		
		throw new UnsupportedOperationException(TODO.method());

	}
}

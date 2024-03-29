package monitor;


/**
* monitor/MonitorOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from distributed-algorithm.idl
* Dienstag, 19. Mai 2015 08:38 Uhr MESZ
*/

public interface MonitorOperations 
{

  /*
          * Bekanntgabe der Ringzusammensetzung.
          * Ring wird als String-Array uebergeben.
          * In dem Array sind die IDs der beteiligten Prozesse anzugeben.
          * Die Ids sollen sich zusammensetzen aus dem Namen des Starters
          * und einer vom Starter vergebenen fortlaufenden Nummer.
          */
  void ring (String[] prozessIds);

  /*
          * Bekanntgabe der Startzahlen der beteiligten Prozesse.
          * Zahlen werden in einem Integer-Array uebergeben.
          * Laenge des Startzahlen-Arrays muss mit der Laenge des Prozessids-Arrays uebereinstimmen.
          */
  void startzahlen (int[] startzahlen);

  /*
          * Mitteilung an den Monitor, dass von einem Prozess eine neue Zahl empfangen wurde.
          * Mitteilung soll auch gesendet werden, wenn die Zahl vom Prozess nicht bearbeitet wurde,
          * weil sie zu gross war.
          * Parameter enthalten die Angaben, welcher Prozess die Zahl empfangen hat, von welchem
          * Prozess sie gesendet wurde und welche Zahl uebertragen wurde.
          */
  void rechnen (String prozessId, String prozessIdAbsender, int num);

  /*
          * Mitteilung an den Monitor, dass von einem Prozess eine Terminierungsanfrage empfangen wurde.
          * Parameter enthalten die Angaben, welcher Prozess die Anfrage empfangen hat, von wem sie
          * urspruenglich gesendet wurde und ob terminiert werden soll.
          */
  void terminieren (String prozessId, String prozessIdAbsender, boolean terminiere);

  /*
          * Mit diesem Aufruf soll der Koordinator das Ergebnis seiner Berechnung an den
          * Monitor uebergeben.
          */
  void ergebnis (String prozessId, int num);
} // interface MonitorOperations

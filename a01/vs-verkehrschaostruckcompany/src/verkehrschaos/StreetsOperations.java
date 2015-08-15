package verkehrschaos;

/**
 * verkehrschaos/StreetsOperations.java . Generated by the IDL-to-Java compiler (portable), version "3.2" from verkehrschaos.idl Samstag, 4. April 2015 19:41 Uhr MESZ
 */

public interface StreetsOperations{

    /* Spedition siedelt sich am angegebenen Ort an. */
    void claim(verkehrschaos.TruckCompany company, String location) throws verkehrschaos.ELocationNotFound, verkehrschaos.ELocationInUse;

    /* Spedition am angegebenen Ort wird aufgegeben. Ort steht nun fuer andere Spedition zur Verfuegung. */
    void free(String location) throws verkehrschaos.ELocationNotFound;

    /* Gibt die Namen aller Orte, an denen sich eine Spedition ansiedeln kann */
    String[] getLocations();

    /* Durchsucht die Liste der angesiedelten Speditionen. */
    verkehrschaos.TruckCompany getTruckCompanyByName(String companyname) throws verkehrschaos.ETruckCompanyUnknown;

    /* Gibt die Spedition, die sich an einem Ort angesiedelt hat. */
    verkehrschaos.TruckCompany getTruckCompanyByLocation(String location) throws verkehrschaos.ELocationNotInUse, verkehrschaos.ELocationNotFound;

    /*
     * Startet einen LKW. Startort ergibt sich aus der Spedition, die dem LKW zugeordnet ist. Zielspedition wird explizit angegeben. Aufruf bewirkt, dass der LKW der Zielspedition angekuendigt wird (advice). Damit ist die Zielspedition die dem LKW zugeordnete Spedition: Zielspedition ruft setCompany vom LKW auf. Zielspedition darf aber erst dann ueber den LKW verfuegen, wenn dieser dort angekommen ist (arrive). LKW setzt sich sofort in Bewegung. Er bekommt seine aktuelle Position staendig mitgeteilt (setCoordinate). */
    void start(verkehrschaos.Truck truck, verkehrschaos.TruckCompany to) throws verkehrschaos.ETruckCompanyUnknown;

    /*
     * Entfernt einen LKW, der gerade unterwegs ist. Der LKW verschwindet unmittelbar von der Karte. Er darf keiner Spedition mehr zugeordnet sein. */
    void remove(verkehrschaos.Truck truck);
} // interface StreetsOperations
package verkehrschaos;

/**
 * verkehrschaos/_StreetsStub.java . Generated by the IDL-to-Java compiler (portable), version "3.2" from verkehrschaos.idl Samstag, 4. April 2015 19:40 Uhr MESZ
 */

public class _StreetsStub extends org.omg.CORBA.portable.ObjectImpl implements verkehrschaos.Streets{

    /* Spedition siedelt sich am angegebenen Ort an. */
    public void claim(verkehrschaos.TruckCompany company, String location) throws verkehrschaos.ELocationNotFound, verkehrschaos.ELocationInUse{
        org.omg.CORBA.portable.InputStream $in = null;
        try{
            org.omg.CORBA.portable.OutputStream $out = _request("claim", true);
            verkehrschaos.TruckCompanyHelper.write($out, company);
            $out.write_string(location);
            $in = _invoke($out);
            return;
        } catch(org.omg.CORBA.portable.ApplicationException $ex){
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            if(_id.equals("IDL:verkehrschaos/ELocationNotFound:1.0"))
                throw verkehrschaos.ELocationNotFoundHelper.read($in);
            else if(_id.equals("IDL:verkehrschaos/ELocationInUse:1.0"))
                throw verkehrschaos.ELocationInUseHelper.read($in);
            else
                throw new org.omg.CORBA.MARSHAL(_id);
        } catch(org.omg.CORBA.portable.RemarshalException $rm){
            claim(company, location);
        } finally{
            _releaseReply($in);
        }
    } // claim

    /* Spedition am angegebenen Ort wird aufgegeben. Ort steht nun fuer andere Spedition zur Verfuegung. */
    public void free(String location) throws verkehrschaos.ELocationNotFound{
        org.omg.CORBA.portable.InputStream $in = null;
        try{
            org.omg.CORBA.portable.OutputStream $out = _request("free", true);
            $out.write_string(location);
            $in = _invoke($out);
            return;
        } catch(org.omg.CORBA.portable.ApplicationException $ex){
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            if(_id.equals("IDL:verkehrschaos/ELocationNotFound:1.0"))
                throw verkehrschaos.ELocationNotFoundHelper.read($in);
            else
                throw new org.omg.CORBA.MARSHAL(_id);
        } catch(org.omg.CORBA.portable.RemarshalException $rm){
            free(location);
        } finally{
            _releaseReply($in);
        }
    } // free

    /* Gibt die Namen aller Orte, an denen sich eine Spedition ansiedeln kann */
    public String[] getLocations(){
        org.omg.CORBA.portable.InputStream $in = null;
        try{
            org.omg.CORBA.portable.OutputStream $out = _request("getLocations", true);
            $in = _invoke($out);
            String $result[] = verkehrschaos.TLocationListHelper.read($in);
            return $result;
        } catch(org.omg.CORBA.portable.ApplicationException $ex){
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            throw new org.omg.CORBA.MARSHAL(_id);
        } catch(org.omg.CORBA.portable.RemarshalException $rm){
            return getLocations();
        } finally{
            _releaseReply($in);
        }
    } // getLocations

    /* Durchsucht die Liste der angesiedelten Speditionen. */
    public verkehrschaos.TruckCompany getTruckCompanyByName(String companyname) throws verkehrschaos.ETruckCompanyUnknown{
        org.omg.CORBA.portable.InputStream $in = null;
        try{
            org.omg.CORBA.portable.OutputStream $out = _request("getTruckCompanyByName", true);
            $out.write_string(companyname);
            $in = _invoke($out);
            verkehrschaos.TruckCompany $result = verkehrschaos.TruckCompanyHelper.read($in);
            return $result;
        } catch(org.omg.CORBA.portable.ApplicationException $ex){
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            if(_id.equals("IDL:verkehrschaos/ETruckCompanyUnknown:1.0"))
                throw verkehrschaos.ETruckCompanyUnknownHelper.read($in);
            else
                throw new org.omg.CORBA.MARSHAL(_id);
        } catch(org.omg.CORBA.portable.RemarshalException $rm){
            return getTruckCompanyByName(companyname);
        } finally{
            _releaseReply($in);
        }
    } // getTruckCompanyByName

    /* Gibt die Spedition, die sich an einem Ort angesiedelt hat. */
    public verkehrschaos.TruckCompany getTruckCompanyByLocation(String location) throws verkehrschaos.ELocationNotInUse, verkehrschaos.ELocationNotFound{
        org.omg.CORBA.portable.InputStream $in = null;
        try{
            org.omg.CORBA.portable.OutputStream $out = _request("getTruckCompanyByLocation", true);
            $out.write_string(location);
            $in = _invoke($out);
            verkehrschaos.TruckCompany $result = verkehrschaos.TruckCompanyHelper.read($in);
            return $result;
        } catch(org.omg.CORBA.portable.ApplicationException $ex){
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            if(_id.equals("IDL:verkehrschaos/ELocationNotInUse:1.0"))
                throw verkehrschaos.ELocationNotInUseHelper.read($in);
            else if(_id.equals("IDL:verkehrschaos/ELocationNotFound:1.0"))
                throw verkehrschaos.ELocationNotFoundHelper.read($in);
            else
                throw new org.omg.CORBA.MARSHAL(_id);
        } catch(org.omg.CORBA.portable.RemarshalException $rm){
            return getTruckCompanyByLocation(location);
        } finally{
            _releaseReply($in);
        }
    } // getTruckCompanyByLocation

    /*
     * Startet einen LKW. Startort ergibt sich aus der Spedition, die dem LKW zugeordnet ist. Zielspedition wird explizit angegeben. Aufruf bewirkt, dass der LKW der Zielspedition angekuendigt wird (advice). Damit ist die Zielspedition die dem LKW zugeordnete Spedition: Zielspedition ruft setCompany vom LKW auf. Zielspedition darf aber erst dann ueber den LKW verfuegen, wenn dieser dort angekommen ist (arrive). LKW setzt sich sofort in Bewegung. Er bekommt seine aktuelle Position staendig mitgeteilt (setCoordinate). */
    public void start(verkehrschaos.Truck truck, verkehrschaos.TruckCompany to) throws verkehrschaos.ETruckCompanyUnknown{
        org.omg.CORBA.portable.InputStream $in = null;
        try{
            org.omg.CORBA.portable.OutputStream $out = _request("start", true);
            verkehrschaos.TruckHelper.write($out, truck);
            verkehrschaos.TruckCompanyHelper.write($out, to);
            $in = _invoke($out);
            return;
        } catch(org.omg.CORBA.portable.ApplicationException $ex){
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            if(_id.equals("IDL:verkehrschaos/ETruckCompanyUnknown:1.0"))
                throw verkehrschaos.ETruckCompanyUnknownHelper.read($in);
            else
                throw new org.omg.CORBA.MARSHAL(_id);
        } catch(org.omg.CORBA.portable.RemarshalException $rm){
            start(truck, to);
        } finally{
            _releaseReply($in);
        }
    } // start

    /*
     * Entfernt einen LKW, der gerade unterwegs ist. Der LKW verschwindet unmittelbar von der Karte. Er darf keiner Spedition mehr zugeordnet sein. */
    public void remove(verkehrschaos.Truck truck){
        org.omg.CORBA.portable.InputStream $in = null;
        try{
            org.omg.CORBA.portable.OutputStream $out = _request("remove", true);
            verkehrschaos.TruckHelper.write($out, truck);
            $in = _invoke($out);
            return;
        } catch(org.omg.CORBA.portable.ApplicationException $ex){
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            throw new org.omg.CORBA.MARSHAL(_id);
        } catch(org.omg.CORBA.portable.RemarshalException $rm){
            remove(truck);
        } finally{
            _releaseReply($in);
        }
    } // remove

    // Type-specific CORBA::Object operations
    private static String[] __ids = {"IDL:verkehrschaos/Streets:1.0"};

    public String[] _ids(){
        return (String[]) __ids.clone();
    }

    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException{
        String str = s.readUTF();
        String[] args = null;
        java.util.Properties props = null;
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, props);
        try{
            org.omg.CORBA.Object obj = orb.string_to_object(str);
            org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate();
            _set_delegate(delegate);
        } finally{
            orb.destroy();
        }
    }

    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException{
        String[] args = null;
        java.util.Properties props = null;
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, props);
        try{
            String str = orb.object_to_string(this);
            s.writeUTF(str);
        } finally{
            orb.destroy();
        }
    }
} // class _StreetsStub

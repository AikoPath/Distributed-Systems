package verkehrschaos;

/**
 * verkehrschaos/StreetsHelper.java . Generated by the IDL-to-Java compiler (portable), version "3.2" from verkehrschaos.idl Samstag, 4. April 2015 19:40 Uhr MESZ
 */

abstract public class StreetsHelper{
    private static String _id = "IDL:verkehrschaos/Streets:1.0";

    public static void insert(org.omg.CORBA.Any a, verkehrschaos.Streets that){
        org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
        a.type(type());
        write(out, that);
        a.read_value(out.create_input_stream(), type());
    }

    public static verkehrschaos.Streets extract(org.omg.CORBA.Any a){
        return read(a.create_input_stream());
    }

    private static org.omg.CORBA.TypeCode __typeCode = null;

    synchronized public static org.omg.CORBA.TypeCode type(){
        if(__typeCode == null){
            __typeCode = org.omg.CORBA.ORB.init().create_interface_tc(verkehrschaos.StreetsHelper.id(), "Streets");
        }
        return __typeCode;
    }

    public static String id(){
        return _id;
    }

    public static verkehrschaos.Streets read(org.omg.CORBA.portable.InputStream istream){
        return narrow(istream.read_Object(_StreetsStub.class));
    }

    public static void write(org.omg.CORBA.portable.OutputStream ostream, verkehrschaos.Streets value){
        ostream.write_Object((org.omg.CORBA.Object) value);
    }

    public static verkehrschaos.Streets narrow(org.omg.CORBA.Object obj){
        if(obj == null)
            return null;
        else if(obj instanceof verkehrschaos.Streets)
            return (verkehrschaos.Streets) obj;
        else if(!obj._is_a(id()))
            throw new org.omg.CORBA.BAD_PARAM();
        else{
            org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate();
            verkehrschaos._StreetsStub stub = new verkehrschaos._StreetsStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }

    public static verkehrschaos.Streets unchecked_narrow(org.omg.CORBA.Object obj){
        if(obj == null)
            return null;
        else if(obj instanceof verkehrschaos.Streets)
            return (verkehrschaos.Streets) obj;
        else{
            org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate();
            verkehrschaos._StreetsStub stub = new verkehrschaos._StreetsStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }

}

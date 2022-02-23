package latke.model;

public class Privilege {

    /**
     * Privilege Record OID.
     */
    public static final String PRIVILEGE_OID = "oId";

    /**
     * Privilege Type.
     * 0 = Group
     * 1 = User
     */
    public static final String PRIVILEGE_TYPE = "privilegeType";

    /**
     * Privilege Target.
     */
    public static final String PRIVILEGE_TARGET = "privilegeTarget";

    /**
     * Privilege Detail.
     * 8 = read(cd directory)
     * 4 =
     * 2 = download
     * 1 = upload(only directory)
     */
    public static final String PRIVILEGE_DETAIL = "privilegeDetail";
}

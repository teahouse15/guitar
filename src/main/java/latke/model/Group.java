package latke.model;

public class Group {

    /**
     * Group OID.
     */
    public static final String GROUP_OID = "oId";

    /**
     * Group Name.
     */
    public static final String GROUP_NAME = "groupName";

    /**
     * Group Level.
     * 0 = Administrator(All Privilege)
     * 1 = Group Leader(Manage Group)
     * 2 = Group User(Read Download)
     * 3 = Other User(Read)
     */
    public static final String GROUP_LEVEL = "groupLevel";
}

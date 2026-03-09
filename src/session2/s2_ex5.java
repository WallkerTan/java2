package src.session2;


interface UserActions {

    default void logActivity(String activity){
        System.out.println("User action: " + activity);
    }

}

interface AdminActions {

    default void logActivity(String activity){
        System.out.println("Admin action: " + activity);
    }

}


class SuperAdmin implements UserActions, AdminActions {

    @Override
    public void logActivity(String activity) {
        // gọi method của từng interface
        UserActions.super.logActivity(activity);
        AdminActions.super.logActivity(activity);

        System.out.println("SuperAdmin handled: " + activity);
    }
}

public class s2_ex5 {
    public static void main(String[] args) {
        SuperAdmin sa = new SuperAdmin();
        sa.logActivity("Delete user");
    }
}

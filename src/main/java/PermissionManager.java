public class PermissionManager {
    private PermissionLevel mCurrentLevel = PermissionLevel.USER;

    public String getPermissionLevel() {
        String role;

        switch(mCurrentLevel) {

            case DEVELOPER:
                role = "DEVELOPER";
                break;

            case ADMIN:
                role = "ADMIN";
                break;

            case USER:
                role = "USER";
                break;
            default:
                throw new IllegalStateException("RESULT: " + mCurrentLevel);
        }
        return role;
    }

    public void get_and_setPermissionLevel(PermissionLevel permissionLevel) {
        mCurrentLevel = permissionLevel;
    }
}

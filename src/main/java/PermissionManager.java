public class PermissionManager {
    private PermissionLevel mCurrentLevel = PermissionLevel.USER;

    public String getPermissionLevel() {
        String role = switch (mCurrentLevel) {
            case DEVELOPER -> "DEVELOPER";
            case ADMIN -> "ADMIN";
            case USER -> "USER";
            default -> throw new IllegalStateException(String.valueOf(mCurrentLevel));
        };

        String result = role;
        return result;
    }

    public void get_and_setPermissionLevel(PermissionLevel permissionLevel) {
        mCurrentLevel = permissionLevel;
    }
}

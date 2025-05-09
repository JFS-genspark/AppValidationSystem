package enums;

public enum BannedDeveloper {
    BadDev123,
    HackerPro,
    SpammerX;

    public static boolean isBanned(String developerName) {
        for (BannedDeveloper dev : values()) {
            if (dev.name().equalsIgnoreCase(developerName)) {
                return true;
            }
        }
        return false;
    }
}

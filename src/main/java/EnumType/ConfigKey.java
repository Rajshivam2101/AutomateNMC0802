package EnumType;

public enum ConfigKey {


    CONFIG_PATH("config.path"),

    BROWSER("browser"),

    URL("url"),

    USERNAME("username"),

    PASSWORD("password"),

    DOCTORNAME("doctorName"),

    DEPETNAME("departmentOfPatient"),

    CONSULTATION("consultationType");

    private final String key;

    ConfigKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}

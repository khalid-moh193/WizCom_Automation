package Utils;

public enum URLs {


    WIX_SITE("https://arielkiell.wixsite.com/interview");
    private String value;

    URLs(String value) {
        this.setValue(value);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

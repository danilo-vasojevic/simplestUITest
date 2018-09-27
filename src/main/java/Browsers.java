public enum Browsers {
    CHROME("chrome"),
    FIREFOX("firefox");

    private String browserName;

    Browsers(String browserName) {
        this.browserName = browserName;
    }

    @Override
    public String toString() { return browserName; }
}

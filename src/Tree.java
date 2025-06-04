public class Tree {
    private int id;
    private String name;
    private double lng;
    private double lat;
    private String type;
    private boolean isSick;

    public Tree(int id, String name, double lng, double lat, String type, boolean isSick) {
        this.id = id;
        this.name = name;
        this.lng = lng;
        this.lat = lat;
        this.type = type;
        this.isSick = isSick;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSick() {
        return isSick;
    }

    public void setSick(boolean sick) {
        isSick = sick;
    }
}

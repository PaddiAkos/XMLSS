public class XMLModel {
    private int id;
    private String tool;

    private String type2;

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    private String size;

    public XMLModel() {
    }

    public XMLModel(int id, String answername, String postedby) {
        super();
        this.id = id;
        this.tool = answername;
        this.size = postedby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}
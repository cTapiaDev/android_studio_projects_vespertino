package cl.bootcamp.claserecyclerview;

public class ListElement {

    private String color;
    private String name;
    private String colorName;
    private String subtitle;
    private String title;

    public ListElement(
            String color,
            String name,
            String colorName,
            String subtitle,
            String title
    ) {
        this.color = color;
        this.name = name;
        this.colorName = colorName;
        this.subtitle = subtitle;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
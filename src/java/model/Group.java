
package model;

public class Group {
    private int id;
    private boolean isPrivate;
    private String background;
    private String description;
    private String name;

    public Group() {
    }

    public Group(int id, boolean isPrivate, String background, String description, String name) {
        this.id = id;
        this.isPrivate = isPrivate;
        this.background = background;
        this.description = description;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}

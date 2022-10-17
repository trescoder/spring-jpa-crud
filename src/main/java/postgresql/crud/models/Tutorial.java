package postgresql.crud.models;


import javax.persistence.*;

@Entity // indicates that the class is persistent Java class
@Table(name = "tutorials") // annotation provides the table that maps this entity
public class Tutorial {
    @Id // annotates this attribute as the primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // makes the database auto generate this value
    private long id;
    @Column(name = "title") // defines a column in the database
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "published")
    private boolean published;

    public Tutorial() {
    }

    public Tutorial(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    @Override
    public String toString(){
        return String.format("Tutorial [id=%l, title=%s, desc=%s, published=$b", id, title, description, published);
    }
}

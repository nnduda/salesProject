package pl.edu.wszib.model;

public class Product {
    private Long id;
    private String category;
    private String name;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Product(String category, String name, Long id) {
        this.category = category;
        this.name = name;
        this.id= id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

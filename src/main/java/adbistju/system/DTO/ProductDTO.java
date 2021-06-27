package adbistju.system.DTO;

import adbistju.system.repo.Product;

public class ProductDTO {

    private long id;
    private String  category;
    private String title;
    private int price;

    public ProductDTO(String category, String title, int price) {
        this.category = category;
        this.title = title;
        this.price = price;
    }

    public ProductDTO() {
    }

    public long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product getProduct(){
        return new Product(category,title,price);
    }
}

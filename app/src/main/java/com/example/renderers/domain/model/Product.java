package com.example.renderers.domain.model;

public class Product extends Publication {

    private String price;
    private boolean like;
    private boolean prominent;

    public Product(){
        super();
    }

    public Product(int id, String photo, String title, String price, boolean like, boolean prominent) {
        super(id, photo, title);
        this.price = price;
        this.like = like;
        this.prominent = prominent;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }


    public boolean isProminent() {
        return prominent;
    }

    public void setProminent(boolean prominent) {
        this.prominent = prominent;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Product) {
            Product other = (Product) obj;
            return price.equals(other.price)
                    && like == other.like
                    && prominent == other.prominent;
        } else {
            return false;
        }
    }


}

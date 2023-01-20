package com.coherentsolutions.domain;

public class Product {
    private String name;
    private Double price;
    private Double rate;

    //add Builder
    public static ProductBuilder newProductBuilder() {
        return new Product().new ProductBuilder();
    }

    public class ProductBuilder {
        private String name;
        private double rate;
        private double price;

        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder setRate(double rate) {
            this.rate = rate;
            return this;
        }

        public Product build() {
            Product.this.name = this.name;
            Product.this.price = this.price;
            Product.this.rate = this.rate;
            return Product.this;
        }
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rate=" + rate +
                '}';
    }
}

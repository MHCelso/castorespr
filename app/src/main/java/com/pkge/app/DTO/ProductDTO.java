package com.pkge.app.DTO;


import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private Double price;
    private Integer quantity;
    private String createdAt;
    private String updatedAt;
    private String deletedAt;
    private String status;
    private String addedByName;

    private ProductDTO(Builder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.quantity = builder.quantity;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.deletedAt = builder.deletedAt;
        this.status = builder.status;
        this.addedByName = builder.addedByName;
    }


    public static class Builder {
        private String name;
        private Double price;
        private Integer quantity;
        private String createdAt;
        private String updatedAt;
        private String deletedAt;
        private String status;
        private String addedByName;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder price(Double price) {
            this.price = price;
            return this;
        }

        public Builder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder deletedAt(String deletedAt) {
            this.deletedAt = deletedAt;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder addedByName(String addedByName) {
            this.addedByName = addedByName;
            return this;
        }

        public ProductDTO build() {
            return new ProductDTO(this);
        }
    }
}

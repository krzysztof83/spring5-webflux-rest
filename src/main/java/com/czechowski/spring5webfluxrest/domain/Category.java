package com.czechowski.spring5webfluxrest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    private String id;

    private String description;

    public static CategoryBuilder builder() {
        return new CategoryBuilder();
    }

    public static class CategoryBuilder {
        private String id;
        private String description;

        CategoryBuilder() {
        }

        public CategoryBuilder id(String id) {
            this.id = id;
            return this;
        }

        public CategoryBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Category build() {
            return new Category(id, description);
        }

        public String toString() {
            return "Category.CategoryBuilder(id=" + this.id + ", description=" + this.description + ")";
        }
    }
}

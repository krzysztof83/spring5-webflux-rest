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
public class Vendor {

    @Id
    private String id;
    private String firstname;
    private String lastname;

    public static VendorBuilder builder() {
        return new VendorBuilder();
    }

    public static class VendorBuilder {
        private String id;
        private String firstname;
        private String lastname;

        VendorBuilder() {
        }

        public VendorBuilder id(String id) {
            this.id = id;
            return this;
        }

        public VendorBuilder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public VendorBuilder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Vendor build() {
            return new Vendor(id, firstname, lastname);
        }

        public String toString() {
            return "Vendor.VendorBuilder(id=" + this.id + ", firstname=" + this.firstname + ", lastname=" + this.lastname + ")";
        }
    }
}

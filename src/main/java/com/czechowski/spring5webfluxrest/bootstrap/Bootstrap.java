package com.czechowski.spring5webfluxrest.bootstrap;

import com.czechowski.spring5webfluxrest.domain.Category;
import com.czechowski.spring5webfluxrest.domain.Vendor;
import com.czechowski.spring5webfluxrest.repository.CategoryRepository;
import com.czechowski.spring5webfluxrest.repository.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadCategory();
        loadVendors();
    }

    private void loadCategory() {

        if (categoryRepository.count().block() == 0) {
            System.out.println("##### Load Category in Bootstrap");

            categoryRepository.save(Category.builder().description("Fruits").build()).block();
            categoryRepository.save(Category.builder().description("Nuts").build()).block();
            categoryRepository.save(Category.builder().description("Breads").build()).block();
            categoryRepository.save(Category.builder().description("Meats").build()).block();
            categoryRepository.save(Category.builder().description("Eggs").build()).block();

            System.out.println("Loaded Categories: " + categoryRepository.count().block());
        }
    }

    private void loadVendors() {

        if (vendorRepository.count().block() == 0) {
            System.out.println("##### Load Vendor in Bootstrap");

            vendorRepository.save(Vendor.builder().firstname("Joe").lastname("Brown").build()).block();
            vendorRepository.save(Vendor.builder().firstname("Bill").lastname("Benet").build()).block();
            vendorRepository.save(Vendor.builder().firstname("Michael").lastname("Black").build()).block();
            vendorRepository.save(Vendor.builder().firstname("Tom").lastname("Hill").build()).block();

            System.out.println("Loaded Vendors: " + vendorRepository.count().block());
        }
    }
}

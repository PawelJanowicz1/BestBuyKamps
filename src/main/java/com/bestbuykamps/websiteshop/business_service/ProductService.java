package com.bestbuykamps.websiteshop.business_service;
import com.bestbuykamps.websiteshop.data_model.Product;
import com.bestbuykamps.websiteshop.data_model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }
    public void addProduct(Product product) {
        if(product==null) throw new RuntimeException("Product cannot be null");
        this.productRepository.save(product);
    }
    public void deleteProduct(Product product) {
        if(product==null) throw new RuntimeException("Product cannot be null");
        // możnaby pewnie dodać jeszcze zabezpieczenie, gdy nie ma takiego w bazie
        this.productRepository.delete(product);
    }
}
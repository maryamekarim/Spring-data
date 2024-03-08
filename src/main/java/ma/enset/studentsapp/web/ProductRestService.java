package ma.enset.studentsapp.web;

import ma.enset.studentsapp.entities.Product;
import ma.enset.studentsapp.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestService {
    private ProductRepository productRepository;
    @GetMapping("/products")
    public List<Product> products(){
        return productRepository.findAll();
    }
    @GetMapping("/products/{id}")
    public List<Product> findProduct(@PathVariable Long id){
        return productRepository.findById(id).get();
    }
}

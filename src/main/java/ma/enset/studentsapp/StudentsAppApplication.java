package ma.enset.studentsapp;

import ma.enset.studentsapp.entities.Product;
import ma.enset.studentsapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class StudentsAppApplication implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;
	public static void main(String[] args) {

		SpringApplication.run(StudentsAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product(null,"computer",4309,23));
		productRepository.save(new Product(null,"printer ",9000,13));
		productRepository.save(new Product(null,"smart phone",1300,99));
		List<Product> products = productRepository.findAll();
		products.forEach(p->{
			System.out.println(p.toString());
		});
		Product product = productRepository.findById(Long.valueOf(1)).get();
		System.out.println("**************************");
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getQuantity());
		System.out.println("**************************");
        List<Product> productlist = productRepository.findByNameContains("c");
        System.out.println("----------------");
        productlist.forEach(p->{
            System.out.println(p);
        });
		System.out.println("----------------");
		List<Product> productlist2 = productRepository.search("%c%");
		productlist.forEach(p->{
			System.out.println(p);
		});

		System.out.println("----------------");
		List<Product> productlist3 = productRepository.findByPriceGreaterThan(3000.0);
		productlist3.forEach(p->{
			System.out.println(p);
		});
	}
}

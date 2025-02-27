package parcialCorteCVDS.demo.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import parcialCorteCVDS.demo.model.Product;
import parcialCorteCVDS.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        service.add(product);
    }

    @PutMapping("/modify")
    public void updateProduct(@RequestParam String name, @RequestParam int quantity) {
        service.update(name, quantity);
    }
}

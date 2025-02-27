package parcialCorteCVDS.demo.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import parcialCorteCVDS.demo.model.*;

@Service
public class ProductService {
    private final Inventory inventory;

    @Autowired
    public ProductService(Inventory inventory) {
        this.inventory = inventory;
    }

    public void add(Product product) {
        inventory.add(product);
    }

    public void update(String name, int quantity) {
        inventory.update(name, quantity);
    }
}

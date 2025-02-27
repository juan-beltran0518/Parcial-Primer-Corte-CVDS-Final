package parcialCorteCVDS.demo.model;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class Inventory {
    private final List<ObserverAgent> agents = new ArrayList<>();
    private final List<Product> products = new ArrayList<>();

    public void add(Product product) {
        boolean exists = false;
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(product.getName())) {
                p.setQuantity(p.getQuantity() + product.getQuantity());
                exists = true;
                break;
            }
        }
        if (!exists) {
            products.add(product);
        }
        notifyAgents(product);
    }

    public void update(String productName, int quantity) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(productName)) {
                p.setQuantity(quantity);
                notifyAgents(p);
                break;
            }
        }
    }

    public void addAgent(ObserverAgent agent) {
        agents.add(agent);
    }

    private void notifyAgents(Product product) {
        for (ObserverAgent agent : agents) {
            agent.notify(product);
        }
    }
}

package parcialCorteCVDS.demo.model;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class StockWarningAgent implements ObserverAgent {
    private final List<String> notifications = new ArrayList<>();

    @Override
    public void notify(Product product) {
        if (product.getQuantity() < 5) {
            String notification = "ALERT!!! Product: " + product.getName() +
                    " is very low in stock, only " + product.getQuantity() + " units left.";
            System.out.println(notification);
            notifications.add(notification);
        }
    }

    public List<String> getNotifications() {
        return notifications;
    }
}

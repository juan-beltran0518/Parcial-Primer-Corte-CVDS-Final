package parcialCorteCVDS.demo.model;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class StockWarningAgent implements ObserverAgent {
    private static final int LOW_STOCK_THRESHOLD = 5;
    @Override
    public void notify(Product product) {
        if (product.getQuantity() < LOW_STOCK_THRESHOLD) {
            String notification = "ALERT!!! Product: " + product.getName() +
                    " is very low in stock, only " + product.getQuantity() + " units left.";
            System.out.println(notification);
            notifications.add(notification);
        }
    }
    private final List<String> notifications = new ArrayList<>();

    public List<String> getNotifications() {
        return notifications;
    }
}

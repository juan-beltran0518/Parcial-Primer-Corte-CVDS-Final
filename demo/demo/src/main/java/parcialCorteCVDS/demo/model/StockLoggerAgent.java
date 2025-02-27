package parcialCorteCVDS.demo.model;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class StockLoggerAgent implements ObserverAgent {
    private final List<String> notifications = new ArrayList<>();

    @Override
    public void notify(Product product) {
        String notification = "Product: " + product.getName() + " -> " + product.getQuantity() + " units available";
        System.out.println(notification);
        notifications.add(notification);
    }

    public List<String> getNotifications() {
        return notifications;
    }
}

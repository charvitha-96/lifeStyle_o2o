import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StoreService {
    public void registerStore(Store store) {
        // Business logic for store registration
        // Exception handling
    }

    public void updateStore(Store store) {
        // Business logic for updating store
        // Exception handling
    }

    public List<Store> searchNearbyStores(double latitude, double longitude) {
        // Use Haversine formula to find nearby stores
        // Exception handling
        return null;
    }

    public Store getStoreDetails(Long storeId) {
        // Business logic to get store details
        // Exception handling
        return null;
    }
}
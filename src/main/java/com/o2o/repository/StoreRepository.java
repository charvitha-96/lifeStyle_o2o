package com.o2o.repository;

import com.o2o.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Store Repository
 * Data access layer for Store entity
 */
@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

    /**
     * Find all active stores by owner
     */
    List<Store> findByOwnerUserIdAndIsActiveTrue(Integer ownerId);

    /**
     * Find stores by name (search functionality)
     */
    List<Store> findByStoreNameContainingIgnoreCaseAndIsActiveTrue(String storeName);

    /**
     * Find all nearby stores using Haversine formula
     * Distance calculation: 6371 * acos(sin(lat1)*sin(lat2) + cos(lat1)*cos(lat2)*cos(lon2-lon1))
     * 
     * @param userLatitude User's latitude
     * @param userLongitude User's longitude
     * @param radiusKm Search radius in kilometers
     * @return List of stores within the specified radius
     */
    @Query(value = "SELECT * FROM stores s "+
           "WHERE s.is_active = TRUE "+
           "AND (6371 * acos(sin(radians(:userLatitude))*sin(radians(s.latitude)) + "+
           "cos(radians(:userLatitude))*cos(radians(s.latitude))*cos(radians(s.longitude-:userLongitude)))) <= :radiusKm "+
           "ORDER BY (6371 * acos(sin(radians(:userLatitude))*sin(radians(s.latitude)) + "+
           "cos(radians(:userLatitude))*cos(radians(s.latitude))*cos(radians(s.longitude-:userLongitude)))) ASC",
           nativeQuery = true)
    List<Store> findNearbyStores(
            @Param("userLatitude") Double userLatitude,
            @Param("userLongitude") Double userLongitude,
            @Param("radiusKm") Double radiusKm
    );

    /**
     * Count stores by owner
     */
    Long countByOwnerUserIdAndIsActiveTrue(Integer ownerId);

    /**
     * Check if store exists with given ID and is active
     */
    Boolean existsByStoreIdAndIsActiveTrue(Integer storeId);
}
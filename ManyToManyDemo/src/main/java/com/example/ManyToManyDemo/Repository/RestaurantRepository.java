package com.example.ManyToManyDemo.Repository;

import com.example.ManyToManyDemo.Entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity,Integer> {
    @Modifying
    @Query("DELETE FROM RestaurantEntity r WHERE r.restaurantID = :restaurantId")
    void deleteRestaurantAndMappings(@Param("restaurantId") int restaurantId);

}

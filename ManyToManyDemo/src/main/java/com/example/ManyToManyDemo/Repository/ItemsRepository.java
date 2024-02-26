package com.example.ManyToManyDemo.Repository;

import com.example.ManyToManyDemo.Entity.ItemsEntity;
import com.example.ManyToManyDemo.Entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<ItemsEntity,Integer> {

    @Modifying
    @Query("DELETE FROM ItemsEntity r WHERE r.itemID = :itemID")
    void deleteItemsAndMappings(@Param("itemID") int itemID);

}

package org.haytap.repository;

import java.util.List;

import org.haytap.model.Food;
import org.haytap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

	List<Food> findByUser(User user);

	List<Food> findAllByOrderByIdDesc();

	List<Food> findAllByOrderByIdAsc();

}

package org.haytap.service;

import java.util.List;

import org.haytap.model.Food;
import org.haytap.model.User;

public interface FoodService {

	public Food addFood(Food food);

	List<Food> listAll(User user);

}

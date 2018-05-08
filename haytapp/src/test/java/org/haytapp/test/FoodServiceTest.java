package org.haytapp.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.haytap.HaytappWebApplicationBoot;
import org.haytap.model.Food;
import org.haytap.model.User;
import org.haytap.repository.FoodRepository;
import org.haytap.repository.UserRepository;
import org.haytap.service.FoodService;
import org.haytap.service.UserService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HaytappWebApplicationBoot.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FoodServiceTest {

	@Autowired
	private FoodService foodService;

	@Autowired
	private UserService userService;

	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void addFoodSuccess() {

		User user = findUser("ardabakan");

		int previousSize = foodService.listAll(user).size();

		Food newFood = new Food();
		newFood.setLabel("Some Food Label");
		newFood.setDescription("Still Edible");
		newFood.setWeight(4L);
		newFood.setUser(user);

		foodService.addFood(newFood);

		int newSize = foodService.listAll(user).size();

		assertEquals(1, newSize - previousSize);

	}

	protected User findUser(String name) {
		User user = userService.findByUsername(name);
		if (user == null) {
			fail(name + " doesn't exist");
		}
		return user;
	}

}

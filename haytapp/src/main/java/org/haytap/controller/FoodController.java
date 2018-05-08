package org.haytap.controller;

import org.haytap.model.Food;
import org.haytap.model.User;
import org.haytap.repository.FoodRepository;
import org.haytap.repository.UserRepository;
import org.haytap.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FoodController {

	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FoodService foodService;

	@RequestMapping(value = "/addfood", method = RequestMethod.POST)
	public @ResponseBody String addFoodJSON(@RequestBody Food food) {

		try {
			org.springframework.security.core.userdetails.User userSpring = (org.springframework.security.core.userdetails.User) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();

			String username = userSpring.getUsername(); // get logged in
														// username

			User user = userRepository.findByUsername(username);

			food.setUser(user);

			foodService.addFood(food);

			return "JSON: Food has been added for " + username;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failed to insert food";
		}
	}
}

package org.haytap;

import java.security.Principal;
import java.util.Iterator;
import java.util.List;

import org.haytap.model.Food;
import org.haytap.repository.FoodRepository;
import org.haytap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/foods")
public class FoodRestService {

	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Food> allAvailableFoods(
			@AuthenticationPrincipal Principal principal) {

		List result = foodRepository.findAllByOrderByIdDesc();

		if (result != null && !result.isEmpty()) {

			for (Iterator iterator = result.iterator(); iterator.hasNext();) {
				Food food = (Food) iterator.next();
				food.getUser().setPassword("");

			}

		}

		return result;
	}
	
	@RequestMapping(value = "/listasc", method = RequestMethod.GET)
	public List<Food> allAvailableFoodsAsc(
			@AuthenticationPrincipal Principal principal) {

		List result = foodRepository.findAllByOrderByIdAsc();

		if (result != null && !result.isEmpty()) {

			for (Iterator iterator = result.iterator(); iterator.hasNext();) {
				Food food = (Food) iterator.next();
				food.getUser().setPassword("");

			}

		}

		return result;
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public Food foodDetail(@PathVariable("id") Long id,
			@AuthenticationPrincipal Principal principal) {

		Food food = foodRepository.findOne(id);

		if (food != null) {
			food.getUser().setPassword("");
			food.getUser().setPasswordConfirm("");
		}

		return food;

	}

}

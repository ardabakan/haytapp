package org.haytap.service;

import java.util.Collections;
import java.util.List;

import org.haytap.model.Food;
import org.haytap.model.User;
import org.haytap.repository.FoodRepository;
import org.haytap.repository.UserRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public Food addFood(Food food) {

		try {

			return foodRepository.save(food);

		} catch (DataIntegrityViolationException e) {
			throw new ServiceException(e.getMessage(), e);
		}

	}

	@Override
	public List<Food> listAll(User user) {

		User persistentUser = userRepository.findOne(user.getId());

		List result = foodRepository.findByUser(persistentUser);

		if (result == null) {

			return Collections.EMPTY_LIST;

		} else {
			
			return result;
		}

	}
}

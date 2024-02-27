package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.helper.Constants;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void creatUser(User user, MultipartFile image) {
		// TODO Auto-generated method stub
		if (image != null) {
			String path = Constants.BASE_DIR + Constants.BANNER_LOCATION;
			String fname = Constants.getRandom() + user.getEmail() + image.getOriginalFilename();
			String fileName = Constants.saveMultiPartFile(image, path, fname);
			String url = Constants.BASE_IP + Constants.BANNER_LOCATION;
			System.out.println(url);
			user.setFile(fileName);
			user.setUrl(url);
			userRepository.save(user);

		}
	}

	public void updateUser(User user, Optional<User> data) {
		// TODO Auto-generated method stub
		User ndata = data.get();
		ndata.setName(user.getName());
		ndata.setEmail(user.getEmail());
		ndata.setFile(user.getFile());
		userRepository.save(ndata);

	}

	public void deleteuserById(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
		
	}

	
}

package com.medihub.demo.service;

import com.medihub.demo.entity.User;
import com.medihub.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(User u) { return userRepository.save(u); }
    public Optional<User> findByEmail(String e) { return userRepository.findByEmail(e); }
    public Optional<User> findById(Long id) { return userRepository.findById(id); }
}

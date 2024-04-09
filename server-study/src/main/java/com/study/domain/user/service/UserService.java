package com.study.domain.user.service;
import com.study.domain.user.domain.User;
import com.study.domain.user.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    // 사용자 추가 메소드
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // 사용자 조회 메소드
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    // 사용자 삭제 메소드
    public void deleteUser(User user) { userRepository.delete(user); }
}
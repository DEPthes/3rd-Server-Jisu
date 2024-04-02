package com.study;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.study.domain.user.domain.User;
import com.study.domain.user.domain.repository.UserRepository;
import com.study.domain.user.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

// JUniit5와 Mockito를 연동하기 위해
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;    // 가짜 객체 생성

    @InjectMocks
    private UserService userService;   // 가짜 객체 주입

    private User testUser;

    @BeforeEach
    public void setUp() {
        testUser = new User();
        testUser.setId(1L);
        testUser.setName("user");
        testUser.setEmail("user01@example.com");
    }

    @DisplayName("사용자 추가 테스트")
    @Test
    public void testCreateUser() {
        // Given
        when(userRepository.save(testUser)).thenReturn(testUser);

        // When
        User addedUser = userService.addUser(testUser);

        // Then
        assertEquals(testUser.getName(), addedUser.getName());
        assertEquals(testUser.getEmail(), addedUser.getEmail());
    }

    @DisplayName("사용자 조회 테스트")
    @Test
    public void testGetUserById() {
        // Given
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));

        // When
        User retrievedUser = userService.getUserById(1L);

        // Then
        assertEquals(testUser.getId(), retrievedUser.getId());
        assertEquals(testUser.getName(), retrievedUser.getName());
        assertEquals(testUser.getEmail(), retrievedUser.getEmail());
    }
}
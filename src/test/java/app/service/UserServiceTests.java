package app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import app.entity.User;
import app.repository.UserRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("UserService")
@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock
    transient UserRepository userRepository;

    @InjectMocks
    transient UserService userService;

    @Test
    @DisplayName("#findAll returns an array of users")
    void findAll() {
        when(userRepository.findAll()).thenReturn(new ArrayList<>());

        assertThat(userService.findAll()).isEqualTo(new ArrayList<>());
    }

    @Test
    @DisplayName("#findById returns an user")
    void findById() {
        Optional<User> user = Optional.of(new User());
        when(userRepository.findById(1)).thenReturn(user);

        assertThat(userService.findById(1)).isInstanceOf(User.class);
    }

    @Test
    @DisplayName("#create returns a new user")
    void createUser() {
        when(userRepository.save(any(User.class))).thenReturn(new User());

        assertThat(userService.create(new User())).isInstanceOf(User.class);
    }

    @Test
    @DisplayName("#update returns an updated user")
    void updateUser() {
        when(userRepository.save(any(User.class))).thenReturn(new User());

        assertThat(userService.update(1, new User())).isInstanceOf(User.class);
    }

    @Test
    @DisplayName("#delete deletes the current user")
    void deleteUser() {
        userService.delete(1);

        verify(userRepository).deleteById(1);
    }
}

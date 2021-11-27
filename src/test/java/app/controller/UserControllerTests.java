package app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import app.entity.User;
import app.service.UserService;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("UserController")
@ExtendWith(MockitoExtension.class)
public class UserControllerTests {

    @Mock
    transient UserService userService;

    @InjectMocks
    transient UserController userController;

    @Test
    @DisplayName("#findAll returns an array of users")
    void findAll() {
        when(userService.findAll()).thenReturn(new ArrayList<>());

        assertThat(userController.findAll()).isEqualTo(new ArrayList<>());
    }

    @Test
    @DisplayName("#findById returns an user")
    void findById() {
        User user = new User();
        when(userService.findById(1)).thenReturn(user);

        assertThat(userController.findById(1)).isEqualTo(user);
    }

    @Test
    @DisplayName("#create returns a new user")
    void createUser() {
        User user = new User();
        when(userService.create(user)).thenReturn(user);

        assertThat(userController.create(user)).isEqualTo(user);
    }

    @Test
    @DisplayName("#update returns an updated user")
    void updateUser() {
        User user = new User();
        when(userService.update(1, user)).thenReturn(user);

        assertThat(userController.update(1, user)).isEqualTo(user);
    }

    @Test
    @DisplayName("#delete calls #delete method")
    void deleteUser() {
        userController.delete(1);

        verify(userService).delete(1);
    }
}

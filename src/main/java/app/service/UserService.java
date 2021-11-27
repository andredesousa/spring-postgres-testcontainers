package app.service;

import app.entity.User;
import app.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private transient UserRepository userRepository;

    /**
     * Gets a list of users.
     * @return A list of users.
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Gets a user by id.
     * @param id - The id of the user.
     * @return The user.
     */
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow();
    }

    /**
     * Creates a user.
     * @param user - The user to insert.
     * @return The inserted user.
     */
    public User create(User user) {
        return userRepository.save(user);
    }

    /**
     * Updates a user.
     * @param id - The id of the user.
     * @param user - The user to update.
     * @return The updated user.
     */
    public User update(Integer id, User user) {
        return userRepository.save(user);
    }

    /**
     * Deletes a user by id.
     * @param id - The id of the user to delete.
     */
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}

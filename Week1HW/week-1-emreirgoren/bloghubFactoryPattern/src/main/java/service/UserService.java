package service;

import factory.IService;
import model.User;
import model.enums.StatusType;
import repository.UserRepository;
import util.GenerateHashPassword;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserService implements IService {

    private UserRepository userRepository = new UserRepository();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserService(){

    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    GenerateHashPassword hashPasswordGenerate = new GenerateHashPassword();


    public User saveUser(String email, String password) {

        User user = new User(email, password); // ödev password' hash'le

        userRepository.save(user);

        return user;
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("user bulunamadı: " + email) );
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();

    }

    public void changeStatus(String email, StatusType statusType) {
        getUserByEmail(email).setStatusType(statusType);
    }

    public void changeStatus(List<String> emailList, StatusType statusType) {

        Map<String, User> allUsersMap = getAllUsersMap();

        emailList.forEach(email -> {

            User user = allUsersMap.get(email);
            user.setStatusType(statusType);
        });

    }

    public void changeStatus2(List<String> emailList, StatusType statusType) {
        emailList.forEach(email -> changeStatus(email, statusType));
    }

    public Map<String, User> getAllUsersMap() {
        return getAll().stream()
                .collect(Collectors.toMap(User::getEmail, Function.identity()));
    }




    /*public User getUserByName(String name) {

        return userRepository.getUserByName(name).orElseThrow(() -> new NullPointerException("User Bulunamadı"));
    }*/
}

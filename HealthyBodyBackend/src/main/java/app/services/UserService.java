package app.services;


import app.entities.User;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;


@ApplicationScoped
public class UserService {




    public User findByEmail(String mail){
        return User.find("email", mail).firstResult();
    }

    public List<User> allUsers(){
        return User.findAll().list();
    }

    @Transactional
    public User addUser(User user){
        //pas rajouter un user dont le mail existe deja, throw une erreur

        User userAvecUnMailquiExisteDeja=findByEmail(user.getEmail());

        if (userAvecUnMailquiExisteDeja!=null){
            throw new IllegalArgumentException("User avec ce mail existe deja bgs!");
        }else{
            user.persist();
            return user;
        }
    }

}

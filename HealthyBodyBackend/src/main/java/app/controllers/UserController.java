package app.controllers;

import app.entities.User;
import app.services.UserService;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/users")
public class UserController {

//
//    private final UserService service;
//
//    public UserController(UserService service) {
//        this.service = service;
//    }

    @Inject
    UserService service;

    @Path("{email}")
    @GET
    public User getOneUserByMail(String email){
        return service.findByEmail(email);
    }

    @GET
    public List<User> getAllUsers(){
        return service.allUsers();
    }


    @POST
    public Response addUser(User user){
        try{
            User savedUser= service.addUser(user);
            return Response.status(Response.Status.CREATED)
                    .entity(savedUser)
                    .build();
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Entity creating user: " + e.getMessage())
                    .build();
        }
    }

}

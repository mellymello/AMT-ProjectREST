/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.api;

import ch.heigvd.amt.amtproject.dto.UserDTO;
import ch.heigvd.amt.amtproject.model.User;
import ch.heigvd.amt.amtproject.services.UserManagerLocal;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Calixte
 */
@Path("users")
@Stateless
public class UserResource {
    
    @EJB
    UserManagerLocal userManager;
    
    @Context
    private UriInfo context;
    
    public UserResource (){}
    
    @GET
    @Produces("application/json")
    public List<UserDTO> getAllUsers ()
    {
        List<User> users = userManager.findAllUser();
        List<UserDTO> result = new LinkedList<>();
        
        for(User user : users)
        {
            result.add(toDTO(user));
        }
        return result;
    }
    
    @Path("{/id}")
    @GET
    @Produces("application/json")
    public UserDTO getUserDetails (@PathParam("id") long id)
    {
        User user = userManager.findUserById(id);
        return toDTO(user);
    }
    
    @POST
    @Consumes("application/json")
    public long createUser (UserDTO userDTO)
    {
        User newUser = new User();
        long id = userManager.createUser(toUser(userDTO,newUser));
        return id;
    }  
    
    @Path("{/id}")
    @PUT
    @Produces("application/json")
    public void updateUser (@PathParam("id") long id, UserDTO dto)
    {
        User existing = userManager.findUserById(id);
        userManager.updateUser(toUser(dto, existing));
    }
    
    @Path("{/id}")
    @DELETE
    public void deleteUser (@PathParam("id") long id)
    {
        userManager.deleteUser(id);
    }

    private UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setOrganisation(user.getOrganisation());
        return userDTO;
    }

    private User toUser(UserDTO userDTO, User original) {
        original.setId(userDTO.getId());
        original.setUsername(userDTO.getUsername());
        original.setEmail(userDTO.getEmail());
        original.setOrganisation(userDTO.getOrganisation());
        return original;
    }
}

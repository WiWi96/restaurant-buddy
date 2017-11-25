package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Dish;
import io.swagger.model.Order;
import java.util.UUID;
import io.swagger.model.User;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-24T19:28:58.171Z")
public abstract class AdminApiService {
    public abstract Response addDish(Dish dish,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addUser(User user,SecurityContext securityContext) throws NotFoundException;
    public abstract Response allDishes(SecurityContext securityContext) throws NotFoundException;
    public abstract Response allOrders(SecurityContext securityContext) throws NotFoundException;
    public abstract Response allUsers(SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteDish(UUID id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteOrder(UUID id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteUser(UUID id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response dishDetails(UUID id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findOrder(UUID id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findUser(UUID id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateDish(UUID id,Dish dish,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateOrder(UUID id,Order user,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateUser(UUID id,User user,SecurityContext securityContext) throws NotFoundException;
}

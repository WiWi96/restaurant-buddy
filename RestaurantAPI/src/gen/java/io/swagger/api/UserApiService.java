package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

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
public abstract class UserApiService {
    public abstract Response addDishToOrder(String id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response addUserOrder(Order order,SecurityContext securityContext) throws NotFoundException;
    public abstract Response allUserDishes(SecurityContext securityContext) throws NotFoundException;
    public abstract Response allUserOrders(SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteUserOrder(UUID id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response findUserOrder(UUID id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getDish(String id,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateUserOrder(UUID id,Order user,SecurityContext securityContext) throws NotFoundException;
}

package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.UserApiService;
import io.swagger.api.factories.UserApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Order;
import java.util.UUID;
import io.swagger.model.User;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/user")


@io.swagger.annotations.Api(description = "the user API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-24T19:28:58.171Z")
public class UserApi  {
   private final UserApiService delegate;

   public UserApi(@Context ServletConfig servletContext) {
      UserApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("UserApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (UserApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = UserApiServiceFactory.getUserApi();
      }

      this.delegate = delegate;
   }

    @POST
    @Path("/dish/{id}")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add dish to order", notes = "", response = User.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "User is added", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid username supplied", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Page not found", response = User.class) })
    public Response addDishToOrder(@ApiParam(value = "id of dish to add.",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addDishToOrder(id,securityContext);
    }
    @POST
    @Path("/order")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add order", notes = "", response = Order.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "successful operation", response = Order.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Page not found", response = Order.class) })
    public Response addUserOrder(@ApiParam(value = "Order" ,required=true) Order order
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addUserOrder(order,securityContext);
    }
    @GET
    @Path("/dishes")
    @Consumes({ "application/x-www-form-urlencoded" })
    
    @io.swagger.annotations.ApiOperation(value = "Get all dishes", notes = "", response = Order.class, responseContainer = "List", tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Order.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Page not found", response = Order.class, responseContainer = "List") })
    public Response allUserDishes(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.allUserDishes(securityContext);
    }
    @GET
    @Path("/orders")
    @Consumes({ "application/x-www-form-urlencoded" })
    
    @io.swagger.annotations.ApiOperation(value = "Get all orders", notes = "", response = Order.class, responseContainer = "List", tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Order.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Page not found", response = Order.class, responseContainer = "List") })
    public Response allUserOrders(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.allUserOrders(securityContext);
    }
    @DELETE
    @Path("/order/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete order", notes = "", response = void.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "User is deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = void.class) })
    public Response deleteUserOrder(@ApiParam(value = "Order id",required=true) @PathParam("id") UUID id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteUserOrder(id,securityContext);
    }
    @GET
    @Path("/order/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Find order", notes = "", response = Order.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Order.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = Order.class) })
    public Response findUserOrder(@ApiParam(value = "Order id",required=true) @PathParam("id") UUID id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findUserOrder(id,securityContext);
    }
    @GET
    @Path("/dish/{id}")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "get dish details", notes = "", response = User.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "User is added", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid username supplied", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Page not found", response = User.class) })
    public Response getDish(@ApiParam(value = "id of dish to add.",required=true) @PathParam("id") String id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getDish(id,securityContext);
    }
    @PUT
    @Path("/order/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update order", notes = "", response = void.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "User is updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = void.class) })
    public Response updateUserOrder(@ApiParam(value = "Order id",required=true) @PathParam("id") UUID id
,@ApiParam(value = "user" ,required=true) Order user
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateUserOrder(id,user,securityContext);
    }
}

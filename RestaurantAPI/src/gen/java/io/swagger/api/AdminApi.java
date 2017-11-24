package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.AdminApiService;
import io.swagger.api.factories.AdminApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Dish;
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

@Path("/admin")


@io.swagger.annotations.Api(description = "the admin API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-24T19:28:58.171Z")
public class AdminApi  {
   private final AdminApiService delegate;

   public AdminApi(@Context ServletConfig servletContext) {
      AdminApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("AdminApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (AdminApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = AdminApiServiceFactory.getAdminApi();
      }

      this.delegate = delegate;
   }

    @POST
    @Path("/dish")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add new dish", notes = "", response = Dish.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "successful operation", response = Dish.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Page not found", response = Dish.class) })
    public Response addDish(@ApiParam(value = "dish" ,required=true) Dish dish
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addDish(dish,securityContext);
    }
    @POST
    @Path("/user")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add new user", notes = "", response = User.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "User is added", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid username supplied", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Page not found", response = User.class) })
    public Response addUser(@ApiParam(value = "user" ,required=true) User user
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addUser(user,securityContext);
    }
    @GET
    @Path("/dishes")
    @Consumes({ "application/x-www-form-urlencoded" })
    
    @io.swagger.annotations.ApiOperation(value = "Get all dishes", notes = "", response = Dish.class, responseContainer = "List", tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Dish.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Page not found", response = Dish.class, responseContainer = "List") })
    public Response allDishes(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.allDishes(securityContext);
    }
    @GET
    @Path("/orders")
    @Consumes({ "application/x-www-form-urlencoded" })
    
    @io.swagger.annotations.ApiOperation(value = "Get all orders", notes = "", response = Order.class, responseContainer = "List", tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Order.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Page not found", response = Order.class, responseContainer = "List") })
    public Response allOrders(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.allOrders(securityContext);
    }
    @GET
    @Path("/users")
    @Consumes({ "application/x-www-form-urlencoded" })
    
    @io.swagger.annotations.ApiOperation(value = "Get all users", notes = "", response = User.class, responseContainer = "List", tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = User.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Page not found", response = User.class, responseContainer = "List") })
    public Response allUsers(@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.allUsers(securityContext);
    }
    @DELETE
    @Path("/dish/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete dish", notes = "", response = void.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Dish not found", response = void.class) })
    public Response deleteDish(@ApiParam(value = "Dish id",required=true) @PathParam("id") UUID id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteDish(id,securityContext);
    }
    @DELETE
    @Path("/order/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete order", notes = "", response = void.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "Order is deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Order not found", response = void.class) })
    public Response deleteOrder(@ApiParam(value = "Order id",required=true) @PathParam("id") UUID id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteOrder(id,securityContext);
    }
    @DELETE
    @Path("/user/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete a user", notes = "", response = void.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "User is deleted", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = void.class) })
    public Response deleteUser(@ApiParam(value = "User id",required=true) @PathParam("id") UUID id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteUser(id,securityContext);
    }
    @GET
    @Path("/dish/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get dish details and all ingredients", notes = "", response = Dish.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Dish.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Dish not found", response = Dish.class) })
    public Response dishDetails(@ApiParam(value = "Dish id",required=true) @PathParam("id") UUID id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.dishDetails(id,securityContext);
    }
    @GET
    @Path("/order/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Find order", notes = "", response = Order.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Order.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = Order.class) })
    public Response findOrder(@ApiParam(value = "Order id",required=true) @PathParam("id") UUID id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findOrder(id,securityContext);
    }
    @GET
    @Path("/user/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Find user", notes = "", response = User.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = User.class) })
    public Response findUser(@ApiParam(value = "User id",required=true) @PathParam("id") UUID id
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.findUser(id,securityContext);
    }
    @PUT
    @Path("/dish/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update dish", notes = "", response = void.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "Successful operation", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Dish not found", response = void.class) })
    public Response updateDish(@ApiParam(value = "Dish id",required=true) @PathParam("id") UUID id
,@ApiParam(value = "user" ,required=true) Dish dish
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateDish(id,dish,securityContext);
    }
    @PUT
    @Path("/order/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update order", notes = "", response = void.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "User is updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = void.class) })
    public Response updateOrder(@ApiParam(value = "Order id",required=true) @PathParam("id") UUID id
,@ApiParam(value = "user" ,required=true) Order user
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateOrder(id,user,securityContext);
    }
    @PUT
    @Path("/user/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update a user", notes = "", response = void.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "User is updated", response = void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = void.class) })
    public Response updateUser(@ApiParam(value = "User id",required=true) @PathParam("id") UUID id
,@ApiParam(value = "user" ,required=true) User user
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateUser(id,user,securityContext);
    }
}

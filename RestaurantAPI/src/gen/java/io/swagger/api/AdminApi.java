package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Dish;
import io.swagger.model.Order;
import java.util.String;
import io.swagger.model.User;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/admin")


@io.swagger.annotations.Api(description = "the admin API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyEapServerCodegen", date = "2017-11-25T01:07:25.026Z")
public interface AdminApi  {
   
    @POST
    @Path("/dish")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add new dish", notes = "", response = Dish.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "successful operation", response = Dish.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Page not found", response = Dish.class) })
    public Response addDish(@ApiParam(value = "dish" ,required=true) Dish dish);
    @POST
    @Path("/user")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add new user", notes = "", response = User.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "User is added", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid username supplied", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Page not found", response = User.class) })
    public Response addUser(@ApiParam(value = "user" ,required=true) User user);
    @GET
    @Path("/dishes")
    @Consumes({ "application/x-www-form-urlencoded" })
    
    @io.swagger.annotations.ApiOperation(value = "Get all dishes", notes = "", response = Dish.class, responseContainer = "List", tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Dish.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Page not found", response = Dish.class, responseContainer = "List") })
    public Response allDishes();
    @GET
    @Path("/orders")
    @Consumes({ "application/x-www-form-urlencoded" })
    
    @io.swagger.annotations.ApiOperation(value = "Get all orders", notes = "", response = Order.class, responseContainer = "List", tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Order.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Page not found", response = Order.class, responseContainer = "List") })
    public Response allOrders();
    @GET
    @Path("/users")
    @Consumes({ "application/x-www-form-urlencoded" })
    
    @io.swagger.annotations.ApiOperation(value = "Get all users", notes = "", response = User.class, responseContainer = "List", tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = User.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Page not found", response = User.class, responseContainer = "List") })
    public Response allUsers();
    @DELETE
    @Path("/dish/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete dish", notes = "", response = Void.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "Successful operation", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Dish not found", response = Void.class) })
    public Response deleteDish( @PathParam("id") String id);
    @DELETE
    @Path("/order/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete order", notes = "", response = Void.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "Order is deleted", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Order not found", response = Void.class) })
    public Response deleteOrder( @PathParam("id") String id,@Context SecurityContext securityContext);
    @DELETE
    @Path("/user/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete a user", notes = "", response = Void.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "User is deleted", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = Void.class) })
    public Response deleteUser( @PathParam("id") String id);
    @GET
    @Path("/dish/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Get dish details and all ingredients", notes = "", response = Dish.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Successful operation", response = Dish.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Dish not found", response = Dish.class) })
    public Response dishDetails( @PathParam("id") String id);
    @GET
    @Path("/order/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Find order", notes = "", response = Order.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Order.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = Order.class) })
    public Response findOrder( @PathParam("id") String id);
    @GET
    @Path("/user/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Find user", notes = "", response = User.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = User.class) })
    public Response findUser( @PathParam("id") String id);
    @PUT
    @Path("/dish/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update dish", notes = "", response = Void.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "Successful operation", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Dish not found", response = Void.class) })
    public Response updateDish( @PathParam("id") String id,@ApiParam(value = "Dish" ,required=true) Dish dish);
    @PUT
    @Path("/order/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update order", notes = "", response = Void.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "User is updated", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = Void.class) })
    public Response updateOrder( @PathParam("id") String id,@ApiParam(value = "user" ,required=true) Order user);
    @PUT
    @Path("/user/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update a user", notes = "", response = Void.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "User is updated", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = Void.class) })
    public Response updateUser( @PathParam("id") String id,@ApiParam(value = "user" ,required=true) User user);
}

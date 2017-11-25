package io.swagger.api;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Order;
import io.swagger.model.User;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;


@Path("/user")


@io.swagger.annotations.Api(description = "the user API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaResteasyEapServerCodegen", date = "2017-11-25T01:07:25.026Z")
public interface UserApi  {
   
    @POST
    @Path("/dish/{id}")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add dish to order", notes = "", response = User.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "User is added", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid username supplied", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Page not found", response = User.class) })
    public Response addDishToOrder( @PathParam("id") String id);
    @POST
    @Path("/order")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Add order", notes = "", response = Order.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "successful operation", response = Order.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Page not found", response = Order.class) })
    public Response addUserOrder(@ApiParam(value = "Order" ,required=true) Order order);
    @GET
    @Path("/dishes")
    @Consumes({ "application/x-www-form-urlencoded" })
    
    @io.swagger.annotations.ApiOperation(value = "Get all dishes", notes = "", response = Order.class, responseContainer = "List", tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Order.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Page not found", response = Order.class, responseContainer = "List") })
    public Response allUserDishes();
    @GET
    @Path("/orders")
    @Consumes({ "application/x-www-form-urlencoded" })
    
    @io.swagger.annotations.ApiOperation(value = "Get all orders", notes = "", response = Order.class, responseContainer = "List", tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Order.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Page not found", response = Order.class, responseContainer = "List") })
    public Response allUserOrders();
    @DELETE
    @Path("/order/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Delete order", notes = "", response = Void.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "User is deleted", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = Void.class) })
    public Response deleteUserOrder( @PathParam("id") String id);
    @GET
    @Path("/order/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Find order", notes = "", response = Order.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Order.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = Order.class) })
    public Response findUserOrder( @PathParam("id") String id);
    @GET
    @Path("/dish/{id}")
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "get dish details", notes = "", response = User.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "User is added", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid username supplied", response = User.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Page not found", response = User.class) })
    public Response getDish( @PathParam("id") String id);
    @PUT
    @Path("/order/{id}")
    @Consumes({ "application/x-www-form-urlencoded" })
    @Produces({ "application/xml", "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Update order", notes = "", response = Void.class, tags={ "admin", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "User is updated", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "User not found", response = Void.class) })
    public Response updateUserOrder( @PathParam("id") String id,@ApiParam(value = "user" ,required=true) Order user);
}

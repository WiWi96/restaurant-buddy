/*
 * WMAP application
 *  Manage your restaurant like a boss
 *
 * OpenAPI spec version: 1.0.0
 * Contact: WMAP@gmail.pl
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package io.swagger.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * User
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-11-24T19:28:58.171Z")
public class User {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("username")
	private String username = null;

	@JsonProperty("password")
	private String password = null;

	@JsonProperty("email")
	private String email = null;

	@JsonProperty("listOfOrders")
	private List<Order> listOfOrders = null;

	public User() {
		this.listOfOrders = new LinkedList<>();
	}

	public User(String id, String username, String password, String email, List<Order> listOfOrders) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.listOfOrders = listOfOrders;
	}

	public User id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@JsonProperty("id")
	@ApiModelProperty(value = "")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User username(String username) {
		this.username = username;
		return this;
	}

	/**
	 * Get username
	 * 
	 * @return username
	 **/
	@JsonProperty("username")
	@ApiModelProperty(value = "")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User password(String password) {
		this.password = password;
		return this;
	}

	/**
	 * Get password
	 * 
	 * @return password
	 **/
	@JsonProperty("password")
	@ApiModelProperty(value = "")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User email(String email) {
		this.email = email;
		return this;
	}

	/**
	 * Get email
	 * 
	 * @return email
	 **/
	@JsonProperty("email")
	@ApiModelProperty(value = "")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User listOfOrders(List<Order> listOfOrders) {
		this.listOfOrders = listOfOrders;
		return this;
	}

	public User addListOfOrdersItem(Order listOfOrdersItem) {
		if (this.listOfOrders == null) {
			this.listOfOrders = new ArrayList<Order>();
		}
		this.listOfOrders.add(listOfOrdersItem);
		return this;
	}

	/**
	 * Get listOfOrders
	 * 
	 * @return listOfOrders
	 **/
	@JsonProperty("listOfOrders")
	@ApiModelProperty(value = "")
	public List<Order> getListOfOrders() {
		return listOfOrders;
	}

	public void setListOfOrders(List<Order> listOfOrders) {
		this.listOfOrders = listOfOrders;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return Objects.equals(this.id, user.id) && Objects.equals(this.username, user.username)
				&& Objects.equals(this.password, user.password) && Objects.equals(this.email, user.email)
				&& Objects.equals(this.listOfOrders, user.listOfOrders);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username, password, email, listOfOrders);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class User {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    username: ").append(toIndentedString(username)).append("\n");
		sb.append("    password: ").append(toIndentedString(password)).append("\n");
		sb.append("    email: ").append(toIndentedString(email)).append("\n");
		sb.append("    listOfOrders: ").append(toIndentedString(listOfOrders)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}

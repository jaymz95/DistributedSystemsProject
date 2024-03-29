package ie.gmit.ds;

import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import javax.validation.Validator;
import javax.validation.ConstraintViolation;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserApiResource {

	
	private HashMap<Integer, User> usersMap = new HashMap<Integer, User>();

	public UserApiResource() {
		User testUser = new User(1, "James", "email@gmail.com", "myPassword1", "mySalt", "myHash");
		User testUser1 = new User(2, "Beth", "bethany@gmail.com", "myPassword2", "mySalt2", "myHash2");
		usersMap.put(testUser.getUserId(), testUser);
		usersMap.put(testUser1.getUserId(), testUser1);
	}
	
	@GET
	public Collection<User> getUsers() {
		// artistsMap.values() returns Collection<Artist>
		// Collection is the interface implemented by Java collections like ArrayList, LinkedList etc.
		// it's basically a generic list.
		// https://docs.oracle.com/javase/7/docs/api/java/util/Collection.html
	    
		return usersMap.values();
	  }
	
	@GET
	@Path("/{userId}")
	public Response getUser(@PathParam("userId") Integer userId)throws Exception {
		User user = usersMap.get(userId);
		System.out.println("User Id:" + userId);
		if (user != null)
			return Response.ok(user).build();
		else
			return Response.status(Status.OK).build();
	}
	
	@POST
	public Response postUser(User user)throws Exception {
		//Set<ConstraintViolation<User>> violations = validator.validate(user);
		//User e = usersMap.get(User.getUserId());
		
		//return null;
		
		int id = usersMap.size();
		
		user.setUserId(id+1);
		String user1 = String.valueOf(user.getUserId());
		
		usersMap.put(id+1, user);
	
		return Response.created(new URI("/users/" + user1)).entity(usersMap.get(user.getUserId())).status(Status.CREATED).build();

		
	 }
	
	
}

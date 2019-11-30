package ie.gmit.ds;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.*;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    @NotNull
    private int userId;
    @NotBlank @Length(min=2, max=255)
    private String userName;
    @Pattern(regexp=".+@.+\\.[a-z]+")
    private String userEmail;
    @NotBlank @Length(min=2, max=12)
    private String userPassword;
    private String userSalt;
    private String userHash;


	public User() {
        // Needed for Jackson deserialisation
    }
	
    public User(int userId, String userName, String userEmail, String userPassword, String userSalt, String userHash) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userSalt = userSalt;
		this.userHash = userHash;
	}

    @JsonProperty
	public int getUserId() {
		return userId;
    	//return users.get(userId);
	}

    @JsonProperty
	public String getUserName() {
		return userName;
	}

    @JsonProperty
	public String getUserEmail() {
		return userEmail;
	}

    @JsonProperty
	public String getUserPassword() {
		return userPassword;
	}

    @JsonProperty
	public String getUserSalt() {
		return userSalt;
	}

    @JsonProperty
	public String getUserHash() {
		return userHash;
	}

	public void setUserId(int id) {
		this.userId = id;
		
	}


}

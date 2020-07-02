package coop.tecso.examen.model;

public class ApiError {
	
	private String code;
	private String message;
	private String details;
	
	
	public ApiError(String code, String message, String details) {
		super();
		this.code = code;
		this.message = message;
		this.details = details;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	@Override
	public String toString() {
		return "{\"code\":\""+ code +"\",\"message\":\""+message+"\",\"details\":\""+details+"\"}";
	}
	
	
	
	

}

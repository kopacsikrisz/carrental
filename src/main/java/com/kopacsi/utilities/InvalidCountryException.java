package com.kopacsi.utilities;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class InvalidCountryException extends Exception implements ExceptionMapper<InvalidCountryException> {

	private static final long serialVersionUID = 1L;
	 
    public InvalidCountryException() {
        super("Invalid country.");
    }
 
    public InvalidCountryException(String string) {
        super(string);
    }
 
    @Override
    public Response toResponse(InvalidCountryException exception) 
    {
        return Response.status(404).entity(exception.getMessage())
                                    .type(MediaType.APPLICATION_JSON).build();
    }
    
}

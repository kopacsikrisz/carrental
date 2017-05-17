package com.kopacsi.utilities;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class InvalidDateException extends Exception implements ExceptionMapper<InvalidDateException> {

	private static final long serialVersionUID = 1L;
	 
    public InvalidDateException() {
        super("Invalid booking dates. A booking already exists in that time interval.");
    }
 
    public InvalidDateException(String string) {
        super(string);
    }
 
    @Override
    public Response toResponse(InvalidDateException exception) 
    {
        return Response.status(404).entity(exception.getMessage())
                                    .type(MediaType.APPLICATION_JSON).build();
    }
    
}

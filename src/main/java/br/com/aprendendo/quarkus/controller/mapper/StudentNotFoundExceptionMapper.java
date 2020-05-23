package br.com.aprendendo.quarkus.controller.mapper;

import br.com.aprendendo.quarkus.exception.StudentNotFoundException;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import static javax.ws.rs.core.Response.status;

@Provider
public class StudentNotFoundExceptionMapper implements ExceptionMapper<StudentNotFoundException> {

    @Override
    public Response toResponse(StudentNotFoundException exception) {
        return status(Response.Status.NOT_FOUND).type(MediaType.APPLICATION_JSON).entity(exception.getMessage()).build();
    }
}

package br.com.aprendendo.quarkus.controller;

import br.com.aprendendo.quarkus.domain.Student;
import br.com.aprendendo.quarkus.repository.StudentRepository;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import java.util.UUID;

@Path("/students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {

    private final StudentRepository studentRepository;

    public StudentResource(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GET
    @Path("{id}")
    public Response findStudent(@PathParam("id") UUID id){
        Student student = studentRepository.findById(id);
        return Response.ok(student).build();
    }

    @POST
    @Transactional
    public Response addStudent(Student student, @Context UriInfo uriInfo){
        studentRepository.persist(student);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(student.getId().toString());
        return Response.created(builder.build()).build();
    }

    @GET
    public Response findAllStudent(){
        List<Student> students = studentRepository.listAll();
        return Response.ok(students).build();
    }

}
package br.com.aprendendo.quarkus.repository;

import br.com.aprendendo.quarkus.exception.StudentNotFoundException;
import br.com.aprendendo.quarkus.domain.Student;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class StudentRepository implements PanacheRepositoryBase<Student, UUID> {

    @Override
    public Student findById(UUID uuid) {
        return findByIdOptional(uuid).orElseThrow(StudentNotFoundException::new);
    }
}

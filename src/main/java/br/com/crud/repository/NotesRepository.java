package br.com.crud.repository;

import br.com.crud.entity.Notes;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NotesRepository implements PanacheRepository<Notes> {


}

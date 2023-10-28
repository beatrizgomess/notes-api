package br.com.crud.service;

import br.com.crud.dto.NotesDTO;
import br.com.crud.entity.Notes;
import br.com.crud.repository.NotesRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@ApplicationScoped //Colocar a classe dentro do contexto do Quarkus - Classes gerenciadas pelo quarkus
public class NotesService {

    @Inject
    NotesRepository notesRepository;

    public List<Notes> listAllNotes(){
        return notesRepository.listAll();
    }

    @Transactional
    public Notes createNote(NotesDTO todoListDTO){
        Notes notes = new Notes();

        notes.setTitle(todoListDTO.getTitle());
        notes.setDescription(todoListDTO.getDescription());
        notes.setCreatedAt(formaterDateTime(LocalDateTime.now()));
        notes.setDone(false);
        notesRepository.persist(notes);



        return notes;

    }

    private String formaterDateTime(LocalDateTime createdAt){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/y h:mm");
        String createdAtFormatter = createdAt.format(formatter);
        return createdAtFormatter;
    }

    @Transactional
    public void updateNotes(Long id, NotesDTO todoListDTO){
        Notes note = new Notes();
        Optional<Notes> notesOptional = notesRepository.findByIdOptional(id);

        if(notesOptional.isEmpty()){
            throw  new NullPointerException("Note not Found");
        }

        note = notesOptional.get();
        note.setTitle(todoListDTO.getTitle());
        note.setDescription(todoListDTO.getDescription());
        note.setDone(todoListDTO.getDone());
        note.persist();
    }

    @Transactional
    public void removeNote(Long id){
       Optional<Notes> notesOptional = notesRepository.findByIdOptional(id);
        if (notesOptional.isEmpty()) {
            throw  new NullPointerException("Todo List not Found");
        }
        Notes note = notesOptional.get();
        note.delete();
    }




}

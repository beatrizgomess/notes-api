package br.com.crud.controller;


import br.com.crud.dto.NotesDTO;
import br.com.crud.entity.Notes;
import br.com.crud.service.NotesService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("notes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NotesController {

    @Inject
    NotesService notesService;

    @GET
    public Response getAllNotes(){
        List<Notes> allTodoList = notesService.listAllNotes();
        return Response.ok(allTodoList).build();
    }

    @POST
    public Response createNote(NotesDTO notesDTO){
        Notes todoList = notesService.createNote(notesDTO);
        return Response.ok(todoList).status(201).build();
    }

    @Path("{id}")
    @PUT
    public Response updateNotes(@PathParam("id") Long id, NotesDTO notesDTO){
        notesService.updateNotes(id, notesDTO);
        return Response.status(204).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeNotes(@PathParam("id") Long id){
        notesService.removeNote(id);
        return Response.status(204).build();
    }



}

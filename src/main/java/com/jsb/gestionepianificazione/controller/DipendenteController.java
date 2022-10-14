package com.jsb.gestionepianificazione.controller;

import com.jsb.gestionepianificazione.dto.ResponseDTO;
import com.jsb.gestionepianificazione.service.api.IPianificatoService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import com.jsb.gestionepianificazione.dto.DipendenteDTO;
import com.jsb.gestionepianificazione.entity.Dipendente;
import com.jsb.gestionepianificazione.service.api.IDipendenteService;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static com.jsb.gestionepianificazione.constant.DatabaseConstant.ID_DIPENDENTE;
import static com.jsb.gestionepianificazione.constant.DatabaseConstant.PIANIFICATO_FIND_BY_ID_DIPENDENTE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("api/v1/dipendenti")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class DipendenteController {

    @Inject
    IDipendenteService dipendenteService;

    @POST
    @APIResponse(responseCode = "200", description = "Dipendente salvato con successo")
    public Response saveDipendente(@RequestBody DipendenteDTO dipendente) {
        dipendenteService.saveDipendente(dipendente);
        return Response.ok(new ResponseDTO("Dipendente creato con successo", false)).build();
    }

    @GET
    @Path("/{idDipendente}")
    public Response getDipendente(Long idDipendente){
        return Response.ok(dipendenteService.getDipendente(idDipendente)).build();
    }

    @Operation(summary = "Returns all the dipendenti from the database")
    @GET
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Dipendente.class, type = SchemaType.ARRAY)))
    @APIResponse(responseCode = "204", description = "No Dipendenti")
    public Response getAllDipendenti() {
        return Response.ok(dipendenteService.getDipendenti()).build();
    }

    @DELETE
    @Path("/{idDipendente}")
    public Response delete(Long idDipendente) {
        dipendenteService.deleteDipendente(idDipendente);
        return Response.status(204).build();
    }

    @PUT
    @Path("/{id}")
    @APIResponse(responseCode = "404", description = "Dipendente non trovato")
    @APIResponse(responseCode = "200", description = "Dipendente aggiornato con successo")
    public Response update(Long id, @RequestBody Dipendente dipendente){
        dipendenteService.updateDipendente(id, dipendente);
        return Response.status(204).build();
    }
}
package com.jsb.gestionepianificazione.resource;

import com.jsb.gestionepianificazione.dto.ProgettoDTO;
import com.jsb.gestionepianificazione.dto.ResponseDTO;
import com.jsb.gestionepianificazione.entity.Progetto;
import com.jsb.gestionepianificazione.service.api.IProgettoService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("api/v1/progetti")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class ProgettoResource {

    @Inject
    IProgettoService progettoService;

    @POST
    @APIResponse(responseCode = "200", description = "Progetto salvato con successo")
    public Response saveProgetto(@RequestBody ProgettoDTO progetto) {
        progettoService.saveProgetto(progetto);
        return Response.ok(new ResponseDTO("Progetto creato con successo", false)).build();
    }

    @GET
    @Path("/{idProgetto}")
    public Response getProgetto(Long idProgetto){
        return Response.ok(progettoService.getProgetto(idProgetto)).build();
    }

    @Operation(summary = "Returns all the progetti from the database")
    @GET
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Progetto.class, type = SchemaType.ARRAY)))
    @APIResponse(responseCode = "204", description = "No Dipendenti")
    public Response getAllDipendenti() {
        return Response.ok(progettoService.getProgetti()).build();
    }

    @DELETE
    @Path("/{idProgetto}")
    public Response delete(Long idProgetto) {
        progettoService.deleteProgetto(idProgetto);
        return Response.ok(new ResponseDTO("Progetto eliminato con successo", false)).build();
    }

    @PUT
    @Path("/{id}")
    @APIResponse(responseCode = "404", description = "Progetto non trovato")
    @APIResponse(responseCode = "200", description = "Progetto aggiornato con successo")
    public Response update(Long id, @RequestBody Progetto progetto){
        progettoService.updateProgetto(id, progetto);
        return Response.ok(new ResponseDTO("Progetto aggiornato con successo", false)).build();
    }
}
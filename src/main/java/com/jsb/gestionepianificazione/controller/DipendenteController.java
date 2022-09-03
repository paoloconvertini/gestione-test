package com.jsb.gestionepianificazione.controller;

import io.quarkus.security.Authenticated;
import org.eclipse.microprofile.openapi.annotations.Operation;
import com.jsb.gestionepianificazione.dto.DipendenteDTO;
import com.jsb.gestionepianificazione.entity.Dipendente;
import com.jsb.gestionepianificazione.service.DipendenteServiceImpl;
import com.jsb.gestionepianificazione.service.api.IDipendenteService;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestPath;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("api/v1/dipendenti")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class DipendenteController {

    @Inject
    IDipendenteService dipendenteService;

    @POST
    @Path(value = "/save")
    @APIResponse(responseCode = "200", description = "Dipendente salvato con successo")
    public Response saveDipendente(@RequestBody DipendenteDTO dipendente) {
        dipendenteService.saveDipendente(dipendente);
        return Response.ok().build();
    }

    @GET
    @Path("/getDipendente/{idDipendente}")
    public Response getDipendete(Long idDipendente){
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
    @Path("/delete/{idDipendente}")
    public Response delete(Long idDipendente) {
        dipendenteService.deleteDipendente(idDipendente);
        return Response.status(204).build();
    }

    @POST
    @Path("/update")
    @APIResponse(responseCode = "404", description = "Dipendente non trovato")
    @APIResponse(responseCode = "200", description = "Dipendente aggiornato con successo")
    public Response update(@RequestBody Dipendente dipendente){
        dipendenteService.updateDipendente(dipendente);
        return Response.ok().build();
    }
}
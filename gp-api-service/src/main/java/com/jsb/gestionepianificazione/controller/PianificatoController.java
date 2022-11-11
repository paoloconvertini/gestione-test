package com.jsb.gestionepianificazione.controller;

import com.jsb.gestionepianificazione.dto.DipendenteDTO;
import com.jsb.gestionepianificazione.dto.PianificatoDTO;
import com.jsb.gestionepianificazione.dto.ResponseDTO;
import com.jsb.gestionepianificazione.entity.Dipendente;
import com.jsb.gestionepianificazione.entity.Pianificato;
import com.jsb.gestionepianificazione.service.api.IDipendenteService;
import com.jsb.gestionepianificazione.service.api.IPianificatoService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static com.jsb.gestionepianificazione.constant.DatabaseConstant.*;
import static com.jsb.gestionepianificazione.constant.DatabaseConstant.ID_DIPENDENTE;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("api/v1/pianificato/")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class PianificatoController {

    @Inject
    IPianificatoService pianificatoService;

    @POST
    @APIResponse(responseCode = "200", description = "Pianificazione salvata con successo")
    public Response savePianificato(@RequestBody PianificatoDTO pianificato) {
        pianificatoService.savePianificato(pianificato);
        return Response.ok(new ResponseDTO("Pianificazione creato con successo", false)).build();
    }

    @Operation(summary = "Returns all the progetti with pianificazioni")
    @GET
    @Path("/checkProgettiPianificati/{id}")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Dipendente.class, type = SchemaType.ARRAY)))
    @APIResponse(responseCode = "204", description = "No Progetti")
    public Response checkProgettiPianificati(Long id) {
        return Response.ok(pianificatoService.existsPianificatoById(id, PIANIFICATO_FIND_BY_ID_PROGETTO, ID_PROGETTO)).build();
    }

    @Operation(summary = "Returns all the dipendenti with pianificazioni")
    @GET
    @Path("/checkDipendentiPianificati/{id}")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Dipendente.class, type = SchemaType.ARRAY)))
    @APIResponse(responseCode = "204", description = "No Dipendenti")
    public Response checkDipendentiPianificati(Long id) {
        return Response.ok(pianificatoService.existsPianificatoById(id, PIANIFICATO_FIND_BY_ID_DIPENDENTE, ID_DIPENDENTE)).build();
    }

    @Operation(summary = "Returns all the pianificato from the database")
    @GET
    @Path("all/{id}")
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON, schema = @Schema(implementation = Pianificato.class, type = SchemaType.ARRAY)))
    @APIResponse(responseCode = "204", description = "No Progetti")
    public Response getPianificatoByIdProgetto(Long id) {
        return Response.ok(pianificatoService.getPianificatoByIdProgetto(id)).build();
    }


}
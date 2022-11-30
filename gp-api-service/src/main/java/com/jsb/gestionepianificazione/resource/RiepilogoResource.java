package com.jsb.gestionepianificazione.resource;

import com.jsb.gestionepianificazione.service.api.IRiepilogoService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("api/v1/riepilogo")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class RiepilogoResource {

    @Inject
    IRiepilogoService riepilogoService;

    @Operation(summary = "Returns riepilogo from database")
    @GET
    @APIResponse(responseCode = "200", content = @Content(mediaType = APPLICATION_JSON))
    @APIResponse(responseCode = "204", description = "No Riepilogo")
    public Response getRiepilogo(){
        return Response.ok(riepilogoService.getRiepilogo()).build();
    }

}
package com.junior.guiaquixada.controllerRest;

import com.google.gson.Gson;
import com.junior.guiaquixada.dao.AnuncioDao;
import com.junior.guiaquixada.model.Anuncio;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Junior Bezerra
 */

@Path("anuncio")
public class AnuncioService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response ListaAnunios(){   
        List<Anuncio> anuncios = AnuncioDao.getInstance().getListaEntidade(Anuncio.class);
        return Response.ok(new Gson().toJson(anuncios)).build();
    }
    
    
}

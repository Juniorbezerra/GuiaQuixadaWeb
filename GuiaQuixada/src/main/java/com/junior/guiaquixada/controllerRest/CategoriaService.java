/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junior.guiaquixada.controllerRest;

import com.google.gson.Gson;
import com.junior.guiaquixada.dao.CategoriaDao;
import com.junior.guiaquixada.model.Categoria;
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
@Path("categoria")
public class CategoriaService {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response ListaCategorias(){
        List<Categoria> categorias = CategoriaDao.getInstance().getListaEntidade(Categoria.class);
        return Response.ok(new Gson().toJson(categorias)).build();
    }
   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junior.guiaquixada.controllerRest;

import com.google.gson.Gson;
import com.junior.guiaquixada.dao.CategoriaDao;
import com.junior.guiaquixada.dao.SubcategoriaDao;
import com.junior.guiaquixada.model.Categoria;
import com.junior.guiaquixada.model.Subcategoria;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Junior Bezerra
 */
@Path("subcategoria")
public class SubcategoriaService {
 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response ListaSubcategoriaPorId(@PathParam("id") Long id){
        
        Categoria categoria = CategoriaDao.getInstance().getEntidadePorId(Categoria.class, id);
        
        List<Subcategoria> subcategoria = SubcategoriaDao.getInstance().ListarPorId(categoria);
        return Response.ok(new Gson().toJson(subcategoria)).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response ListaSubcategoria(){   
        List<Subcategoria> subcategoria = SubcategoriaDao.getInstance().getListaEntidade(Subcategoria.class);
        return Response.ok(new Gson().toJson(subcategoria)).build();
    }
    
    
}

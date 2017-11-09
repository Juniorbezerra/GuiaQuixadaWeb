/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.junior.guiaquixada.util;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Junior Bezerra
 */
@ApplicationPath("rest")
public class RestConfig extends ResourceConfig{

    public RestConfig() {
        packages("com.junior.guiaquixada.controllerRest");
    }
}

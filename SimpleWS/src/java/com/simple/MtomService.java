/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simple;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

/**
 *
 * @author alex
 */
@WebService
@MTOM
//@MTOM(threshold = 10240)
public class MtomService {
    
    byte [] pic;
    
    public byte[] getPic(int id) throws IOException{
        
       pic= this.getData();
        
        return pic;
    }
    
    
    private byte[] getData() throws IOException{
        
        File fi = new File("C:\\Users\\alex\\Documents\\Timer_config.JPG");
        return Files.readAllBytes(fi.toPath());

    }
}

package com.recorrido.ambiente.Config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.recorrido.ambiente.Model.Ambiente;
import com.recorrido.ambiente.Service.AmbienteService;
@Configuration
public class AmbienteLambda {
    
    @Autowired
    private AmbienteService ambienteService;

    //La funcion Supplier solo retorna en este caso una lista ambientes
    @Bean
    public Supplier<List<Ambiente>> listarAmbiente(){
        return() ->{
            return ambienteService.findAll();
        };
    }

    //La funcion Function recibe un objeto Ambiente y retorna una respuesta si la solictud fue procesada o no
    @Bean
    public Function<Ambiente,Map<String,String>> crearAmbiente(){
        return(ambiente) ->{

            Map<String,String> resp= new HashMap<>();

            if(ambiente.getId()!=null){
                if(ambienteService.findById(ambiente.getId().trim()).isPresent()){
                    resp.put("Error", "El id ya existe");
                    return resp;
                }else{
                    try{
                        ambiente.setId(ambiente.getId().toUpperCase());
                        ambienteService.save(ambiente);
                        resp.put("Message", "Solicitud procesada con éxito");
                        return resp;
                    }catch(Exception e) {
                        resp.put("Error", "Algo salio mal en la solicitud");
                        return resp;
                    }
                }
            }else{
                resp.put("Error", "Algo salio mal en la solicitud");
                return resp;
            }
            
           
        };
    }

    // La funcion Function recibe un parametro de entrada y retorna un dato, en este caso entra el id a buscar y devulve un ambiente
    @Bean
    public Function<String,Optional<Ambiente>> buscarAmbiente(){
        return(id) ->{
            id=id.toUpperCase();
            return ambienteService.findById(id);
        };
    }
    
    // Funcion para actualizar un ambiente recibe todo el objeto busca si existe el id y hace el proceso, aca de igual forma envia la solicitud si fue procesada o no
    @Bean
    public Function<Ambiente,Map<String,String>> actualizarAmbiente(){
        return(ambiente) ->{

            Map<String,String> resp= new HashMap<>();
            if(ambiente.getId()!=null){
                if(ambienteService.findById(ambiente.getId().trim()).isPresent()){
                    try{
                        ambiente.setId(ambiente.getId().toUpperCase());
                        ambienteService.save(ambiente);
                        resp.put("Message", "Solicitud procesada con éxito");
                        return resp;
                    }catch(Exception e) {
                        resp.put("Error", "Algo salio mal en la solicitud");
                        return resp;
                    }
                }else{
                    resp.put("Error", "No existe el ambiente");
                    return resp;
                }
            }else{
                resp.put("Error", "Algo salio mal en la solicitud");
                return resp;
            }
            
        };
    } 
}

package com.zegel.serviceRestDispositivo.Rest;

import com.zegel.serviceRestDispositivo.Business.DispositivoBusiness;
import com.zegel.serviceRestDispositivo.Entities.Dispositivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DispositivoRest {
    @Autowired
    private DispositivoBusiness dispositivoBusiness;

    @PostMapping("/devices")
    public Dispositivo guardarDispositivo(@RequestBody Dispositivo dispositivo) {
        try{
            return dispositivoBusiness.saveDispositivo(dispositivo);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"error al crear el dispositivo");
        }

    }

    @GetMapping("/devices")
    public List<Dispositivo> getAllDispositivos() {
        try{
            return dispositivoBusiness.getDispositivos();
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"error al obtener los dispositivos");
        }
    }

    @PutMapping("/devices/{id}")
    public Dispositivo updateDispositivo(@PathVariable Long id, @RequestBody Dispositivo dispositivo) {
        try{
            Dispositivo d = dispositivoBusiness.updateDispositivo(id,dispositivo);
            if (d != null){
                return d;
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dispositivo no existe");
            }
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"error al actualizar el dispositivo");
        }
    }

    @DeleteMapping ("/devices/{id}")
    public Dispositivo deleteDispositivo(@PathVariable(value = "id") Long id) {
        try{
            return dispositivoBusiness.deleteDispositivo(id);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"error al eliminar el dispositivo");
        }
    }
}

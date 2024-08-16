package com.zegel.serviceRestDispositivo.Business;

import com.zegel.serviceRestDispositivo.Entities.Dispositivo;
import com.zegel.serviceRestDispositivo.Repository.DispositivoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoBusiness {
    @Autowired
    private DispositivoRepository dispositivoRepository;

    public Dispositivo saveDispositivo(Dispositivo dispositivo){
        return dispositivoRepository.save(dispositivo);
    }

    public List<Dispositivo> getDispositivos(){
        return (List<Dispositivo>) dispositivoRepository.findAll();
    }

    @Transactional
    public Dispositivo updateDispositivo(Long id, Dispositivo dispositivo) {
        return dispositivoRepository.findById(id)
                .map(d -> {
                    d.setBrand(dispositivo.getBrand());
                    d.setModel(dispositivo.getModel());
                    d.setSerial(dispositivo.getSerial());
                    d.setOsVersion(dispositivo.getOsVersion());
                    d.setDate_create(dispositivo.getDate_create());
                    d.setActive(dispositivo.getActive());
                    return dispositivoRepository.save(d);
                })
                .orElse(null);
    }

    @Transactional
    public Dispositivo deleteDispositivo(Long id){
        Dispositivo d = dispositivoRepository.findById(id).get();
        if (d != null){
            dispositivoRepository.delete(d);
        } else {
            return null;
        }
        return d;
    }


}

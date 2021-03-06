/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.noumeasmartcityapi.controller;

import com.github.adriens.noumeasmartcityapi.service.ScalairService;
import com.github.adriens.scalair4j.IQA;
import com.github.adriens.scalair4j.ShieldMessage;
import com.github.adriens.scalair4j.Station;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author salad74
 */
@RestController
public class ScalairController {
    @Autowired
    private ScalairService scalairService;
    
    @GetMapping(value={"/scalair/live", "/scalair/"})
    public List<Station> getAllStations() throws Exception {
        try {
            return new ArrayList<Station>(scalairService.getAllLiveStationsStatuses().values());//scalairService.getAllLiveStationsStatuses();
        } catch (Exception e) {
            throw e;
        }
    }
    
    @GetMapping(value={"/scalair/logicoop"})
    public Station getStationLogicoop() throws Exception {
        try {
            return scalairService.getLogicoopLiveStatus();
        } catch (Exception e) {
            throw e;
        }
    }
    @GetMapping(value={"/scalair/logicoop/message"})
    public ShieldMessage getStationLogicoopShieldMessage() throws Exception {
        try {
            return scalairService.getLogicoopLiveStatus().getShieldMessage();
        } catch (Exception e) {
            throw e;
        }
    }
    
    @GetMapping(value={"/scalair/montravel"})
    public Station getStationMontravel() throws Exception {
        try {
            return scalairService.getMontravelLiveStatus();
        } catch (Exception e) {
            throw e;
        }
    }
    @GetMapping(value={"/scalair/montravel/message"})
    public ShieldMessage getStationMontravelShieldMessage() throws Exception {
        try {
            return scalairService.getMontravelLiveStatus().getShieldMessage();
        } catch (Exception e) {
            throw e;
        }
    }
    
    @GetMapping(value={"/scalair/faubourg", "/scalair/faubourgblanchot"})
    public Station getStationFaubourg() throws Exception {
        try {
            return scalairService.getFaubourgLiveStatus();
        } catch (Exception e) {
            throw e;
        }
    }
    @GetMapping(value={"/scalair/faubourg/message"})
    public ShieldMessage getStationFaubourgShieldMessage() throws Exception {
        try {
            return scalairService.getFaubourgLiveStatus().getShieldMessage();
        } catch (Exception e) {
            throw e;
        }
    }
    
    @GetMapping(value={"/scalair/vata", "/scalair/ansevata"})
    public Station getStationVata() throws Exception {
        try {
            return scalairService.getAnseVataLiveStatus();
        } catch (Exception e) {
            throw e;
        }
    }
    
    @GetMapping(value={"/scalair/vata/message"})
    public ShieldMessage getStationVataShieldMessage() throws Exception {
        try {
            return scalairService.getAnseVataLiveStatus().getShieldMessage();
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    @GetMapping(value={"/scalair/general"})
    public Station getStationGeneral() throws Exception {
        try {
            return scalairService.getGeneralLiveStatus();
        } catch (Exception e) {
            throw e;
        }
    }
    
    @GetMapping(value={"/scalair/general/message", "/scalair/message"})
    public ShieldMessage getStationGeneralShieldMessage() throws Exception {
        try {
            return scalairService.getGeneralLiveStatus().getShieldMessage();
        } catch (Exception e) {
            throw e;
        }
    }
    
    // IGAs
    @GetMapping(value={"/scalair/iqa", "/scalair/igas"})
    public HashMap<Integer,IQA> getIQAs() throws Exception {
        try {
            return scalairService.getIQAs();
        } catch (Exception e) {
            throw e;
        }
    }
    @GetMapping("/scalair/iqa/{indice}")
    public IQA getIQA(@PathVariable Integer indice) throws Exception {
        return scalairService.getIQAs().get(indice-1);
    }
    
}

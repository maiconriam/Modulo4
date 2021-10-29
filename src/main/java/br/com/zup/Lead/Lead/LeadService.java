package br.com.zup.Lead.Lead;

import br.com.zup.Lead.Lead.DTOS.LeadDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeadService {

    public List<LeadDTO> listaDeLead = new ArrayList<>();


    public List<LeadDTO> exibirLeads(){
        return listaDeLead;
    }

    public void adicionarLead(@RequestBody LeadDTO leadDTO){
        for (LeadDTO referencia : listaDeLead){
            if(referencia.getEmail().equalsIgnoreCase(leadDTO.getEmail())){
                throw new ResponseStatusException(HttpStatus.CONFLICT);
            }
        }
        listaDeLead.add(leadDTO);
    }
}

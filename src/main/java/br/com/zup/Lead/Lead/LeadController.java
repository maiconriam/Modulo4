package br.com.zup.Lead.Lead;


import br.com.zup.Lead.Lead.DTOS.LeadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leads")
public class LeadController {

    @Autowired
    private LeadService leadService;

    @GetMapping
    public List<LeadDTO> exibirLeads(){
        return leadService.exibirLeads();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarLead(@RequestBody LeadDTO leadDTO){
        leadService.adicionarLead(leadDTO);
    }
}

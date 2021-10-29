package br.com.zup.Lead.Lead;

import br.com.zup.Lead.Lead.DTOS.LeadDTO;
import br.com.zup.Lead.Lead.DTOS.ProdutoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeadService {

    public List<LeadDTO> listaDeLead = new ArrayList<>();


    public List<LeadDTO> exibirLeads(){
        return listaDeLead;
    }

    public void adicionarLead(LeadDTO leadDTO){
        for (LeadDTO referencia : listaDeLead){
            if(referencia.getEmail().equalsIgnoreCase(leadDTO.getEmail())){
                if(existeProdutoDuplicado(referencia, leadDTO)){
                    throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
                }
            }
        }

        listaDeLead.add(leadDTO);
    }

    private boolean existeProdutoDuplicado(LeadDTO lead, LeadDTO leadDTO) {
        List<ProdutoDTO> produtosDoCliente = lead.getProdutos();
        List<ProdutoDTO> novosProdutos = leadDTO.getProdutos();

        for(ProdutoDTO produtoCliente: produtosDoCliente){
            if(novosProdutos.contains(produtoCliente)){
                return true;
            }
        }
        return false;
    }
}

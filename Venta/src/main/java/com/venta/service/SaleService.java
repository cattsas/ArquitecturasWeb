package com.venta.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.venta.DTO.*;
import com.venta.model.Sale;
import com.venta.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;


    public Sale newSale(Sale s) {
        return saleRepository.save(s);
    }

    public List<Sale> getSales(){
        return saleRepository.findAll();
    }

    public Sale updateSale(Sale saleUpdated, Integer id) {
        Sale sale = saleRepository.getReferenceById(id);
        sale.setId_client(saleUpdated.getId_client());
        sale.setId_product(saleUpdated.getId_product());
        sale.setCantidad(saleUpdated.getCantidad());
        sale.setFecha(saleUpdated.getFecha());
        sale.setPrice(saleUpdated.getPrice());
        return saleRepository.save(sale);
    }

    public List<DTOClientsReport> getReportShoppingSales() throws JsonProcessingException {
        List<DTOClientsReport> listado = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:3001/clients";
        for (DTOReportShoppingClient c: saleRepository.getReportShoppingClients()) {
            ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl + "/" + c.getId_client(), String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.getBody());
            listado.add(new DTOClientsReport(c.getId_client(), root.path("name").asText(), root.path("lastname").asText(), c.getAmount()));
        }
        return listado;
    }

    public List<DTOSalesForDay> getReportSalesForDay() {return saleRepository.getReportSalesForDay(); }

    public DTOProductReport getProductMoreSell() throws JsonProcessingException {
        DTOProductMoreSale p = saleRepository.getProductMoreSell().get(0);
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:3000/products/"+p.getId_product();
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        return new DTOProductReport(p.getId_product(),root.path("name").asText(),p.getAmount());

    }


    public void deleteSale(int id) { saleRepository.deleteById(id); }
}

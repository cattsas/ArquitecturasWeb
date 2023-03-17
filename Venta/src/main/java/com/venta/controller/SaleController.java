package com.venta.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.venta.DTO.*;
import com.venta.model.Sale;
import com.venta.service.SaleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "Sales", description = "Servicio de ventas")
public class SaleController {
    @Qualifier("saleService")
    @Autowired
    private SaleService service;

    public SaleController(@Qualifier ("saleService") SaleService service){
        super();
        this.service = service;
    }

    //metodos para controller
    @GetMapping("/sales")
    public List<Sale> getAllSales(){
        return service.getSales();
    }

    @PostMapping("/sales")
    public Sale newSale(@RequestBody Sale s){
        return service.newSale(s);
    }
    //devolveria un listado de  ventas

    @PutMapping("/sales/{id}")
    Sale modifySale (@RequestBody Sale saleUpdated, @PathVariable Integer id) {return service.updateSale(saleUpdated,id);}

    @GetMapping("/sales/reportShoppingClients")
    public List<DTOClientsReport> getReportShoppingClients() throws JsonProcessingException { return service.getReportShoppingSales(); }

    @GetMapping("/sales/reportSalesForDay")
    public List<DTOSalesForDay> getReportSalesForDay(){ return service.getReportSalesForDay(); }

    @GetMapping("/sales/productMoreSell")
    public DTOProductReport getProductMoreSell() throws JsonProcessingException { return service.getProductMoreSell(); }

    @DeleteMapping("/sales/{id}")
    public ResponseEntity<?> deleteSale(@PathVariable(value="id")int id) {
        service.deleteSale(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

package com.venta.repository;

import com.venta.DTO.DTOProductMoreSale;
import com.venta.DTO.DTOReportShoppingClient;
import com.venta.DTO.DTOSalesForDay;
import com.venta.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

    @Query("SELECT new com.venta.DTO.DTOReportShoppingClient(s.id_client, SUM(s.price*s.cantidad)) FROM Sale s GROUP BY s.id_client")
    //@Query("SELECT new com.venta.DTO.DTOReportShoppingClient(s.id_client, SUM(s.price)) FROM Sale s GROUP BY s.id_client")
    List <DTOReportShoppingClient> getReportShoppingClients();

    @Query(value = "SELECT new com.venta.DTO.DTOSalesForDay(s.fecha, SUM(s.cantidad) , (s.price*s.cantidad)) FROM Sale s GROUP BY s.fecha, s.cantidad, s.price")
    List <DTOSalesForDay> getReportSalesForDay();

    @Query(value = "SELECT new com.venta.DTO.DTOProductMoreSale(s.id_product, SUM(s.cantidad)) FROM Sale s GROUP BY s.id_product ORDER BY SUM(s.cantidad) DESC")
    List<DTOProductMoreSale> getProductMoreSell();
}

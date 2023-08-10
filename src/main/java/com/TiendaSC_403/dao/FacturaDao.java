
package com.TiendaSC_403.dao;
import com.TiendaSC_403.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDao extends JpaRepository <Factura,Long> {
     
}

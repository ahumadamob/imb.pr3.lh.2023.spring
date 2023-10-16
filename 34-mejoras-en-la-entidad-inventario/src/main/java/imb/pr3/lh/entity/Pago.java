package imb.pr3.lh.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer clienteId;
    private Integer medioDePagoId;
    private LocalDateTime fechaDePago;
    private Double monto;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getClienteId() {
		return clienteId;
	}
	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
	public Integer getMedioDePagoId() {
		return medioDePagoId;
	}
	public void setMedioDePagoId(Integer medioDePagoId) {
		this.medioDePagoId = medioDePagoId;
	}
	public LocalDateTime getFechaDePago() {
		return fechaDePago;
	}
	public void setFechaDePago(LocalDateTime fechaDePago) {
		this.fechaDePago = fechaDePago;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}

    
}

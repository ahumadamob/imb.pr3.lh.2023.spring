package imb.pr3.lh.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Alquiler {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private Integer pagoId;
  private Integer clienteId;
  private Integer estacionSalidaId;
  private LocalDateTime fechaHoraSalida;
  private Integer estacionLlegadaId;
  private LocalDateTime fechaHoraLlegada;
  
  public Integer getId() {
	  return id;
  }
  public void setId(Integer id) {
	  this.id = id;
  }
  public Integer getPagoId() {
	  return pagoId;
  }
  public void setPagoId(Integer pagoId) {
	  this.pagoId = pagoId;
  }
  public Integer getClienteId() {
	  return clienteId;
  }
  public void setClienteId(Integer clienteId) {
	  this.clienteId = clienteId;
  }
  public Integer getEstacionSalidaId() {
	  return estacionSalidaId;
  }
  public void setEstacionSalidaId(Integer estacionSalidaId) {
	  this.estacionSalidaId = estacionSalidaId;
  }
  public LocalDateTime getFechaHoraSalida() {
	  return fechaHoraSalida;
  }
  public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
	  this.fechaHoraSalida = fechaHoraSalida;
  }
  public Integer getEstacionLlegadaId() {
	  return estacionLlegadaId;
  }
  public void setEstacionLlegadaId(Integer estacionLlegadaId) {
	  this.estacionLlegadaId = estacionLlegadaId;
  }
  public LocalDateTime getFechaHoraLlegada() {
	  return fechaHoraLlegada;
  }
  public void setFechaHoraLlegada(LocalDateTime fechaHoraLlegada) {
	  this.fechaHoraLlegada = fechaHoraLlegada;
  } 
}

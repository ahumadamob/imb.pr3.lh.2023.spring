package imb.pr3.lh.entity;

import java.time.LocalDateTime;

import entity.Estacion;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Alquiler {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  @ManyToOne
  @JoinColumn(name = "pago_id")
  private Pago pago;
  
  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;
  
  @ManyToOne
  @JoinColumn(name = "estacion_salida_id")
  private Estacion estacionSalida;
  
  @NotBlank(message = "La fecha y hora de salida no pueden estar vacios")
  private LocalDateTime fechaHoraSalida;
  
  @ManyToOne
  @JoinColumn(name = "estacion_llegada_id")
  private Estacion estacionLlegada;
  
  @NotBlank(message = "La fecha y hora de llegada no pueden estar vacios")
  private LocalDateTime fechaHoraLlegada;

  public Integer getId() {
	  return id;
  }

  public void setId(Integer id) {
	  this.id = id;
  }

  public Pago getPago() {
	  return pago;
  }

  public void setPago(Pago pago) {
	  this.pago = pago;
  }

  public Cliente getCliente() {
	  return cliente;
  }

  public void setCliente(Cliente cliente) {
	  this.cliente = cliente;
  }

  public Estacion getEstacionSalida() {
	  return estacionSalida;
  }

  public void setEstacionSalida(Estacion estacionSalida) {
	  this.estacionSalida = estacionSalida;
  }

  public LocalDateTime getFechaHoraSalida() {
	  return fechaHoraSalida;
  }

  public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
	  this.fechaHoraSalida = fechaHoraSalida;
  }

  public Estacion getEstacionLlegada() {
	  return estacionLlegada;
  }

  public void setEstacionLlegada(Estacion estacionLlegada) {
	  this.estacionLlegada = estacionLlegada;
  }

  public LocalDateTime getFechaHoraLlegada() {
	  return fechaHoraLlegada;
  }

  public void setFechaHoraLlegada(LocalDateTime fechaHoraLlegada) {
	  this.fechaHoraLlegada = fechaHoraLlegada;
  }
}
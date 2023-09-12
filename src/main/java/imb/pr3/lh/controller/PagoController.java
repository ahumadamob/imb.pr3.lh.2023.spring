package imb.pr3.lh.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import imb.pr3.lh.entity.Pago;
import imb.pr3.lh.service.PagoService;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping("")
    public List<Pago> mostrarTodos() {
        return pagoService.mostrarTodos();
    }

    @GetMapping("/{id}")
    public Pago mostrarPorId(@PathVariable Integer id) {
        return pagoService.mostrarPorId(id);
    }

    @PostMapping("/")
    public Pago crear(@RequestBody Pago pago) {
        return pagoService.crearPago(pago);
    }

    @PutMapping("/{id}")
    public Pago modificar(@PathVariable Integer id, @RequestBody Pago pago) {
        return pagoService.modificarPago(id, pago);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        pagoService.eliminarPago(id);
    }
    
}

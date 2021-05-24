package dom;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
  Map<CriterioDePrenda, Guardarropas> mapGuardarropas;

  public Usuario() {
    this.mapGuardarropas = new HashMap<>();
  }


  public void agregarPrendaSegunCriterio(CriterioDePrenda criterio, Prenda prenda) {
    obtenerGuardarropas(criterio).agregarPrenda(prenda);
  }

  public Guardarropas obtenerGuardarropas(CriterioDePrenda criterio) {
    return mapGuardarropas.get(criterio);
  }


  public void crearGuardarropas(CriterioDePrenda criterio) {
    Guardarropas guardarropas = new Guardarropas();
    agregarGuardarropas(criterio, guardarropas);
  }

  public void agregarGuardarropas(CriterioDePrenda criterio, Guardarropas guardarropas) {
    mapGuardarropas.put(criterio, guardarropas);
  }

  private void compartirGuardarropas(CriterioDePrenda crit, Guardarropas guard, Usuario us) {
    us.agregarGuardarropas(crit, guard);
  }

  public void crarYCompartirGuardarropasConUsuario(CriterioDePrenda criterio, Usuario otroUsuario) {
    this.crearGuardarropas(criterio);
    compartirGuardarropas(criterio, obtenerGuardarropas(criterio), otroUsuario);
  }

  public void proponerAgregarPrenda(CriterioDePrenda criterio, Prenda prenda) {
    obtenerGuardarropas(criterio).proponer(new AgregarPrenda(prenda));
  }

  public void proponerQuitarPrenda(CriterioDePrenda criterio, Prenda prenda) {
    obtenerGuardarropas(criterio).proponer(new QuitarPrenda(prenda));
  }

}

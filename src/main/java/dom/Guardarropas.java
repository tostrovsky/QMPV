package dom;

import java.util.ArrayList;
import java.util.List;

public class Guardarropas {
  private List<Prenda> prendas;
  private List<Propuesta> propuestas;
  private List<Propuesta> propuestasAceptadas;

  public Guardarropas() {
    this.prendas = new ArrayList<>();
    this.propuestas = new ArrayList<>();
    this.propuestasAceptadas = new ArrayList<>();
  }

  public void agregarPrenda(Prenda prenda) {
    this.prendas.add(prenda);
  }

  public void removerPrenda(Prenda prenda) {
    this.prendas.remove(prenda);
  }

  public void proponer(Propuesta unaPropuesta) {
    this.propuestas.add(unaPropuesta);
  }

  public Propuesta leerPropuesta() {
    Propuesta propuesta = this.propuestas.get(0);
    this.propuestas.remove(propuesta);
    return propuesta;
  }

  public void aceptarPropuesta(Propuesta unaPropuesta) {
    unaPropuesta.modificarGuardarropas(this);
    agregarPropuestaAceptada(unaPropuesta);
  }

  public void rechazarPropuesta(Propuesta unaPropuesta) {
  }

  public void deshacerPropuesta(Propuesta unaPropuesta) {
    unaPropuesta.deshacerPropuesta(this);
    removerPropuestaAceptada(unaPropuesta);
  }

  public List<Propuesta> getPropuestas() {
    return propuestas;
  }

  private void agregarPropuestaAceptada(Propuesta unaPropuesta) {
    this.propuestasAceptadas.add(unaPropuesta);
  }

  private void removerPropuestaAceptada(Propuesta unaPropuesta) {
    this.propuestasAceptadas.remove(unaPropuesta);
  }

  public List<Prenda> getPrendas() {
    return this.prendas;
  }

  public List<Propuesta> getPropuestasAceptadas() {
    return propuestasAceptadas;
  }
}

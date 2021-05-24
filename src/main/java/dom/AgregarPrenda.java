package dom;

public class AgregarPrenda implements Propuesta {

  private Prenda unaPrenda;

  public AgregarPrenda(Prenda unaPrenda) {
    this.unaPrenda = unaPrenda;
  }

  public void modificarGuardarropas(Guardarropas guardarropas) {
    guardarropas.agregarPrenda(unaPrenda);
  }

  public void deshacerPropuesta(Guardarropas guardarropas) {
    guardarropas.removerPrenda(unaPrenda);
  }

  public void rechazarPropuesta(Guardarropas guardarropas) {
  }
}

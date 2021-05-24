package dom;

public class QuitarPrenda implements Propuesta {

  private Prenda unaPrenda;

  public QuitarPrenda(Prenda unaPrenda) {
    this.unaPrenda = unaPrenda;
  }

  public void modificarGuardarropas(Guardarropas guardarropas) {
    guardarropas.removerPrenda(unaPrenda);
  }

  public void deshacerPropuesta(Guardarropas guardarropas) {
    guardarropas.agregarPrenda(unaPrenda);
  }

  public void rechazarPropuesta(Guardarropas guardarropas) {
  }
}

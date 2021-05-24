package dom;

public interface Propuesta {

  void modificarGuardarropas(Guardarropas guardarropas);

  void deshacerPropuesta(Guardarropas guardarropas);

  void rechazarPropuesta(Guardarropas guardarropas);
}

import dom.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static dom.CriterioDePrenda.*;
import static org.junit.jupiter.api.Assertions.*;

public class GuardarropasTest {

  Usuario tomas;
  Usuario shrek;
  Prenda remeritaFacha;
  Prenda pantalonTurro;
  Prenda buzoVerdePasto;
  Prenda sombreroDePaja;
  Guardarropas guardarropasRaves;
  Propuesta agregarSombreroDePaja;
  Propuesta quitarSombreroDePaja;

  @BeforeEach
  void setUp() {
    remeritaFacha = remeritaFacha();
    pantalonTurro = pantalonTurro();
    buzoVerdePasto = buzoVerdePasto();
    sombreroDePaja = sombreroDePaja();

    tomas = new Usuario();
    tomas.crearGuardarropas(DE_VIAJE);
    tomas.crearGuardarropas(ENTRE_CASA);
    tomas.agregarPrendaSegunCriterio(DE_VIAJE, remeritaFacha);
    tomas.agregarPrendaSegunCriterio(DE_VIAJE, pantalonTurro);
    tomas.agregarPrendaSegunCriterio(ENTRE_CASA, sombreroDePaja);
    shrek = new Usuario();

    tomas.crarYCompartirGuardarropasConUsuario(PARA_FIESTAS_ELECTRONICAS, shrek);
    guardarropasRaves = tomas.obtenerGuardarropas(PARA_FIESTAS_ELECTRONICAS);
  }

  @Test
  public void ElUsuarioPuedeManejarDistintosGuardarropasSegunCriterio() {
    Guardarropas guardarropasDeViaje = tomas.obtenerGuardarropas(DE_VIAJE);
    Guardarropas guardarropasEntreCasa = tomas.obtenerGuardarropas(ENTRE_CASA);
    assertNotEquals(guardarropasDeViaje, guardarropasEntreCasa);
    assertTrue(guardarropasDeViaje.getPrendas().contains(pantalonTurro));
    assertFalse(guardarropasEntreCasa.getPrendas().contains(pantalonTurro));
  }

  @Test
  public void TomasCreaYComparteUnGuardarropasParaFiestasElectronicasConShrek() {
    assertEquals(tomas.obtenerGuardarropas(PARA_FIESTAS_ELECTRONICAS), shrek.obtenerGuardarropas(PARA_FIESTAS_ELECTRONICAS));
  }

  public Prenda remeritaFacha() {
    return new Prenda();
  }

  public Prenda pantalonTurro() {
    return new Prenda();
  }

  public Prenda buzoVerdePasto() {
    return new Prenda();
  }

  public Prenda sombreroDePaja() {
    return new Prenda();
  }

  @Test
  public void ShrekProponeAgregarElBuzoPastoAlGuardarropasParaFiestasElectronicas() {
    shrek.proponerAgregarPrenda(PARA_FIESTAS_ELECTRONICAS, buzoVerdePasto);
    assertTrue(guardarropasRaves.getPropuestas().get(0) instanceof AgregarPrenda);
  }

  @Test
  public void ShrekProponeQuitarElSombreroDePajaAlGuardarropasParaFiestasElectronicas() {
    tomas.agregarPrendaSegunCriterio(PARA_FIESTAS_ELECTRONICAS, sombreroDePaja);
    shrek.proponerQuitarPrenda(PARA_FIESTAS_ELECTRONICAS, sombreroDePaja);
    assertTrue(guardarropasRaves.getPropuestas().get(0) instanceof QuitarPrenda);
  }

  @Test
  public void ShrekProponeAgregarPrendaYAlguienAcepta() {
    shrek.proponerAgregarPrenda(PARA_FIESTAS_ELECTRONICAS, sombreroDePaja);
    agregarSombreroDePaja = guardarropasRaves.leerPropuesta();
    guardarropasRaves.aceptarPropuesta(agregarSombreroDePaja);
    assertTrue(guardarropasRaves.getPrendas().contains(sombreroDePaja));
  }

  @Test
  public void ShrekProponeQuitarPrendaYAlguienAcepta() {
    tomas.agregarPrendaSegunCriterio(PARA_FIESTAS_ELECTRONICAS, sombreroDePaja);
    //inicialmente el sombrero esta en el guardarropas
    shrek.proponerQuitarPrenda(PARA_FIESTAS_ELECTRONICAS, sombreroDePaja);
    quitarSombreroDePaja = guardarropasRaves.leerPropuesta();
    guardarropasRaves.aceptarPropuesta(quitarSombreroDePaja);
    //ya no esta mas
    assertFalse(guardarropasRaves.getPrendas().contains(sombreroDePaja));
  }

  @Test
  public void ShrekProponeAgregarPrendaYAlguienRechaza() {
    shrek.proponerAgregarPrenda(PARA_FIESTAS_ELECTRONICAS, sombreroDePaja);
    agregarSombreroDePaja = guardarropasRaves.leerPropuesta();
    guardarropasRaves.rechazarPropuesta(agregarSombreroDePaja);
    //perdon shrek era malisima la idea
    assertFalse(guardarropasRaves.getPrendas().contains(sombreroDePaja));
  }

  @Test
  public void SeDeshaceLaPropuestaAceptadaDeShrekDeAgregarPrendaAlGuardarropas() {
    shrek.proponerAgregarPrenda(PARA_FIESTAS_ELECTRONICAS, sombreroDePaja);
    agregarSombreroDePaja = guardarropasRaves.leerPropuesta();
    guardarropasRaves.aceptarPropuesta(agregarSombreroDePaja);
    assertTrue(guardarropasRaves.getPrendas().contains(sombreroDePaja));
    assertTrue(guardarropasRaves.getPropuestas().isEmpty());
    assertFalse(guardarropasRaves.getPropuestasAceptadas().isEmpty());
    //se acepto la propuesta. ahora la saco
    guardarropasRaves.deshacerPropuesta(agregarSombreroDePaja);
    assertFalse(guardarropasRaves.getPrendas().contains(sombreroDePaja));
    //se la saque
  }

}

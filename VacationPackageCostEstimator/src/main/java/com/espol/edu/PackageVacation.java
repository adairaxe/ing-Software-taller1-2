// Copyright (C) 2020
package com.espol.edu;

@SuppressWarnings("PMD.UseUtilityClass")
public class PackageVacation {
	// ... (atributos y constructores existentes)
	private static final int BASE_PRICE = 1000;
	private static final int MAX_TRAVELERS = 80;
	private static final int ADDITIONAL_COST_PARIS = 500;
	private static final int ADDITIONAL_COST_NEW_YORK = 600;
	private static final int GROUP_DISCOUNT_THRESHOLD_LOW = 4;
	private static final int GROUP_DISCOUNT_THRESHOLD_HIGH = 10;
	private static final double GROUP_DISCOUNT_RATE_LOW = 0.10;
	private static final double GROUP_DISCOUNT_RATE_HIGH = 0.20;
	private static final int PENALTY_FEE_DURATION_THRESHOLD = 7;
	private static final int PENALTY_FEE_AMOUNT = 200;
	private static final int PROMOTION_THRESHOLD_DURATION = 30;
	private static final int PROMOTION_THRESHOLD_TRAVELERS = 2;
	private static final int PROMOTION_AMOUNT = 200;
	private static final int ALL_INCLUSIVE_COST = 200;
    private static final int ADVENTURE_ACTIVITIES_COST = 200;
    private static final int SPA_WELLNESS_COST = 200;
    private static final String PARIS = "Paris";
    private static final String NEW_YORK = "New York City";
    private static final String ALL_PACKAGE = "All-Inclusive Package";
    private static final String ADVENTURE_PACKAGE= "Adventure Activities Package";
    private static final String SPA_PACKAGE= "Spa and Wellness Package";
/**
* Destino del paquete de vacaciones.
*/
   private String destination;

   /**
    * Número de viajeros en el paquete de vacaciones.
    */
   private int numberOfTravelers;

   /**
    * Duración del paquete de vacaciones en días.
    */
   private int duration;
   /**
    * Descripción de complementos.
    */
   private String addOns;

   /**
    * Constructor para crear un objeto PackageVacation.
    *
    * @param newdestination      Destino del paquete de vacaciones.
    * @param travelers Número de viajeros en el pa
    * @param newDestination          Duración del paquete de vacaciones en días.
    */
   public PackageVacation(final String newdestination, final int travelers,
final int newDestination, final String addOns) {
       this.destination = newdestination;
       this.numberOfTravelers = travelers;
       this.duration = newDestination;
       this.addOns = addOns;
   }

  /**
   * Obtiene el destino del paquete de vacaciones.
   *
   * @return El destino del paquete de vacaciones.
   */
  public String getDestination() {
      return destination;
  }
  /**
   * Establece el destino del paquete de vacaciones.
   *
   * @param newDestination El destino del paquete de vacaciones.
   */
  public void setDestination(final String newDestination) {
      this.destination = newDestination;
  }

  /**
   * Obtiene el numero de viajeros del paquete de vacaciones.
   *
   * @return El numero de viajeros del paquete de vacaciones.
   */
  public int getNumberOfTravelers() {
      return numberOfTravelers;
  }

  /**
   * Establece el número de viajeros del paquete de vacaciones.
   *
   * @param travelers El número de viajeros del paquete de va
   */
  public void setNumberOfTravelers(final int travelers) {
      this.numberOfTravelers = numberOfTravelers;
  }

  /**
   * Obtiene la duracion del paquete de vacaciones.
   *
   * @return El numero la duracion del paquete de vacaciones.
   */
  public int getDuration() {
      return duration;
  }

  /**
   * Establece el destino del paquete de vacaciones.
   *
   * @param newduration La duración del paquete de vacaciones.
   */
  public void setDuration(final int newduration) {
      this.duration = duration;
  }
  
  
  	public String getAddOns() {
		return addOns;
	}

	public void setAddOns(final String addOns) {
		this.addOns = addOns;
	}
  /**
   * Convierte el objeto PackageVacation a una representación de cadena.
   * Esta implementación proporciona una representación legible de los atributos
   * de la clase. Las clases que extiendan PackageVacation deben asegurarse
   * de mantener esta estructura y proporcionar
   * @return Representación de cadena del objeto PackageVacation.
   */
  @Override
  public String toString() {
      return "PackageVacation{"
  +
              "destination='" + destination + '\''
              +
              ", numberOfTravelers=" + numberOfTravelers
              +
              ", duration=" + duration
              +
              '}';
  }

  /**
   * Calcula el precio.
   * @return Representación de cadena del objeto PackageVacation.
   */

  public int calculatePackagePrice() {

    if (numberOfTravelers > MAX_TRAVELERS) {
        return -1; // Paquete no disponible
    }
    int additionalCost = 0;
    // Aplicar costo adicional basado en el destino
    if (PARIS.equals(destination)) {
        additionalCost += ADDITIONAL_COST_PARIS;
    } else if (NEW_YORK.equals(destination)) {
        additionalCost += ADDITIONAL_COST_NEW_YORK;
    }
    
    int groupDiscount = 0;
    final int basePrice = BASE_PRICE;
    if (numberOfTravelers > GROUP_DISCOUNT_THRESHOLD_LOW && numberOfTravelers
<
GROUP_DISCOUNT_THRESHOLD_HIGH) {
        groupDiscount = (int) (BASE_PRICE * GROUP_DISCOUNT_RATE_LOW);
    } else if (numberOfTravelers > GROUP_DISCOUNT_THRESHOLD_HIGH) {
        groupDiscount = (int) (BASE_PRICE * GROUP_DISCOUNT_RATE_HIGH);
    }

    int penaltyFee = 0;
	int promotion = 0;
    // Aplicar penalización por duración insuficiente
    if (duration < PENALTY_FEE_DURATION_THRESHOLD) {
        penaltyFee += PENALTY_FEE_AMOUNT;
    }

    // Aplicar promoción
    if (duration > PROMOTION_THRESHOLD_DURATION || numberOfTravelers == PROMOTION_THRESHOLD_TRAVELERS) {
        promotion = PROMOTION_AMOUNT;
    }

    // Calcular el precio total
    int totalCost = basePrice + additionalCost - groupDiscount + penaltyFee - promotion;

    if (ALL_PACKAGE.equals(addOns)) {
        totalCost = totalCost + (ALL_INCLUSIVE_COST * numberOfTravelers);
    }

    if (ADVENTURE_PACKAGE.equals(addOns)) {
        totalCost = totalCost + (ADVENTURE_ACTIVITIES_COST * numberOfTravelers);
    }

    if (SPA_PACKAGE.equals(addOns)) {
        totalCost = totalCost + (SPA_WELLNESS_COST * numberOfTravelers);
    }
    
    // Asegurarse de que el precio no sea negativo
    return totalCost;

  }


}


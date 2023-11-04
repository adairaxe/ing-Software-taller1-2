// Copyright (C) 2020
package com.espol.edu;

public class PackageVacation {
/**
     * Precio base para el paquete de vacaciones.
     */
private static final int BASE_PRICE = 1000;
/**
 * Precio base para el paquete de vacaciones.
 */
private 
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
    * Constructor para crear un objeto PackageVacation.
    *
    * @param newdestination      Destino del paquete de vacaciones.
    * @param newnumberOfTravelers Número de viajeros en el pa
    * @param newDestination          Duración del paquete de vacaciones en días.
    */
   public PackageVacation(final String newdestination,
final int newnumberOfTravelers,
final int newDestination) {
       this.destination = newdestination;
       this.numberOfTravelers = newnumberOfTravelers;
       this.duration = newDestination;
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
   * @param newnumberOfTravelers El número de viajeros del paquete de va
   */
  public void setNumberOfTravelers(final int newnumberOfTravelers) {
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
int basePrice = BASE_PRICE;
    int additionalCost = 0;
    int groupDiscount = 0;
    int penaltyFee = 0;
    int promotion = 0;

    if (numberOfTravelers > MAX_TRAVELERS) {
        return -1; // Paquete no disponible
    }

    // Aplicar costo adicional basado en el destino
    if (destination.equals("Paris")) {
        additionalCost += ADDITIONAL_COST_PARIS;
    } else if (destination.equals("New York City")) {
        additionalCost += ADDITIONAL_COST_NEW_YORK;
    }

    // Aplicar descuento de grupo
    if (numberOfTravelers > GROUP_DISCOUNT_THRESHOLD_LOW && numberOfTravelers
<
GROUP_DISCOUNT_THRESHOLD_HIGH) {
        groupDiscount = (int) (BASE_PRICE * GROUP_DISCOUNT_RATE_LOW);
    } else if (numberOfTravelers > GROUP_DISCOUNT_THRESHOLD_HIGH) {
        groupDiscount = (int) (BASE_PRICE * GROUP_DISCOUNT_RATE_HIGH);
    }

    // Aplicar penalización por duración insuficiente
    if (duration < PENALTY_FEE_DURATION_THRESHOLD) {
        penaltyFee += PENALTY_FEE_AMOUNT;
    }

    // Aplicar promoción
    if (duration > PROMOTION_THRESHOLD_DURATION
||
   numberOfTravelers == PROMOTION_THRESHOLD_TRAVELERS) {
        promotion = PROMOTION_AMOUNT;
    }

    // Calcular el precio total
int totalCost = basePrice + additionalCost
-
groupDiscount + penaltyFee - promotion;

    // Asegurarse de que el precio no sea negativo
    if (totalCost > 0) {
        return totalCost;
    } else {
      return 0;
    }

  }
}


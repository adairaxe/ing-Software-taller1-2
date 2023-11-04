package com.espol.edu;
/**
 * Main class for the application.
 */
@SuppressWarnings("PMD.UseUtilityClass")
public final class Main {
	/**
     * Main method to start the application.
     *
     * @param args Command line arguments.
     */
	public static void main(final String[] args) {
        final PackageVacation pv1 = new PackageVacation("Paris", 4, 5, "All-Inclusive Package");
        System.out.println(pv1.calculatePackagePrice());

    }
}


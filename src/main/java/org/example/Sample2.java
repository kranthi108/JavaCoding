package org.example;

import java.util.Arrays;
 class ShipmentDaysCalculator {
    public int calculateShipmentDays(int[] shipments) {
        Arrays.sort(shipments); // Sort the array in ascending order
        int days = 0;
        int warehouses = shipments.length;

        while (warehouses > 0) {
            int minShipment = shipments[0]; // Minimum shipment count
            days++; // Increment the day count

            for (int i = 0; i < shipments.length; i++) {
                shipments[i] -= minShipment; // Subtract the minimum shipment count
                if (shipments[i] > 0) {
                    // Warehouse still has shipments remaining
                    warehouses--;
                }
            }

            Arrays.sort(shipments); // Re-sort the array after subtracting minimum shipments
        }

        return days;
    }

    public static void main(String[] args) {
        ShipmentDaysCalculator calculator = new ShipmentDaysCalculator();
        int[] shipments = {4, 2, 3, 3, 3};
        System.out.println("Number of days to ship all shipments: " + calculator.calculateShipmentDays(shipments)); // Output: 3
    }
}

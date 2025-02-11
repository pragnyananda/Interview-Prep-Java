package com.example.demo.interviews.wayfair;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Enum for Package Types
enum PackageType {
    STANDARD, FRAGILE, HAZARDOUS
}

// Strategy Interface for Space Requirement
interface SpaceRequirementStrategy {
    double calculateSpace(double volume);
}

// Concrete Space Requirement Strategies
class StandardSpaceRequirement implements SpaceRequirementStrategy {
    public double calculateSpace(double volume) {
        return volume * 1.2;
    }
}

class FragileSpaceRequirement implements SpaceRequirementStrategy {
    public double calculateSpace(double volume) {
        return volume * 1.5;
    }
}

class HazardousSpaceRequirement implements SpaceRequirementStrategy {
    public double calculateSpace(double volume) {
        return volume * 1.25;
    }
}

// Factory for Space Requirement Strategy
class SpaceRequirementFactory {
    public static SpaceRequirementStrategy getStrategy(PackageType type) {
        switch (type) {
            case STANDARD: return new StandardSpaceRequirement();
            case FRAGILE: return new FragileSpaceRequirement();
            case HAZARDOUS: return new HazardousSpaceRequirement();
            default: throw new IllegalArgumentException("Invalid package type");
        }
    }
}

// Strategy Interface for Shipping Charges
interface ShippingChargesStrategy {
    double calculateTransportationCost(double volume);
    double calculateServiceCharge(double distance, double weight);
}

// Concrete Shipping Charges Strategies
class StandardShippingCharges implements ShippingChargesStrategy {
    public double calculateTransportationCost(double volume) {
        return volume * 0.05;
    }
    public double calculateServiceCharge(double distance, double weight) {
        return distance * 0.5 + weight * 0.5;
    }
}

class FragileShippingCharges implements ShippingChargesStrategy {
    public double calculateTransportationCost(double volume) {
        return volume * 0.07;
    }
    public double calculateServiceCharge(double distance, double weight) {
        return distance * 0.75 + weight * 0.75;
    }
}

class HazardousShippingCharges implements ShippingChargesStrategy {
    public double calculateTransportationCost(double volume) {
        return volume * 0.06;
    }
    public double calculateServiceCharge(double distance, double weight) {
        return distance * 0.625 + weight * 0.625;
    }
}

// Factory for Shipping Charges Strategy
class ShippingChargesFactory {
    public static ShippingChargesStrategy getStrategy(PackageType type) {
        switch (type) {
            case STANDARD: return new StandardShippingCharges();
            case FRAGILE: return new FragileShippingCharges();
            case HAZARDOUS: return new HazardousShippingCharges();
            default: throw new IllegalArgumentException("Invalid package type");
        }
    }
}

// Package Class
class Package {
    private String id;
    private PackageType type;
    private double weight, length, width, height;

    public Package(String id, PackageType type, double weight, double length, double width, double height) {
        this.id = id;
        this.type = type;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getVolume() {
        return length * width * height;
    }

    public double getSpaceRequired() {
        return SpaceRequirementFactory.getStrategy(type).calculateSpace(getVolume());
    }

    public double getTransportationCost() {
        return ShippingChargesFactory.getStrategy(type).calculateTransportationCost(getVolume());
    }

    public double getServiceCharge(double distance) {
        return ShippingChargesFactory.getStrategy(type).calculateServiceCharge(distance, weight);
    }
}

// Cargo Management Class
public class CargoManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double distance = Double.parseDouble(scanner.nextLine().trim());
        List<Package> packages = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) break;

            String[] data = line.split(" ");
            if (data.length != 6) continue;

            packages.add(new Package(
                    data[0],
                    PackageType.valueOf(data[1].toUpperCase()),
                    Double.parseDouble(data[2]),
                    Double.parseDouble(data[3]),
                    Double.parseDouble(data[4]),
                    Double.parseDouble(data[5])
            ));
        }
        scanner.close();

        double totalSpace = 0, totalTransportCost = 0, totalServiceCharge = 0;

        for (Package pkg : packages) {
            totalSpace += pkg.getSpaceRequired();
            totalTransportCost += pkg.getTransportationCost();
            totalServiceCharge += pkg.getServiceCharge(distance);
        }

        double totalCost = totalTransportCost + totalServiceCharge;

        System.out.printf("Total Space: %.2f\n", totalSpace);
        System.out.printf("Transportation Cost: %.2f\n", totalTransportCost);
        System.out.printf("Service Charges: %.2f\n", totalServiceCharge);
        System.out.printf("Total Cost: %.2f\n", totalCost);
    }
}

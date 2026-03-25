package Tuto3;
/**
 * Interface representing the ADT for a single AC installation bid.
 */
public interface BidInterface {
    /**
     * Returns the name of the company making this bid.
     * return The company name as a String.
     */
    String getCompanyName();

    /**
     * Returns the description of the air conditioner that this bid is for.
     * return The AC unit description.
     */
    String getDescription();

    /**
     * Returns the capacity of this bid's AC in tons.
     * precondition: The unit performance must be stored in BTU.
     * post-condition: Returns capacity where 1 ton = 12,000 BTU.
     * return The capacity in tons.
     */
    double getCapacityInTons();

    /**
     * Returns the seasonal efficiency of this bid's AC (SEER).
     * return The SEER rating as a double.
     */
    double getSeerRating();

    /**
     * Returns the cost of the AC unit itself.
     * return The unit cost.
     */
    double getUnitCost();

    /**
     * Returns the cost of installing the AC unit.
     * return The installation cost.
     */
    double getInstallationCost();

    /**
     * Calculates and returns the projected yearly cost of operating this AC.
     * precondition: SEER and Capacity must be non-zero.
     * return The estimated annual operating cost.
     */
    double getYearlyOperatingCost();
}
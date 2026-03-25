package Tuto3;
/**
 * Interface representing the ADT for a collection of AC installation bids.
 */
public interface BidCollectionInterface {

    /**
     * Adds a new bid to the collection.
     * @param newBid The BidInterface object to be added.
     * precondition: newBid is not null.
     * post-condition: The collection size increases by 1.
     */
    void addBid(BidInterface newBid);

    /**
     * Returns the bid in this collection with the lowest yearly operating cost.
     * precondition: The collection is not empty.
     * return The BidInterface object with the best efficiency.
     */
    BidInterface getBestYearlyCostBid();

    /**
     * Returns the bid with the best initial cost (Unit Cost + Installation).
     * precondition: The collection is not empty.
     * post-condition: Identifies the bid where (unitCost + installCost) is minimum.
     * return The BidInterface object with the lowest upfront cost.
     */
    BidInterface getBestInitialCostBid();

    /**
     * Removes all bids from the collection.
     * post-condition: The collection size is 0 and isEmpty() returns true.
     */
    void clear();

    /**
     * Gets the number of items currently in this collection.
     * return The integer count of bids.
     */
    int getSize();

    /**
     * Checks if the collection contains any bids.
     * return True if the collection is empty, false otherwise.
     */
    boolean isEmpty();
}
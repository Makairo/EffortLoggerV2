package application;

import java.util.ArrayList;
import java.util.List;

public class BacklogItem {

    // Method to search for items in the backlog system by name and estimates
    public static List<ActivityItem> searchItems(String itemName, int targetEstimate) {
        List<ActivityItem> foundItems = new ArrayList<>();

        // Loop through all items in the database
        for (ActivityItem item : ActivityItem.PPDatabase) {
            // Check if the item name matches
            if (item.getName().equals(itemName)) {
                // Check if the target estimate is present in the estimates list
                if (item.getEstimates().contains(targetEstimate)) {
                    // Add the found item to the list
                    foundItems.add(item);
                }
            }
        }

        return foundItems;
    }

    // Method to display the details of an ActivityItem
    public static void displayItemDetails(ActivityItem item) {
        if (item != null) {
            System.out.println("Item Details:");
            System.out.println("Name: " + item.getName());
            System.out.println("Average: " + item.getAverage());
            System.out.println("Estimates: " + item.getEstimates());
            System.out.println("Criteria:\n" + item.getCriteria());
        } else {
            System.out.println("Item not found in the backlog system.");
        }
    }
}

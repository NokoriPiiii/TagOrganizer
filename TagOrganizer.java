import java.util.*;

public class TagOrganizer {
    private Map<String, Set<String>> tagMap;

    public TagOrganizer() {
        tagMap = new HashMap<>();
    }

    // Add a tag to an item
    public void addTag(String item, String tag) {
        tagMap.putIfAbsent(item, new HashSet<>());
        tagMap.get(item).add(tag.toLowerCase());
    }

    // Remove a tag from an item
    public void removeTag(String item, String tag) {
        if (tagMap.containsKey(item)) {
            tagMap.get(item).remove(tag.toLowerCase());
        }
    }

    // Get all tags for an item
    public Set<String> getTags(String item) {
        return tagMap.getOrDefault(item, Collections.emptySet());
    }

    // Find items by tag
    public List<String> findItemsByTag(String tag) {
        List<String> results = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : tagMap.entrySet()) {
            if (entry.getValue().contains(tag.toLowerCase())) {
                results.add(entry.getKey());
            }
        }
        return results;
    }

    // Display all items and their tags
    public void displayAll() {
        for (Map.Entry<String, Set<String>> entry : tagMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        TagOrganizer organizer = new TagOrganizer();

        // Demo usage
        organizer.addTag("Document1.txt", "Java");
        organizer.addTag("Document1.txt", "OOP");
        organizer.addTag("Document2.txt", "AI");
        organizer.addTag("Document2.txt", "Java");

        System.out.println("Tags for Document1.txt: " + organizer.getTags("Document1.txt"));
        System.out.println("Items tagged with 'Java': " + organizer.findItemsByTag("Java"));

        organizer.displayAll();
    }
}

TagOrganizer organizer = new TagOrganizer();
organizer.addTag("Document1.txt", "Java");
organizer.addTag("Document1.txt", "OOP");
organizer.addTag("Document2.txt", "AI");

System.out.println(organizer.getTags("Document1.txt"));
// Output: [java, oop]

System.out.println(organizer.findItemsByTag("Java"));
// Output: [Document1.txt, Document2.txt]

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String category;
    private boolean isAvailable;

    public Book(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

class Member {
    private String name;
    private String email;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(String title, String author, String category) {
        Book book = new Book(title, author, category);
        books.add(book);
    }

    public void addMember(String name, String email) {
        Member member = new Member(name, email);
        members.add(member);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void issueBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book '" + book.getTitle() + "' issued to " + member.getName());
        } else {
            System.out.println("Book '" + book.getTitle() + "' not available");
        }
    }

    public void returnBook(Book book, Member member) {
        if (!book.isAvailable()) {
            book.setAvailable(true);
            System.out.println("Book '" + book.getTitle() + "' returned by " + member.getName());
        } else {
            System.out.println("Book '" + book.getTitle() + "' is already available");
        }
    }

    public void browseBooks() {
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Category: " + book.getCategory());
            System.out.println("Availability: " + (book.isAvailable() ? "Available" : "Not available"));
            System.out.println("-----------------------------");
        }
    }
}

public class DigitalLibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of books to add: ");
        int numBooks = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 1; i <= numBooks; i++) {
            System.out.println("Enter details for Book " + i);
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Author: ");
            String author = scanner.nextLine();
            System.out.print("Category: ");
            String category = scanner.nextLine();

            library.addBook(title, author, category);
        }

        System.out.print("Enter the number of members to add: ");
        int numMembers = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= numMembers; i++) {
            System.out.println("Enter details for Member " + i);
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();

            library.addMember(name, email);
        }

        System.out.println("Enter the index of the book to issue: ");
        int bookIndex = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the index of the member: ");
        int memberIndex = scanner.nextInt();
        scanner.nextLine(); 

        Book book = library.getBooks().get(bookIndex);
        Member member = library.getMembers().get(memberIndex);
        library.issueBook(book, member);
        library.returnBook(book, member);
        library.browseBooks();
    }
}

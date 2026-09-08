public class Library {
    public static void main(String[] args) {
        Book book = new Book("Nguen Nhat Anh",1999,"Nguen Nhat Anh - Mat biec");
        Library library = new Library();
        library.displayBookInfo(book);
        // thêm phạm vi static vào hàm hiển thị để có thể họi hàm mà không cần tạo library
        // vì hàm main có phạm vi static nên không thấy được hàm hiển thị
    }

    void displayBookInfo(Book book){
        System.out.println("Title: "+ book.title);
        System.out.println("Author: "+ book.author);
        System.out.println("Publication Year: "+ book.publicationYear);

    }
}

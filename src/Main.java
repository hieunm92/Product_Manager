import Model.Product;
import Service.ProductManager;
import com.sun.security.jgss.InquireSecContextPermission;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ProductManager productManager = new ProductManager();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("---Menu---");
            System.out.println("1.Thêm và lưu sản phẩm ");
            System.out.println("2.Hiển thị sản phẩm");
            System.out.println("3.Tìm sản phẩm");
            System.out.println("4.Xoá sản phẩm");
            System.out.println("5.Sửa sản phẩm");
            System.out.println("6.Sắp xếp sản phẩm");
            System.out.println("0.Thoát ");
            System.out.println("Nhập lựa chọn");
            choice= Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Số lượng sản phẩm cần thêm:");
                    int number = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < number; i++) {
                        addNew();
                    }
                    break;
                case 2:
                    productManager.displayProduct();
                    break;
                case 3:
                    System.out.println("Mời bạn nhập id của sản phẩm cần tìm kiếm");
                    int id = scanner.nextInt();
                    productManager.findProductById(id);
                    break;
                case 4:
                    System.out.println("Nhập tên sản phẩm:");
                    String name = scanner.nextLine();
                    productManager.deleteProductByName(name);
                    break;
                case 5:
                    editProduct();
                    break;
                case 6:
                    productManager.sortByPrice();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        } while (choice != 0);
    }

    public static void addNew() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sản phẩm: ");
        String name = sc.nextLine();
        System.out.println("Nhập nhà sản xuất: ");
        String producer = scanner.nextLine();
        System.out.println("Nhập giá tiền: ");
        int price = Integer.parseInt(sc.nextLine());
        Product product = new Product(id, name, producer, price);
        productManager.addProduct(product);
        System.out.println("-----------------------------");
    }

    public static void editProduct() {
        System.out.println("nhap index");
        int index = Integer.parseInt(scanner.nextLine());
        Product product = new Product(123, "thanh", "sx1", 100);
        productManager.edit(index, product);
    }
}

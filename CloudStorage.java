import java.util.Scanner;
class CloudStorage {
    int space;
    int acno;
    double bill;
    
    CloudStorage(int s, int a ) {
        space = s;
        acno = a;
        bill = 0.0;
    }
    void accept() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter space in GB:");
        space = sc.nextInt();
        System.out.println("Enter account number:");
        acno = sc.nextInt();
    }
    void calculateBill() {
        if (space <= 15) {
            bill = space * 15;
        } else if (space <= 30) {
            bill = 15 * 15 + (space - 15) * 12;
        } else {
            bill = 15 * 15 + 15 * 12 + (space - 30) * 10;
        }
    }void display() {
        System.out.println("Account Number: " + acno);
        System.out.println("Space Used (GB): " + space);
        System.out.println("Total Bill: $" + bill);
    }
    public static void main(String[] args) {
        CloudStorage cs = new CloudStorage(10, 4512);
        cs.accept();
        cs.calculateBill();
        cs.display();
    }
  
}
package examjp1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {
    private String customerCode;
    private String customerName;
    public int accNumber;
    private long amount;

    public void input() {
        Scanner scanner = new Scanner(System.in);
        boolean customerCodestandard = false;
        boolean accNumberstandard = false;
        while (!customerCodestandard) {
            System.out.print("Nhập mã khách hàng: ");
            String customerCodeInput = scanner.nextLine();
            if (customerCodeInput.length() != 5) {
                System.out.println("Mã khách hàng phải chứa 5 kí tự");
                continue;
            }
            customerCodestandard = true;
            customerCode = customerCodeInput;
        }
        System.out.print("Nhập tên khách hàng: ");
        customerName = scanner.nextLine();
        while (!accNumberstandard) {
            System.out.print("Nhập Số tài khoản : ");
            String accNumberInput = scanner.nextLine();
            Pattern pattern = Pattern.compile("[0-9]+");
            Matcher matcher = pattern.matcher(accNumberInput);

            if (!matcher.matches()) {
                System.out.println("số tài khoản phải dạng số");
                continue;
            }
            if (accNumberInput.length() != 6) {
                System.out.println("số tài khoản phải chứ 5 kí tự");
                continue;
            }
            if (!accNumberInput.startsWith("100")) {
                System.out.println("số tài khoản phải bắt đầu bằng 100");
                continue;
            }
            accNumberstandard = true;
            accNumber = Integer.parseInt(accNumberInput);
        }
    }public void depositAndWithdraw(long amount, int type) {
        if (type == 0) {
            if (amount < 0) {
                System.out.println("Số tièn phải là só dương");
                return;
            }
            this.amount += amount;
            return;
        }
        if (amount > 0 && amount < this.amount) {
            this.amount -= amount;
            return;
        }
        System.out.println("Bạn không đủ tiền");
    }

    @Override
    public String toString() {
        return String.format("customerCode = %s customerName = %s accNumber = %d amount = %d", customerCode, customerName, accNumber, amount);
    }
}

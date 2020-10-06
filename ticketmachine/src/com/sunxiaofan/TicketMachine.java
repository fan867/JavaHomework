package com.sunxiaofan;
import java.util.Scanner;

public class TicketMachine {
    private int price;
    private int balance;
    private int total;

    public TicketMachine()
    {
        price = 5;
        balance = 0;
        total = 0;
    }
    public int getPrice()
    {
        return price;
    }

    public int getBalance()
    {
        return balance;
    }

    public int getTotal()
    {
        return total;
    }

    public void receiveMoney(int insert)
    {
        if(insert > 0){
            balance += insert;
            System.out.println("Your balance:" + balance);
        }
        else{
            System.out.println("Invalid!");
        }

    }


    public void printTicket()
    {
        if(balance > 0){
            int n;

            System.out.println("Do you want to print a ticket?('1' for 'Yes'/'0' for 'No')");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            if (choice ==1){
                System.out.println("How many tickets do you want to buy?");
                input = new Scanner(System.in);
                int num = input.nextInt();
                int totalPrice = price * num;

                if(totalPrice <= balance){
                    balance -= totalPrice;
                    total += totalPrice;
                    System.out.println("********************");
                    if(num == 1){
                        System.out.println("ONE TICKET.");
                    }else{
                        System.out.println(num + " TICKETS.");
                    }
                    System.out.println("Price = " + totalPrice);
                    System.out.println("Balance = " + balance);
                    System.out.println("********************");
                }else{
                    System.out.println("There is not enough balance!");
                }
            }
        }
        else{
            System.out.println("There is not enough balance!");
        }
    }

    public void refundMoney()
    {
        int refund = balance;

        balance = 0;
        System.out.println("Refund : "+ refund);
    }
    
    public void reSet()
    {
        System.out.println("Total turnover is "+ total);
        
        total = 0;
    }

    public static void main(String[] args) {
        TicketMachine tk = new TicketMachine();

        System.out.println("Please put money:");
        Scanner input = new Scanner(System.in);
        int insert = input.nextInt();
        
        tk.receiveMoney(insert);
        tk.printTicket();
        tk.refundMoney();
    }
}

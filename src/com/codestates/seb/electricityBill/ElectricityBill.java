package com.codestates.seb.electricityBill;

import java.util.Scanner;

public class ElectricityBill {
  public static void main(String[] args) {
    System.out.println("=".repeat(25));
    System.out.println(" 주택용 전기요금(저압) 계산기 ");
    System.out.println("=".repeat(25));

    //TODO:

    Scanner sc = new Scanner(System.in);
    System.out.println("[안내] 전기 사용량(KWh) 입력해주세요.");
    double electricQuantity = sc.nextDouble();

    // 1, 100 이하인 경우 전력당 60.7 원이 부가됩니다. (사용한 전력 100 kWh 이하일 경)
    double [] BASIC_FEE = {100*60.7, 100*125.9, 100*187.9, 100*280.6, 100*417.7, 100*670.6};
    double [] USE_FEE = {60.7, 125.9, 187.9, 280.6, 417.7, 670.6};


    double price = 0.0;
    if (electricQuantity <= 100) {
      price = electricQuantity * USE_FEE[0];
    } else if (electricQuantity <= 200) {
      price = BASIC_FEE[0] + (electricQuantity - 100)* USE_FEE[1];
    } else if (electricQuantity <= 300) {
      price = BASIC_FEE[0] + BASIC_FEE[1] + (electricQuantity - 200)* USE_FEE[2];
    } else if (electricQuantity <= 400) {
      price = BASIC_FEE[0] + BASIC_FEE[1] + BASIC_FEE[2] + (electricQuantity - 300)* USE_FEE[3];
    } else if (electricQuantity <= 500) {
      price = BASIC_FEE[0] + BASIC_FEE[1] + BASIC_FEE[2] + BASIC_FEE[3] + (electricQuantity - 400)* USE_FEE[4];
    } else if (electricQuantity <= 600) {
      price = BASIC_FEE[0] + BASIC_FEE[1] + BASIC_FEE[2] + BASIC_FEE[3] + BASIC_FEE[4] + (electricQuantity - 500)* USE_FEE[5];
    }
    System.out.println("전기 사용량은 : " + electricQuantity + "KWh, 요금은 " + price + " 원 입니다");
  }
}

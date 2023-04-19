/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;


public class Manager extends Employee
{
   private double bonus;

   
   public Manager(String name, double salary, int year, int month, int day)
   {
      super(name, salary, year, month, day);
      bonus = 0;
   }
    
   
   public void setBonus(double bonus)
   {
      this.bonus = bonus;
   }

   
   public double getTotalPay()
   {
      double baseSalary = super.getSalary();
      return baseSalary + bonus;
   }
   
   
   @Override
   public String toString()
   {
      return super.toString() + "[totalpay = " + getTotalPay() + "]";
   }
}

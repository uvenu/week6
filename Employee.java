/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;

import java.time.*;


public class Employee {
    
   private static int nextId = 1001;
   private String name;
   private double salary;
   private LocalDate hireDate;
   private int id;


   public Employee(String name, double salary, int year, int month, int day)
   {
      this.name = name;
      this.salary = salary;
      hireDate = LocalDate.of(year, month, day);
      setId(); 
   }
   
   
   private void setId()
   {
      id = nextId; // set id to next available id
      nextId++;
   }
   
    
   public String getName()
   {
      return name;
   }

   
   public double getSalary()
   {
      return salary;
   }

   
   public LocalDate getHireDate()
   {
      return hireDate;
   }

   
   public static int getNextId()
   {
      return nextId; // returns static field
   }

   
   public int getId()
   {
      return id;
   }
   
   
   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
   }
   
   
   @Override
   public String toString()
   {
      return getClass().getName() + " [ID = " + id + ", name = " + name + ", salary = " + salary+ ", hireday = " + hireDate + "]";
   }

   
}

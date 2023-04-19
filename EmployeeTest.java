/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package employee;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author salah
 */
public class EmployeeTest {

    //Instantiates an ArrayList
    //The ArrayList is populated in the getEmployeeData() method
    ArrayList<Employee> employeeList = new ArrayList<>();
    
    //Method to check if an input in empty
    private boolean isEmpty(String param)
    {
        if (param.equals(""))
        {
            System.out.println("Invalid response. Try again...");
            return true;
        }    
        else
            return false;
            
    }        
      
    //Method to check if all characters in an input are numeric
    private boolean isNumeric(String param)
    {
	for (int i = 0; i < param.length(); i++)
    	{
    	    if (!Character.isDigit(param.charAt(i)))
		return false;
	}

	return true;
    }
    
    //Method to check if a numeric input value is within a valid range
    private boolean isValid(String param, int lowerLimit, int upperLimit)
    {   
        int val;
        
        try {
            val = Integer.parseInt(param);
        } //If the input is a nonnumeric value, an Exception will thrown, which will be caught in the Catch block
        catch (NumberFormatException e) {
            //Nonnumberic input is not acceptable
            System.out.println("Invalid response. Try again...");
            return false;
        }
        //We could use the isNumeric() method instead of the above Try Catch block
        
        if (val < lowerLimit || val > upperLimit) 
        {
            System.out.println("Invalid response. Try again...");
            return false;
        }   
        else
            return true;
    }
    
    
    //The following method asks the user to enter information about employees, which is used to create Employee objects
    //Those objects are then added to the ArrayList   
    private int getEmployeeData()
    {
        String name;
        int salary;
        int day;
        int month;
        int year;
        int payRise;
        double bonus;
        
        int count = 0;
        boolean isManager;     
        boolean exit = false;
        
        Scanner inText = new Scanner(System.in);
        
        //This While loops runs until the user chooses not to continue
        while (exit == false)
        {  
            String response;
                        
            //This Do While loop will run until the user enters either 0 or 1 
            do {
                System.out.print("\nPlease enter employee type (press 0 for regular employee, 1 for manager): "); 
                response = inText.nextLine();
            }
            while (!isValid(response, 0, 1));    
            
            //The value of the response variable is converted into an integer and then a boolean value 
            isManager = (Integer.parseInt(response) == 1);
            
            //This Do While loop will run until the user enters a nonempty and nonumeric input 
            do {
                System.out.print("Please enter employee name: ");
                name = inText.nextLine();
                
                if (isNumeric(name))
                   name = ""; 
            } 
            while (isEmpty(name));     
            
            System.out.print("Please enter employee salary: ");
            response = inText.nextLine();
            salary = Integer.parseInt(response);
            
            //The input value must be between 1 and 31 or less depending on the month
            System.out.print("Please enter employee hireday: ");
            response = inText.nextLine();
            day = Integer.parseInt(response);
            
            //The input value must be between 1 and 12
            System.out.print("Please enter employee hiremonth: ");
            response = inText.nextLine();
            month = Integer.parseInt(response);
            
            System.out.print("Please enter employee hireyear: ");
            response = inText.nextLine();
            year = Integer.parseInt(response);
            
            System.out.printf("Employee hire date: %d-%d-%d\n", day, month, year );
            
            System.out.print("Please enter employee pay rise(%): ");
            response = inText.nextLine();
            payRise = Integer.parseInt(response);
            
            if (!isManager)  
            {     
                Employee emp = new Employee(name, salary, year, month, day);
                emp.raiseSalary(payRise);
                //If the employee is a regular employee, no bonus will be applied
                employeeList.add(emp); //Employee object added to the ArrayList
            }                  
            else   
            {  
                Manager mngr = new Manager(name, salary, year, month, day);
                mngr.raiseSalary(payRise);
                //If the employee is a manager, then a bonus will be applied 
                System.out.print("Please enter employee bonus: ");
                response = inText.nextLine();
                bonus = Double.parseDouble(response);
                mngr.setBonus(bonus);
                employeeList.add(mngr); //Manager object added to the ArrayList
            }
            //Keeps track of the number of obejcts
            count++;
            
            System.out.print("\nDo you want to continue data entry? (press 0 for NO, 1 for YES): ");
            response = inText.nextLine();
            //The value of the reponse variable is converted into a boolean value
            exit = (Integer.parseInt(response) == 0); 
        }
       
        System.out.printf("\n%d new employee records created\n", count);
        
        return count;
    }
    
    
    private int showEmployeeData()
    {
        //Determines the size of the ArrayList
        int noEmployees =  employeeList.size();
        
        //The For loop will run until all elements were acceessed              
        for (int i = 0; i < noEmployees; i++)
        {    
            System.out.println(employeeList.get(i).toString());
        }
        
        return noEmployees;    
    }

    
    private Employee lookupEmployee(String name)
    {
        //Determines the size of the ArrayList
        int noEmployees = employeeList.size();
        
        //The For loop aims to run until all elements were acceessed  
        for (int i = 0; i < noEmployees; i++)
        {
            Employee curEmployee = employeeList.get(i);
            //When a match is found, the method will return; this will terminate the For loop prematurely
            if (curEmployee.getName().equals(name))
                return curEmployee;             
        } 
        
        //The program execution will reach this point if no match is found
        return null; //Returning a null value indicates no match
    }
    
    
    private void findEmployee()
    {
        String name;
        Scanner inText = new Scanner(System.in);
        
        //This Do While loop will run until the user enters a nonempty and nonumeric input 
        do {
               System.out.print("\nPlease enter an employee name to search: ");
               name = inText.nextLine();

               if (isNumeric(name))
                   name = ""; 
        } 
        while (isEmpty(name));    

        //Looking for match in the Arraylist
        Employee emp = lookupEmployee(name);

        if (emp == null) //A null value indicates no match
            System.out.println(name  + " is not an employee");
        else
        {   
            if (emp instanceof Employee)
                System.out.println(emp.getName()+ " is a regular employee with a salary of $" + emp.getSalary());
            else
                System.out.println(emp.toString()  + " is a manager with total pay of $" + ((Manager)emp).getTotalPay());
        }

    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        EmployeeTest app = new EmployeeTest(); 
        
        app.getEmployeeData();
        app.showEmployeeData();
        app.findEmployee();

    }
    
}

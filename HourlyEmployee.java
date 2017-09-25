/* An employee that earns by the hour */
public class HourlyEmployee extends Employee {
  
  /* the number of hours worked */
  private double hoursWorked;
  
  /* the amount paid per hour */
  private double hourlyRate;
  
  /* a constructor for hourly employee */
  public HourlyEmployee(String name) {
    super(name);
  }
  
  /* get the number of hours worked */
  public double getHoursWorked() {
    return hoursWorked;
  }
  
  /* get the amount paid per hour */
  public double getHourlyRate() {
    return hourlyRate;
  }
  
  /* change the number of hours worked */
  public void setHoursWorked(double hoursWorked) {
    this.hoursWorked = hoursWorked;
  }
  
  /* change the amount paid per hour */
  public void setHourlyRate(double hourlyRate) {
    this.hourlyRate = hourlyRate;
  }
  
  /* change the definition of salary to be (hours worked) * (hourly rate) */
  @Override
  public double getSalary() {
    return getHoursWorked() * getHourlyRate();
  }
}
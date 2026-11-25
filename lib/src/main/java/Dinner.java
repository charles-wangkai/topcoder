public class Dinner {
  public int payForMeal(int subtotal, int sales_tax_percent, int tip_percent) {
    int required = subtotal * 100 + (subtotal * sales_tax_percent + 50) / 100 * 100;
    int tip = subtotal * tip_percent;
    int exact = required + tip;

    int upper = Math.ceilDiv(exact, 10000) * 10000;
    int lower = upper - 10000;

    return ((lower >= required && exact - lower <= upper - exact) ? lower : upper) / 10000;
  }
}

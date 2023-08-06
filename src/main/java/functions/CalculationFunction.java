package functions;

import org.openqa.selenium.WebDriver;
import utilities.SeleniumHelpers;

import java.text.DecimalFormat;

public class CalculationFunction {
    protected WebDriver driver;
    protected SeleniumHelpers selenium;

    public CalculationFunction(WebDriver driver, SeleniumHelpers selenium) {
        this.driver = driver;
        this.selenium = selenium;
    }

    /**
     * Verify Grand Total
     *
     * @param quantityOfFirstProduct   quantityOfFirstProduct
     * @param unitPriceOfProduct1      unitPriceOfProduct1
     * @param firstRowOfProductTax     firstRowOfProductTax
     * @param firstRowOfCess           firstRowOfCess
     * @param quantityOfSecondProduct  quantityOfSecondProduct
     * @param unitPriceOfSecondProduct unitPriceOfSecondProduct
     * @param secondRowOfProductTax    secondRowOfProductTax
     * @param cessValueOfSecondProduct cessValueOfSecondProduct
     * @param
     * @return expectedGrandTotal
     */
    public String verifyExclusiveOrderAndInvoiceTransactionAmount(String quantityOfFirstProduct, String unitPriceOfProduct1, String firstRowOfProductTax, String firstRowOfCess, String quantityOfSecondProduct, String unitPriceOfSecondProduct, String secondRowOfProductTax, String cessValueOfSecondProduct, String product1discount, String product2Discount) {
        // Subtotal of product 1
        double subTotalOfProduct1 = Double.parseDouble(quantityOfFirstProduct) * Double.parseDouble(unitPriceOfProduct1);

        // Taxable value of Product 1
        double discountValue = subTotalOfProduct1 * (Double.parseDouble(product1discount)) / 100;
        double taxableValueOfProduct1 = subTotalOfProduct1 - discountValue;

        // Total tax amount of product 1
        double totalTaxOfFirstRow = taxableValueOfProduct1 * Double.parseDouble(firstRowOfProductTax) / 100;

        // Total Ces amount of product 1
        double cessAmountOfFirstProduct = taxableValueOfProduct1 * Double.parseDouble(firstRowOfCess) / 100;

        // Subtotal of product 2
        double subTotalOfSecondProduct = Double.parseDouble(quantityOfSecondProduct) * Double.parseDouble(unitPriceOfSecondProduct);

        // Taxable value of Product 2
        double discountValueOfSecondProduct = subTotalOfSecondProduct * (Double.parseDouble(product2Discount)) / 100;
        double taxableValueOfSecondProduct = subTotalOfSecondProduct - discountValueOfSecondProduct;

        // Get Final tax amount of product 2
        double finalTaxAmountOfSecondProduct = taxableValueOfSecondProduct * Double.parseDouble(secondRowOfProductTax) / 100;

        // Get Final css amount of product 2
        double cessAmountOfSecondProduct = taxableValueOfSecondProduct * Double.parseDouble(cessValueOfSecondProduct) / 100;

        // Get Final tax of product 1 and product 2
        double finalTax = totalTaxOfFirstRow + finalTaxAmountOfSecondProduct;

        // Get Final taxable amount of Product 1 and product 2
        double finalTaxAbleAmount = taxableValueOfProduct1 + taxableValueOfSecondProduct;

        // Get Final Cess amount of product 1 and product 2
        double finalCessAmount = cessAmountOfFirstProduct + cessAmountOfSecondProduct;

        // Get Total Final amount
        double finalTotal = finalTaxAbleAmount + finalTax + finalCessAmount;

        // Convert into one decimal after point
        String expectedGrandTotal = String.valueOf(Double.parseDouble(new DecimalFormat("##.#").format(finalTotal)));

        return expectedGrandTotal;
    }
    /**
     * Verify Grand Total
     *
     * @param quantityOfFirstProduct   quantityOfFirstProduct
     * @param unitPriceOfProduct1      unitPriceOfProduct1
     * @param firstRowOfProductTax     firstRowOfProductTax
     * @param firstRowOfCess           firstRowOfCess
     * @param quantityOfSecondProduct  quantityOfSecondProduct
     * @param unitPriceOfSecondProduct unitPriceOfSecondProduct
     * @param secondRowOfProductTax    secondRowOfProductTax
     * @param cessValueOfSecondProduct cessValueOfSecondProduct
     * @return actualGrandTotal
     */
    public String verifyInclusiveOrderAndInvoiceTransactionAmount(String quantityOfFirstProduct, String unitPriceOfProduct1, String firstRowOfProductTax, String firstRowOfCess, String quantityOfSecondProduct, String unitPriceOfSecondProduct, String secondRowOfProductTax, String cessValueOfSecondProduct, String product1Discount, String product2Discount) {
        // Get Product 1 Data
        double totalPriceOfProduct1 = Double.parseDouble(quantityOfFirstProduct) * Double.parseDouble(unitPriceOfProduct1);
        double totalPriceWithoutTax = totalPriceOfProduct1 * (Double.parseDouble(firstRowOfProductTax) / (100 + Double.parseDouble(firstRowOfProductTax)));
        double subTotalWithoutTax = totalPriceOfProduct1 - totalPriceWithoutTax;
        double discountValue = subTotalWithoutTax * Double.parseDouble(product1Discount) / 100;
        double totalTaxableValueAfterDiscount = subTotalWithoutTax - discountValue;
        double finalTaxOfProduct1 = totalTaxableValueAfterDiscount * Double.parseDouble(firstRowOfProductTax) / 100;
        double cessOfProduct1 = (totalTaxableValueAfterDiscount * Double.parseDouble(firstRowOfCess)) / 100;

        // Get Product 2 Data
        double totalPriceOfProduct2 = Double.parseDouble(quantityOfSecondProduct) * Double.parseDouble(unitPriceOfSecondProduct);
        double totalPriceWithoutTax2 = totalPriceOfProduct2 * (Double.parseDouble(secondRowOfProductTax) / (100 + Double.parseDouble(secondRowOfProductTax)));
        double subTotalWithoutTax2 = totalPriceOfProduct2 - totalPriceWithoutTax2;
        double discountValue2 = subTotalWithoutTax2 * Double.parseDouble(product2Discount) / 100;
        double totalTaxableValueAfterDiscount2 = subTotalWithoutTax2 - discountValue2;
        double finalTaxOfProduct2 = totalTaxableValueAfterDiscount2 * Double.parseDouble(secondRowOfProductTax) / 100;
        double cessOfProduct2 = (totalTaxableValueAfterDiscount2 * Double.parseDouble(cessValueOfSecondProduct)) / 100;

        // Get Final taxable amount of Product 1 and product 2
        double totalAmountOfProductWithoutTax = totalTaxableValueAfterDiscount + totalTaxableValueAfterDiscount2;
        double totalTaxAmount = finalTaxOfProduct1 + finalTaxOfProduct2;
        double totalCessAmount = cessOfProduct1 + cessOfProduct2;

        // Get Total Final amount
        double finalGrandTotal = totalAmountOfProductWithoutTax + totalTaxAmount + totalCessAmount;
        String actualGrandTotal = String.valueOf(Double.parseDouble(new DecimalFormat("##.#").format(finalGrandTotal)));
        return actualGrandTotal;
    }

    /**
     *  Get debit note Transaction amount
     * @param product1Price product price
     * @param product1Tax product 1 tax
     * @param product1Cess product 1 cess
     * @param product2Price product 2 price
     * @param product2Tax product 2 tax
     * @param product2Cess product 2 cess
     * @return final grand total amount
     */
    public Double getDebitAndCreditNoteTransactionAmount(String product1Price, String product1Tax, String product1Cess, String product2Price, String product2Tax, String product2Cess) {

        double totalTaxOfProduct1 = Double.parseDouble(product1Price) * Double.parseDouble(product1Tax) / 100;
        double cessOfProduct1 = Double.parseDouble(product1Price)*Double.parseDouble(product1Cess)/100;
        double totalTaxOfProduct2 = Double.parseDouble(product2Price) * Double.parseDouble(product2Tax) / 100;
        double cessOfProduct2 = Double.parseDouble(product2Price)*Double.parseDouble(product2Cess)/100;
        double finalTaxableValue =Double.parseDouble(product1Price)+ Double.parseDouble(product2Price);
        double finalCessValue = cessOfProduct1+ cessOfProduct2;
        double finalTax = totalTaxOfProduct1+ totalTaxOfProduct2;
        double finalGrandTotal = finalTaxableValue+finalCessValue+finalTax;
        return finalGrandTotal;
    }
}

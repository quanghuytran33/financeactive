package financeactive.computetax.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import financeactive.computetax.model.Bill;
import financeactive.computetax.model.Product;
import financeactive.computetax.service.BillService;
import financeactive.computetax.service.ProductService;
import org.junit.Assert;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class ComputeTaxdefs {

    private BillService service = new BillService(new ProductService());
    private Bill bill = new Bill();

    @Given("^a list of product$")
    public void give_products(List<Product> products) {
        bill.setProducts(products);
    }

    @When("^print bill$")
    public void printBill() throws Throwable {
        service.computeTotalTaxAmountAndPrice(bill);
    }

    @Then("^return products with price include tax$")
    public void returnProductsWithPriceIncludeTax(List<Product> products) throws Throwable {
        assertEquals(products.size(), bill.getProducts().size());
        for (int i = 0; i < products.size(); i++) {
            Product productExpected = products.get(i);
            Product productActual = bill.getProducts().get(i);

            assertEquals(productExpected.getFamilyProduct(), productActual.getFamilyProduct());
            assertEquals(productExpected.getLabel(), productActual.getLabel());
            assertEquals(productExpected.getPriceIncludeTax().stripTrailingZeros().toPlainString(),
                         productActual.getPriceIncludeTax().stripTrailingZeros().toPlainString());
        }
    }

    @And("^total price is ([0-9]+\\.[0-9]{2}) and tax amount is ([0-9]+\\.[0-9]{2})$")
    public void totalPriceIsAndTaxAmountIs(BigDecimal totalPrice, BigDecimal totalAmount) throws Throwable {
        assertEquals(bill.getTotalPrice().stripTrailingZeros().toPlainString(),
                     totalPrice.stripTrailingZeros().toPlainString());
        assertEquals(bill.getTotalTaxAmount().stripTrailingZeros().toPlainString(),
                     totalAmount.stripTrailingZeros().toPlainString());
    }
}

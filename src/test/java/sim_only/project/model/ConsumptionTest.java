package sim_only.project.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConsumptionTest {

    @Test
    public void whenSettingMonth_ExpectRightMonth() {
        var month = "13de maand";

        var consumption = new Consumption(month);

        Assert.assertEquals(month,consumption.getMonth());
    }

    @Test
    public void whenCalculating_expectRightCost() {
        var consumption = new Consumption("13de maand", 3040);

        consumption.calculateCosts();

        Assert.assertEquals(10.95,consumption.getCost(),0.001);
    }

    @Test
    public void whenSettingMBsLater_expectRightCost() {
        var consumption = new Consumption("13de maand");

        consumption.calculateCosts();
        consumption.setMbQuantity(3080);
        consumption.calculateCosts();

        Assert.assertEquals(11.95,consumption.getCost(),0.001);
    }
}
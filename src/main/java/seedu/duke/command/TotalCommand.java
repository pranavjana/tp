package seedu.duke.command;

import seedu.duke.ExpenseList;
import seedu.duke.Ui;

/**
 * Displays the total sum of all expenses.
 */
public class TotalCommand extends Command {

    @Override
    public void execute(ExpenseList expenses, Ui ui) {
        assert expenses != null : "ExpenseList should not be null";
        double total = expenses.getTotal();
        assert total >= 0 : "Total should not be negative";
        ui.showTotal(total);
    }
}

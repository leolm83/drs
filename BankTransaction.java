import java.time.LocalDate;
import java.util.Objects;

/**
 * BankTransaction
 */
public class BankTransaction {

    private final LocalDate date;
    private final double amount;
    private final String description;

    public BankTransaction(final LocalDate date, final double amount, final String description){
        this.date = date;
        this.amount = amount;
        this.description = description;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public double getAmount(){
        return this.amount;
    }
    public String getDescription(){
        return this.description;
    }

    @Override
    public String toString(){
        return "BankTransaction {" +
        "date= "+ this.date +
        ", amount= "+ this.amount +
        ", description= "+ this.description +
        "\n}";
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankTransaction that = (BankTransaction) o;
        return Double.compare(that.amount, amount) == 0 && date.equals(that.date) && description.equals(that.description);
    }


    @Override
    public int hashCode(){
        return Objects.hash(date, amount, description);
    }

}